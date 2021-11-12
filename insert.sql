INSERT INTO employee_kinds VALUES (1, 'waiter');
INSERT INTO employee_kinds VALUES (2, 'cook');

INSERT INTO employees VALUES (1, 'Karol', 'Sulkowski', 2);
INSERT INTO employees VALUES (2, 'Bartlomiej', 'Sudol', 2);
INSERT INTO employees VALUES (3, 'Adam', 'Sudol', 2);
INSERT INTO employees VALUES (4, 'Bartlomiej', 'Sulkowski', 2);
INSERT INTO employees VALUES (5, 'Adam', 'Rogozinski', 2);
INSERT INTO employees VALUES (6, 'Adam', 'Sulkowski', 1);
INSERT INTO employees VALUES (7, 'Adam', 'Rogozinski', 2);
INSERT INTO employees VALUES (8, 'Adam', 'Sudol', 2);
INSERT INTO employees VALUES (9, 'Karol', 'Sudol', 2);
INSERT INTO employees VALUES (10, 'Bartlomiej', 'Rogozinski', 2);

INSERT INTO tables VALUES (1, 'pod oknem');
INSERT INTO tables VALUES (2, 'przy drzwiach');
INSERT INTO tables VALUES (3, 'przy barze');

INSERT INTO product_categories VALUES (1, 'Drinks');
INSERT INTO product_categories VALUES (2, 'Meat');
INSERT INTO product_categories VALUES (3, 'Vegetables');
INSERT INTO product_categories VALUES (4, 'Fruits');

INSERT INTO products VALUES (10, 'Coca-Cola 500ml', 0, 100, 'bottle', 1);
INSERT INTO products VALUES (11, 'Coca-Cola 1l', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (12, 'Sprite 500ml', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (13, 'Fanta 500ml', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (20, 'Chicken Breasts', 0, 10000, 'g', 2);
INSERT INTO products VALUES (21, 'Chicken Wings', 0, 10000, 'g', 2);
INSERT INTO products VALUES (22, 'Beef', 0, 10000, 'g', 2);
INSERT INTO products VALUES (23, 'Pork Chop', 0, 10000, 'g', 2);
INSERT INTO products VALUES (30, 'Onions', 0, 1000, 'g', 3);
INSERT INTO products VALUES (31, 'Pepper', 0, 1000, 'g', 3);
INSERT INTO products VALUES (32, 'Carrot', 0, 1000, 'g', 3);
INSERT INTO products VALUES (40, 'Apple', 0, 100, 'fruit', 4);

INSERT INTO dish_categories VALUES (1, 'Soups', NULL);
INSERT INTO dish_categories VALUES (2, 'Main Course', NULL);
INSERT INTO dish_categories VALUES (3, 'Drinks', NULL);

INSERT INTO dishes VALUES (11, 'Tomato', NULL, 9155, 1);
INSERT INTO dishes VALUES (12, 'Chicken', NULL, 9447, 1);
INSERT INTO dishes VALUES (21, 'Beef', NULL, 4829, 2);
INSERT INTO dishes VALUES (31, 'A drink', NULL, 4033, 3);

INSERT INTO ingredients VALUES (111, 48, 11, 3);
INSERT INTO ingredients VALUES (112, 56, 11, 8);
INSERT INTO ingredients VALUES (113, 42, 11, 1);
INSERT INTO ingredients VALUES (114, 89, 11, 10);
INSERT INTO ingredients VALUES (115, 57, 11, 9);
INSERT INTO ingredients VALUES (116, 36, 11, 11);
INSERT INTO ingredients VALUES (121, 40, 12, 3);
INSERT INTO ingredients VALUES (211, 19, 21, 6);
INSERT INTO ingredients VALUES (212, 64, 21, 11);
INSERT INTO ingredients VALUES (213, 100, 21, 8);
INSERT INTO ingredients VALUES (214, 82, 21, 4);
INSERT INTO ingredients VALUES (215, 9, 21, 3);
INSERT INTO ingredients VALUES (311, 19, 31, 2);

INSERT INTO recipes VALUES (1, 'Porro porro ut aliquam sed etincidunt.', 11);
INSERT INTO recipes VALUES (2, 'Etincidunt magnam tempora modi.', 11);
INSERT INTO recipes VALUES (3, 'Sit aliquam dolor eius amet.', 11);
INSERT INTO recipes VALUES (4, 'Est etincidunt neque consectetur eius magnam amet.', 11);
INSERT INTO recipes VALUES (5, 'Quisquam non eius quaerat ut.', 11);
INSERT INTO recipes VALUES (6, 'Sit sed quaerat voluptatem quisquam ut.', 11);
INSERT INTO recipes VALUES (1, 'Etincidunt non numquam ut.', 12);
INSERT INTO recipes VALUES (1, 'Non etincidunt neque magnam numquam.', 21);
INSERT INTO recipes VALUES (2, 'Dolor est non numquam.', 21);
INSERT INTO recipes VALUES (3, 'Adipisci tempora sit labore dolorem sed.', 21);
INSERT INTO recipes VALUES (4, 'Eius magnam velit porro eius.', 21);
INSERT INTO recipes VALUES (5, 'Non consectetur quisquam est.', 21);
INSERT INTO recipes VALUES (6, 'Sed tempora aliquam magnam adipisci dolorem.', 21);
INSERT INTO recipes VALUES (7, 'Tempora non magnam dolorem modi neque numquam modi.', 21);
INSERT INTO recipes VALUES (8, 'Quisquam voluptatem quisquam magnam est.', 21);
INSERT INTO recipes VALUES (1, 'Dolor numquam adipisci non ipsum dolore.', 31);
INSERT INTO recipes VALUES (2, 'Labore magnam etincidunt est ipsum consectetur.', 31);




COMMIT;
