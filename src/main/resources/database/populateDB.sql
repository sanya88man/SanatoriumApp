INSERT INTO users(username, password, enabled)
VALUES ('admin', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

insert into roles(id, role)
values (1, 'ROLE_ADMIN');

insert into roles(id, role)
values (2, 'ROLE_USER');

insert into users_roles(user_id, role_id)
values (1, 1);

insert into users_roles(user_id, role_id)
values (1, 2);

insert into users_roles(user_id, role_id)
values (2, 2);