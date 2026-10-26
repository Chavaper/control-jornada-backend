-- @formatter:off
DROP TABLE IF EXISTS country;

CREATE TABLE country (
    id INTEGER NOT NULL
    , name VARCHAR(200) NOT NULL
    , nationality VARCHAR(200) NOT NULL

    , PRIMARY KEY (id)
    , UNIQUE(id)
    , UNIQUE(name)
);

INSERT INTO country (id, name, nationality) VALUES
    (1, 'Chile', 'Chilena');
