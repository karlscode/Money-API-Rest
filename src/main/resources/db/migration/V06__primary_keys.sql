ALTER TABLE category
    ADD CONSTRAINT Pk_category
    PRIMARY KEY (id);

ALTER TABLE people
    ADD CONSTRAINT Pk_people
    PRIMARY KEY (id);

ALTER TABLE accounting_entry
    ADD CONSTRAINT Pk_accounting_entry
    PRIMARY KEY (id);

ALTER TABLE user
    ADD CONSTRAINT Pk_user
        PRIMARY KEY (id);

ALTER TABLE permission
    ADD CONSTRAINT Pk_permission
        PRIMARY KEY (id);