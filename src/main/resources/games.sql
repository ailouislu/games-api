DROP TABLE IF EXISTS Genres;
CREATE TABLE Genres (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    slug VARCHAR(255),
    games_count INT,
    image_background VARCHAR(255)
);

DROP TABLE IF EXISTS platforms;
CREATE TABLE platforms (
   id INT(11) NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   slug VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS platform_games;
CREATE TABLE platform_games (
    id INT(11) NOT NULL AUTO_INCREMENT,
    platform_id INT(11) NOT NULL,
    game_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (platform_id) REFERENCES platforms(id),
    FOREIGN KEY (game_id) REFERENCES games(id)
);