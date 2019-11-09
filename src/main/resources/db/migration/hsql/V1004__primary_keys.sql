ALTER TABLE category
    ADD CONSTRAINT Pk_category
    PRIMARY KEY (id);

ALTER TABLE people
    ADD CONSTRAINT Pk_people
    PRIMARY KEY (id);

ALTER TABLE accounting_entry
    ADD CONSTRAINT Pk_accounting_entry
    PRIMARY KEY (id);