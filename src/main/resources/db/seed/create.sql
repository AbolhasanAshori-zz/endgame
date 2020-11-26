create table authorities
(
    id        integer      not null auto_increment,
    authority varchar(255),
    email_ix  varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table game
(
    id        integer      not null auto_increment,
    content   TEXT         not null,
    image     varchar(255),
    title     varchar(255) not null,
    author_id integer,
    primary key (id)
) engine = InnoDB;
create table newsletter
(
    id    integer      not null auto_increment,
    email varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table rating
(
    id         integer not null auto_increment,
    difficulty float,
    gameplay   float,
    graphics   float,
    levels     float,
    overall    float,
    price      float,
    top        integer,
    game_id    integer not null,
    primary key (id)
) engine = InnoDB;
create table testimonial
(
    id        integer not null auto_increment,
    content   varchar(1000),
    author_id integer,
    game_id   integer not null,
    primary key (id)
) engine = InnoDB;
create table user
(
    id         integer              not null auto_increment,
    about      varchar(50),
    age        integer,
    email      varchar(255)         not null,
    enabled    tinyint(1) default 1 not null,
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255)         not null,
    profile    varchar(255),
    title      varchar(255),
    username   varchar(255)         not null,
    primary key (id)
) engine = InnoDB;
create index ix_auth_email on authorities (email_ix);
alter table newsletter
    add constraint ix_news_email unique (email);
alter table user
    add constraint ix_user_email unique (email);
alter table authorities
    add constraint FK17ckd3gjd6m862nnnthrwi2ds foreign key (email_ix) references user (email);
alter table game
    add constraint FKe4iwxhmcixp5vdfh85my9rwtk foreign key (author_id) references user (id);
alter table rating
    add constraint FKhotxgrgtrin4xcto6n1j4a946 foreign key (game_id) references game (id);
alter table testimonial
    add constraint FKescgajk268vq3dqoc3welxumv foreign key (author_id) references user (id);
alter table testimonial
    add constraint FKqwuc4ycwahn337jrvrs17rl7g foreign key (game_id) references game (id);

