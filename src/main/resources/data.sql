insert into users values('10@gmail.com', 'RESEARCH', 'Louis', 'Augustine');
insert into users values('20@gmail.com', 'RESEARCH', 'Tom', 'Smith');
insert into users values('30@gmail.com', 'SALES', 'James', 'Hudson');
insert into users values( '40@gmail.com','OPERATIONS', 'Peter', 'William');

INSERT INTO Genre (id, name, slug, games_count, image_background)
VALUES
    (1, 'Action', 'action', 100, 'action_background.jpg'),
    (2, 'Adventure', 'adventure', 50, 'adventure_background.jpg'),
    (3, 'RPG', 'rpg', 75, 'rpg_background.jpg'),
    (4, 'Simulation', 'simulation', 40, 'simulation_background.jpg');

INSERT INTO game (id, slug, name, added, genre_id)
VALUES
    (3498, 'grand-theft-auto-v', 'Grand Theft Auto V', 18995, 1),
    (3328, 'the-witcher-3-wild-hunt', 'The Witcher 3: Wild Hunt', 18127, 3),
    (5286, 'tomb-raider', 'Tomb Raider (2013)', 14967, 2),
    (4291, 'counter-strike-global-offensive', 'Counter-Strike: Global Offensive', 14774, 1),
    (12020, 'left-4-dead-2', 'Left 4 Dead 2', 14489, 1),
    (5679, 'the-elder-scrolls-v-skyrim', 'The Elder Scrolls V: Skyrim', 14391, 3);

INSERT INTO platform (id, name, slug)
VALUES
    (1, 'PC', 'pc'),
    (2, 'PlayStation 5', 'playstation5'),
    (3, 'PlayStation 4', 'playstation4'),
    (4, 'PlayStation 3', 'playstation3'),
    (5, 'PlayStation 2', 'playstation2'),
    (6, 'PlayStation', 'playstation1'),
    (7, 'PS Vita', 'ps-vita'),
    (8, 'PSP', 'psp'),
    (9, 'Xbox One', 'xbox-one'),
    (10, 'Xbox Series S/X', 'xbox-series-x'),
    (11, 'Xbox 360', 'xbox360'),
    (12, 'Xbox', 'xbox-old'),
    (13, 'iOS', 'ios'),
    (14, 'Android', 'android'),
    (15, 'macOS', 'macos'),
    (16, 'Classic Macintosh', 'macintosh'),
    (17, 'Apple II', 'apple-ii'),
    (18, 'Linux', 'linux'),
    (19, 'Nintendo Switch', 'nintendo-switch'),
    (20, 'Nintendo 3DS', 'nintendo-3ds')
-- and so on for the rest of the platforms
;

INSERT INTO platform_game (id, platform_id, game_id)
VALUES
    (100, 4, 3498),
    (101, 17, 3498),
    (102, 18, 3328),
    (103, 16, 3328),
    (104, 15, 5286),
    (105, 7, 5286),
    (106, 19, 4291),
    (107, 17, 12020);
