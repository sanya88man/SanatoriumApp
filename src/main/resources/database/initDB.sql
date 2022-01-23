create table users (
                       id int auto_increment not null,
                       username varchar (45) not null,
                       password varchar (60) not null,
                       enabled tinyint not null default 1,

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

                             foreign key (user_id) references users(id),
                             foreign key (role_id) references roles(id)

);

create table rooms (
  id int auto_increment not null,
  name varchar(45) not null,
  price decimal(10,4),
  primary key (id)
);

create table orders (
  id int auto_increment not null,
  person_amount int not null,
  arrive_date varchar(45),
  days_amount int not null,
  user_id int not null,
  room_id int not null,

  primary key (id),
  foreign key (user_id) references users(id),
  foreign key (room_id) references rooms(id)
);
