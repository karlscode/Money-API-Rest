CREATE TABLE IF NOT EXISTS accounting_entry (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    due_date DATE NOT NULL,
    payday DATE,
    amount DECIMAL(10,2) NOT NULL,
    note VARCHAR(100),
    type ENUM('REVENUE','EXPENSE') NOT NULL,
    id_category BIGINT(20) NOT NULL,
    id_people BIGINT(20) NOT NULL,
    FOREIGN KEY (id_category) REFERENCES category(id),
    FOREIGN KEY (id_people) REFERENCES people(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
