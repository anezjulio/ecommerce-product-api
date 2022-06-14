CREATE DATABASE kioskodb;

CREATE TABLE product(
    product_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR (255) NOT NULL,
    price int NOT NULL
);