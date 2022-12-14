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
    musician_id bigint not null,
    PRIMARY KEY (ID),
    CONSTRAINT fk_musicians_entity_data FOREIGN KEY (musician_id) references musicians(id)
);

CREATE TABLE webusers
(
    id bigint NOT NULL,
    username VARCHAR,
    password VARCHAR,
    role VARCHAR
);

CREATE TABLE songs(
    id bigint NOT NULL,
    song_Name VARCHAR,
    song_Genre VARCHAR,
    song_Year VARCHAR,
    is_Covered BOOLEAN
);

CREATE SEQUENCE hibernate_sequence start 1 increment 1;
CREATE TABLE event_repo(
        id bigint default nextval('hibernate_sequence'::regclass) not null,
        event_type varchar,
        call_date date,
        http_session_id varchar,
        cookie varchar,
        uri varchar,
        method_type varchar,
        remote_addr varchar
);