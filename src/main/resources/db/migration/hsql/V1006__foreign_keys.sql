ALTER TABLE accounting_entry
    ADD CONSTRAINT Fk_accounting_entry_category
    FOREIGN KEY (id_category) REFERENCES category(id);

ALTER TABLE accounting_entry
    ADD CONSTRAINT Fk_accounting_entry_people
    FOREIGN KEY (id_people) REFERENCES people(id);