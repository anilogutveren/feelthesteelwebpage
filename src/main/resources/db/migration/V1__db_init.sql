CREATE SEQUENCE seq_mus start 1 increment 1;
CREATE TABLE musicians
(
    id bigint NOT NULL default nextval('seq_mus'),
    name VARCHAR,
    equipments varchar,
    PRIMARY KEY (ID)
);

CREATE TABLE equipment
(
    id bigint NOT NULL,
    instrument VARCHAR,
    musician_entity_id bigint NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT fk_musicians_entity_data FOREIGN KEY (musician_entity_id) references musicians(id)
);

CREATE TABLE webusers
(
    id bigint NOT NULL,
    username VARCHAR,
    password VARCHAR,
    role VARCHAR
);