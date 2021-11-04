package com.andersen.tracker;

import com.andersen.tracker.telegram.TrackerBot;
import com.andersen.tracker.web.TeamServiceFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import soapservice.SOAPService;
import soapservice.SOAPclassComandService;


/**
 * Запускает приложение, здесь регистрируется и запускается телеграм бот.
 */
public class Application {
    public static void main(String[] args) {
        try {
            // создаем объект TelegramBotsApi для регистрации бота
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Регистрируем нашего созданного бота
            botsApi.registerBot(new TrackerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //проверка получения объекта SOAP сервис-команда
        SOAPService cs = TeamServiceFactory.getTeamService();
        System.out.println("\n\n\n" + cs != null + "\n\n\n\n");
    }
}

