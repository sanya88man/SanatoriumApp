create table users (
                       id int auto_increment not null,
                       username varchar (45) not null ,
                       password varchar (60) not null ,
                       enabled TINYINT not null default 1,

                       primary key (id),
                       unique (username)
);

create table roles (
                       id int auto_increment not null,
                       role varchar (45) not null,
                       primary key (id)
);

create table users_roles (
                             user_id int not null,
                             role_id int not null,

                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)

);

create table rooms (
  id int auto_increment not null,
  name varchar(45) NOT NULL,
  price DECIMAL(10,4),
  PRIMARY KEY(id)
);







/*create unique index users_username_index
    on users (username);*/

