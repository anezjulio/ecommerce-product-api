CREATE DATABASE kioskodb;

CREATE TABLE kioskodb.product(
    product_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR (255) NOT NULL,
    price int NOT NULL
);

INSERT INTO kioskodb.product (product_id, name, description, price)
VALUES (1, "hamburguesa","haburguesa de queso", 30 );


INSERT INTO kioskodb.product (product_id, name, description, price)
VALUES (2, "pizza","pizza de queso", 70 );


INSERT INTO kioskodb.product ( name, description, price)
VALUES ( "pizza","pizza de queso", 70 );