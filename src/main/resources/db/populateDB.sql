DELETE FROM user_roles;
DELETE FROM users;

INSERT INTO users (id, name, surname)
VALUES (727239620, 'Dmitriy', 'Davydov');

INSERT INTO user_roles (role, user_id)
VALUES ('ADMIN', 727239620);