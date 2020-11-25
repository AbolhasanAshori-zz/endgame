drop database if exists `endgame`;
create database `endgame`;

use `endgame`;

-- Create user table
create table `user`(
	id int primary key auto_increment,
	first_name varchar(100),
	last_name varchar(100),
    username varchar(100) not null,
    password varchar(100) not null,
	email varchar(50) not null,
	age int(2),
    enabled tinyint not null default 1
);

create unique index ix_user_email on user(email);

create table `authorities`(
	id int primary key auto_increment,
    email_ix varchar(50) not null,
    authority varchar(50) not null,
    foreign key(email_ix) references `user`(email)
);

create unique index ix_auth_email on authorities(email_ix, authority);

create table `newsletter`(
	id int primary key auto_increment,
    email varchar(200) not null
);

-- Create game table
create table `game`(
	id int primary key auto_increment,
    image varchar(500),
	title varchar(100) not null,
	content text not null,
	author_id int not null,
	foreign key (author_id) references user(id)
);

-- create rating table
create table `rating`(
	id int primary key auto_increment,
    game_id int not null,
    top int(3),
    price float(3),
    graphics float(3),
    levels float(3),
    gameplay float(3),
    difficulty float(3),
    overall float(3),
    foreign key (game_id) references game(id)
);

create table `testimonial`(
	id int primary key auto_increment,
	game_id int not null,
	content varchar(1000),
	author_id int,
	foreign key (game_id) references game(id),
    foreign key (author_id) references user(id)
);
