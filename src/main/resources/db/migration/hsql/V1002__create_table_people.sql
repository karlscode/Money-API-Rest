CREATE TABLE IF NOT EXISTS people (
    id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL,
    street VARCHAR(30),
    number VARCHAR(5),
    complement VARCHAR(30),
    neighborhood VARCHAR(30),
    zipcode VARCHAR(8),
    city VARCHAR(30),
    state CHAR(2)
) ;
