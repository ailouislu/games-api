DROP TABLE IF EXISTS app_user;
create table app_user(
  email      varchar(50),
  password        varchar(50),
  first_Name        varchar(50),
  last_Name        varchar(50),
  constraint pk_user primary key (email)
);

DROP TABLE IF EXISTS Genres;
CREATE TABLE Genres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    slug VARCHAR(255),
    games_count INT,
    image_background VARCHAR(255)
);