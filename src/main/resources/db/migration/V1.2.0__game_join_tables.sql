create table category
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table genre
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table platform
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table game_category
(
    game_id     integer not null,
    category_id integer not null
) engine = InnoDB;

create table game_genre
(
    genre_id integer not null,
    game_id  integer not null
) engine = InnoDB;

create table game_platform
(
    platform_id integer not null,
    game_id     integer not null
) engine = InnoDB;

alter table category
    add constraint ix_name unique (name);

alter table genre
    add constraint ix_name unique (name);

alter table platform
    add constraint ix_name unique (name);

alter table game_category
    add constraint FKpwnyxvfbvygley9396do8y7je foreign key (category_id) references category (id);
alter table game_category
    add constraint FKi70l5ew1q4xj6la2nyoyqbgvo foreign key (game_id) references game (id);
alter table game_genre
    add constraint FKj47t9lfhtj14lsg346bo3vujv foreign key (game_id) references game (id);
alter table game_genre
    add constraint FKfgiexxwmferkxqbwbjs989ea9 foreign key (genre_id) references genre (id);
alter table game_platform
    add constraint FK41jgum716ebufujj784qyop5r foreign key (game_id) references game (id);
alter table game_platform
    add constraint FK8ac70j8dic3po6vpmytx17bjl foreign key (platform_id) references platform (id);
