insert into users (username, password, enabled)
values ('admin', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
insert into users (username,password,enabled)
values ('alex', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

insert into roles (id, role)
values (1, 'ROLE_ADMIN');

insert into roles (id, role)
values (2, 'ROLE_USER');

insert into users_roles (user_id, role_id)
values (1, 1);

insert into users_roles (user_id, role_id)
values (1, 2);

insert into users_roles (user_id, role_id)
values (2, 2);


insert into rooms (name,price)
values ('2-ух местный', 99);
insert into rooms (name,price)
values ('2-ух местный люкс', 113);
insert into rooms (name,price)
values ('1-местный', 85);
insert into rooms (name,price)
values ('1-местный люкс', 107);
insert into rooms (name,price)
values ('2-ух местный 2-ух комнатный', 130);
insert into rooms (name,price)
values ('2-ух местный 2-ух комнатный люкс', 156);
insert into rooms (name,price)
values ('Коттедж', 275);