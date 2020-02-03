INSERT INTO category (name) VALUES ('Finances');
INSERT INTO category (name) VALUES ('Recreation');
INSERT INTO category (name) VALUES ('Food');
INSERT INTO category (name) VALUES ('Study');
INSERT INTO category (name) VALUES ('Fitness');


INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Viviane Santelli", true, "Rua A", "22", "Apto 26", "Pituba", "Salvador", "BA", "40562254");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Maristela Cavalcante", true, "Rua B", "540", "Apto 6", "Caminho das Árvores", "Salvador", "BA", "40561254");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Bia Silveira", false, "Rua C", "45", "N/A", "Pituba", "Salvador", "BA", "40585412");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Vanessa Tarantelli", true, "Rua D", "958", "Apto 260", "Imbuí", "Salvador", "BA", "40584251");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Carla Magnato", false, "Rua E", "10", "N/A", "Ondina", "Salvador", "BA", "40854254");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Gabi Monteiro", true, "Rua F", "722", "Apto 504", "Pituba", "Salvador", "BA", "40562285");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Silvana Ribeiro", true, "Rua G", "222", "Apto 284", "Imbuí", "Salvador", "BA", "40554654");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Valeria Costa", false, "Rua H", "985", "Apto 568", "Pituba", "Salvador", "BA", "40585454");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Marcela Martins", true, "Rua I", "8745", "Apto 698", "Costa Azul", "Salvador", "BA", "40568544");

INSERT INTO people (name, active, street, number, complement, neighborhood, city, state, zipcode)
VALUES ("Kelly Fernandes", true, "Rua J", "8545", "Apto 895", "Barra", "Salvador", "BA", "40562984");


INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Monthly salary', '2017-06-10', null, 6500.00, 'Distribution of profits', 'REVENUE', 1, 1);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSE', 2, 2);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Top Club', '2017-06-10', null, 120, null, 'REVENUE', 3, 3);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Generation', 'REVENUE', 3, 4);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSE', 3, 5);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'REVENUE', 4, 6);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Bahamas', '2017-06-10', null, 500, null, 'REVENUE', 1, 7);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSE', 4, 8);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Forwarding agent', '2017-06-10', null, 123.64, 'Tickets', 'EXPENSE', 3, 9);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Tires', '2017-04-10', '2017-04-10', 665.33, null, 'REVENUE', 5, 10);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Coffee', '2017-06-10', null, 8.32, null, 'EXPENSE', 1, 5);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Eletronics', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSE', 5, 4);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Instruments', '2017-06-10', null, 1040.32, null, 'REVENUE', 4, 3);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Coffee', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSE', 4, 2);

INSERT INTO accounting_entry (description, due_date, payday, amount, note, type, id_category, id_people)
VALUES ('Snack', '2017-06-10', null, 10.20, null, 'EXPENSE', 4, 1);


INSERT INTO permission (description) VALUES ('administrator');

INSERT INTO permission (description) VALUES ('user');


INSERT INTO user (name, email, password, id_permission) VALUES ('Karls', 'karls@gmail.com', '123456', 1);

INSERT INTO user (name, email, password, id_permission) VALUES ('Anderson', 'anderson@outlook.com', '123456', 2);