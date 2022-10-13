CREATE TABLE food(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    cost INT
);

CREATE TABLE order1(
    id BIGSERIAL PRIMARY KEY,
    date date,
    isReady BOOLEAN
);

CREATE TABLE order_and_food(
    id_of_oder int,
    id_of_food int
);

CREATE TABLE admins(
    id BIGSERIAL PRIMARY KEY,
    email varchar,
    password varchar
);

INSERT INTO food (name, cost) VALUES ('картошка',20);
INSERT INTO food (name, cost) VALUES ('бургер',40);
INSERT INTO food (name, cost) VALUES ('кола',15);
INSERT INTO food (name, cost) VALUES ('нагетсы',20);
INSERT INTO food (name, cost) VALUES ('чай',10);


INSERT INTO admins (email,password) VALUES ('q','q');


UPDATE order1 SET isReady=true WHERE id=1