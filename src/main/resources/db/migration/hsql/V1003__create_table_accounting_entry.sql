CREATE TABLE accounting_entry (
    id BIGINT NOT NULL,
    description VARCHAR(50) NOT NULL,
    due_date DATE NOT NULL,
    payday DATE,
    amount DECIMAL(10,2) NOT NULL,
    note VARCHAR(100),
    type CHAR(7) NOT NULL,
    id_category BIGINT,
    id_people BIGINT
) ;