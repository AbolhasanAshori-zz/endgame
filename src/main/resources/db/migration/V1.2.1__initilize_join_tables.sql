insert into category(name)
values ('Games'),
       ('Gaming Tips & Tricks'),
       ('Online Games'),
       ('Team Games'),
       ('Community'),
       ('Uncategorized');

insert into genre(name)
values ('Online'),
       ('Adventure'),
       ('S.F.'),
       ('Strategy'),
       ('Racing'),
       ('Shooter');


insert into platform(name)
values ('Xbox'),
       ('Xbox 360'),
       ('PlayStation'),
       ('PlayStation VR'),
       ('Nintendo Wii'),
       ('Nintendo Wii U');

INSERT INTO `game_category`(game_id, category_id)
VALUES (1,1),(1,3),(1,4),
       (2,2),
       (3,6),
       (4,1),(4,5),
       (5,1),(5,4),
       (6,1),
       (7,5),
       (8,1),(8,3),(8,4),(8,5),
       (9,6);

INSERT INTO `game_platform`(game_id, platform_id)
VALUES (1,1),(1,2),
       (2,1),(2,2),(2,3),(2,4),
       (3,5),(3,6),
       (4,1),
       (5,5),
       (6,3),(6,4),
       (7,2),(7,5),
       (8,1),(8,2),(8,3),(8,4),(8,5),(8,6),
       (9,6);

INSERT INTO `game_genre`(game_id, genre_id)
VALUES (1,3),(1,5),
       (2,1),(2,2),
       (3,6),
       (4,5),
       (5,1),(5,5),
       (6,2),
       (7,1),(7,3),
       (8,4),(8,6),
       (9,3),(9,6);