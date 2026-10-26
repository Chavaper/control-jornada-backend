-- @formatter:off
DROP TABLE IF EXISTS example;

CREATE TABLE example (
    id SERIAL PRIMARY KEY
    , name VARCHAR(255) NOT NULL
    , code VARCHAR(60) UNIQUE NOT NULL
    , description TEXT NULL
    , date DATE NULL
    , date_time TIMESTAMP NULL
    , active BOOLEAN NOT NULL
);


INSERT INTO example (name, code, description, date, active)
VALUES ('Template One', 'TPL001', 'This is the first example.', '2024-01-15', TRUE)
       , ('Template Two', 'TPL002', 'This is the second example.', '2024-02-20', FALSE)
       , ('Template Three', 'TPL003', 'This is the third example.', NULL, TRUE)
;
