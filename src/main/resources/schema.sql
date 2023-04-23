DROP TABLE IF EXISTS app_user;
create table app_user(
  email      varchar(50),
  password        varchar(50),
  first_Name        varchar(50),
  last_Name        varchar(50),
  constraint pk_user primary key (email)
);

DROP TABLE IF EXISTS Genre;
CREATE TABLE Genre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    slug VARCHAR(255),
    games_count INT,
    image_background VARCHAR(255)
);

DROP TABLE IF EXISTS Game;
CREATE TABLE Game (
   id INT PRIMARY KEY,
   slug VARCHAR(50),
   name VARCHAR(50),
   added INT,
   genre_id INT,
   FOREIGN KEY (genre_id) REFERENCES genre (id)
);

-- DROP TABLE IF EXISTS platform;
-- CREATE TABLE platform (
--    id INT(11) NOT NULL AUTO_INCREMENT,
--    name VARCHAR(255) NOT NULL,
--    slug VARCHAR(255) NOT NULL,
--    PRIMARY KEY (id)
-- );
--
-- DROP TABLE IF EXISTS platform_games;
-- CREATE TABLE platform_games (
--     id INT(11) NOT NULL AUTO_INCREMENT,
--     platform_id INT(11) NOT NULL,
--     game_id INT(11) NOT NULL,
--     PRIMARY KEY (id),
--     FOREIGN KEY (platform_id) REFERENCES platforms(id),
--     FOREIGN KEY (game_id) REFERENCES games(id)
-- );