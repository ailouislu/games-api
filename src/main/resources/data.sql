insert into app_user values('10@gmail.com', 'RESEARCH', 'Louis', 'Augustine');
insert into app_user values('20@gmail.com', 'RESEARCH', 'Tom', 'Smith');
insert into app_user values('30@gmail.com', 'SALES', 'James', 'Hudson');
insert into app_user values( '40@gmail.com','OPERATIONS', 'Peter', 'William');

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