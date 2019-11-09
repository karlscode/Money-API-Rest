DELETE FROM category;
DELETE FROM people;
DELETE FROM accounting_entry;

ALTER SEQUENCE category_id_seq RESTART WITH 1;
ALTER SEQUENCE people_id_seq RESTART WITH 1;
ALTER SEQUENCE accounting_entry_id_seq RESTART WITH 1;