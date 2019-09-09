INSERT INTO users (username, password, authority, enabled)
values ('viktor.mushak@gmail.com','$2a$10$9nol5e2bBx6Yll7/92MoD.D5hQ9QtyawlQC7faFA0DlgWP1L3yyNW', 'ROLE_USER', 1);

INSERT INTO profiles (user_id, name, surname, email, phone)
values (LAST_INSERT_ID(), 'Виктор','Мушак', 'viktor.mushak@gmail.com', '+380674649065');