DROP TABLE IF EXISTS pets, users;

CREATE TABLE pets(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    species VARCHAR(256)
);

CREATE TABLE users(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256),
    age INT,
    pet_id BIGINT references pets(id)
);