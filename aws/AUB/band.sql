CREATE TABLE band
(
    band_id          BIGINT       NOT NULL,
    band_name        VARCHAR(255) NOT NULL,
    genre            VARCHAR(255) NOT NULL,
    founding_date    date         NOT NULL,
    band_members     INTEGER      NOT NULL,
    dissolution_date date,
    CONSTRAINT pk_band PRIMARY KEY (band_id)
);