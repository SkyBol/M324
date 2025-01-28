CREATE TABLE album
(
    album_id     BIGINT       NOT NULL,
    title        VARCHAR(255) NOT NULL,
    band         BIGINT       NOT NULL,
    release_date date         NOT NULL,
    label        VARCHAR(255) NOT NULL,
    price        DECIMAL      NOT NULL,
    CONSTRAINT pk_album PRIMARY KEY (album_id)
);