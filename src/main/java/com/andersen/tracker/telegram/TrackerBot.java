package com.andersen.tracker.telegram;

import com.andersen.tracker.model.Role;
import com.andersen.tracker.model.User;
import com.andersen.tracker.servise.UserService.UserService;
import com.andersen.tracker.servise.UserService.UserServiceInMemoryImpl;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import java.util.List;
import java.util.stream.Collectors;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.ADMIN;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

/**
 * Класс обозначает телеграмм бота, в нем определяются
 * необходимые данные для связи с Telegram API, подключаются необходимые команды.
 */
public class TrackerBot extends AbilityBot {
    private static final String BOT_TOKEN = System.getenv("BOT_TOKEN");
    private static final String BOT_USERNAME = "TrackerBot";
    private static final UserService userService = new UserServiceInMemoryImpl();

    public TrackerBot() {
        super(BOT_TOKEN, BOT_USERNAME);
    }

    @Override
    public long creatorId() {
        return 727239620;
    }

    public Ability register() {
        return Ability
                .builder()
                .name("register")
                .info("Введите свое им и фамилию через пробел")
                .input(2)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    //проверка юзер уже есть в бд
                    if (userService.get(ctx.chatId()) == null) {
                        User newUser = new User(ctx.chatId(), ctx.firstArg(), ctx.secondArg());
                        userService.save(newUser);
                        silent.send("Вы зарегестрированы", ctx.chatId());
                    } else {
                        silent.send("Вы уже зарегестрированы", ctx.chatId());
                    }
                })
                .build();
    }

    public Ability edit() {
        return Ability
                .builder()
                .name("edit")
                .info("Отредактировать имя фамилию, для этого введите их через пробел")
                .input(2)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    //проверка юзер уже есть в бд
                    if (userService.get(ctx.chatId()) != null) {
                        User newUser = new User(ctx.chatId(), ctx.firstArg(), ctx.secondArg());
                        userService.save(newUser);
                        silent.send("Данные успешно изменены", ctx.chatId());
                    } else {
                        silent.send("Вы еще не зарегестрированы", ctx.chatId());
                    }
                })
                .build();
    }

    public Ability getAllUsers() {
        return Ability
                .builder()
                .name("users")
                .info("Список пользоватлей")
                .locality(ALL)
                .privacy(ADMIN)
                .action(ctx -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Список пользователей:\n");
                    for (User user : userService.getAll()) {
                        sb.append(user.getChatId());
                        sb.append("\t");
                        sb.append(user.getFirstName());
                        sb.append("\t");
                        sb.append(user.getLastName());
                        sb.append("\t");
                        sb.append(user.getRole());
                        sb.append("\n");
                    }
                    silent.send(sb.toString(), ctx.chatId());
                })
                .build();
    }

    public Ability deleteUser() {
        return Ability
                .builder()
                .name("delete")
                .info("Удаление пользователя, укажите нужный id")
                .input(1)
                .locality(ALL)
                .privacy(ADMIN)
                .action(ctx -> {
                    if (userService.delete(Long.parseLong(ctx.firstArg()))) {
                        silent.send("Пользователь успешно удален", ctx.chatId());
                    } else {
                        silent.send("Не удалось удалить пользователя", ctx.chatId());
                    }
                })
                .build();
    }

    public Ability getProfile() {
        return Ability
                .builder()
                .name("profile")
                .info("Получить информацию о своей учетной записи")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    User user = userService.get(ctx.chatId());
                    if (user != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(user.getChatId());
                        sb.append("\t");
                        sb.append(user.getFirstName());
                        sb.append("\t");
                        sb.append(user.getLastName());
                        sb.append("\t");
                        sb.append(user.getRole());
                        sb.append("\n");
                        silent.send(sb.toString(), ctx.chatId());
                    } else {
                        silent.send("Не удалось найти пользователя в БД", ctx.chatId());
                    }
                })
                .build();
    }

    public Ability getCommands() {
        return Ability
                .builder()
                .name("com")
                .info("Доступные команды")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    ctx.user();
                    if (userService.get(ctx.chatId()).getRole().equals(Role.ADMIN)) {
                        StringBuilder sb = new StringBuilder();
                        List<Ability> abilities = abilities().values().stream()
                                .filter(a -> a.privacy().equals(ADMIN))
                                .collect(Collectors.toList());
                        for (Ability ability : abilities) {
                            sb.append("/");
                            sb.append(ability.name());
                            sb.append(" - ");
                            sb.append(ability.info());
                            sb.append("\n");
                        }
                        silent.send(sb.toString(), ctx.chatId());
                    } else {
                        silent.send("Не удалось найти пользователя в БД", ctx.chatId());
                    }
                })
                .build();
    }
}
