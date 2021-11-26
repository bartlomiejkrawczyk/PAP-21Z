INSERT INTO employee_kinds VALUES (1, 'waiter');
INSERT INTO employee_kinds VALUES (2, 'cook');

INSERT INTO employees VALUES (1, 'Karol', 'Krawczyk', 1);
INSERT INTO employees VALUES (2, 'Bartlomiej', 'Sulkowski', 1);
INSERT INTO employees VALUES (3, 'Adam', 'Rogozinski', 1);
INSERT INTO employees VALUES (4, 'Adam', 'Sudol', 1);
INSERT INTO employees VALUES (5, 'Bartlomiej', 'Sudol', 1);
INSERT INTO employees VALUES (6, 'Karol', 'Rogozinski', 1);
INSERT INTO employees VALUES (7, 'Karol', 'Sudol', 1);
INSERT INTO employees VALUES (8, 'Adam', 'Rogozinski', 1);
INSERT INTO employees VALUES (9, 'Kamil', 'Krawczyk', 1);
INSERT INTO employees VALUES (10, 'Adam', 'Sulkowski', 1);
INSERT INTO employees VALUES (11, 'Bartlomiej', 'Sudol', 2);
INSERT INTO employees VALUES (12, 'Bartlomiej', 'Rogozinski', 2);
INSERT INTO employees VALUES (13, 'Kamil', 'Rogozinski', 2);
INSERT INTO employees VALUES (14, 'Karol', 'Sudol', 2);
INSERT INTO employees VALUES (15, 'Bartlomiej', 'Sudol', 2);

INSERT INTO tables VALUES (1, 'pod oknem');
INSERT INTO tables VALUES (2, 'przy drzwiach');
INSERT INTO tables VALUES (3, 'przy barze');

INSERT INTO product_categories VALUES (1, 'Drinks');
INSERT INTO product_categories VALUES (2, 'Meat');
INSERT INTO product_categories VALUES (3, 'Vegetables');
INSERT INTO product_categories VALUES (4, 'Fruits');
INSERT INTO product_categories VALUES (5, 'Dairy');

INSERT INTO products VALUES (1, 'Coca-Cola 500ml', 0, 100, 'bottle', 1);
INSERT INTO products VALUES (2, 'Coca-Cola 1l', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (3, 'Sprite 500ml', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (4, 'Fanta 500ml', 0, 50, 'bottle', 1);
INSERT INTO products VALUES (5, 'Chicken Breasts', 0, 10000, 'g', 2);
INSERT INTO products VALUES (6, 'Chicken Wings', 0, 10000, 'g', 2);
INSERT INTO products VALUES (7, 'Beef', 0, 10000, 'g', 2);
INSERT INTO products VALUES (8, 'Pork Chop', 0, 10000, 'g', 2);
INSERT INTO products VALUES (9, 'Onions', 0, 1000, 'g', 3);
INSERT INTO products VALUES (10, 'Pepper', 0, 1000, 'g', 3);
INSERT INTO products VALUES (11, 'Carrot', 0, 1000, 'g', 3);
INSERT INTO products VALUES (12, 'Apple', 0, 100, 'fruit', 4);


INSERT INTO dish_categories VALUES (1, 'Soups', NULL);

INSERT INTO dishes VALUES (1, 'Tomato', NULL, 7498, '1');

INSERT INTO recipes VALUES (1, 'Quisquam tempora quisquam est quaerat non numquam numquam.', 1);
INSERT INTO recipes VALUES (2, 'Quiquia quaerat etincidunt consectetur consectetur velit.', 1);
INSERT INTO recipes VALUES (3, 'Etincidunt modi etincidunt labore.', 1);
INSERT INTO recipes VALUES (4, 'Ut amet sed ipsum.', 1);
INSERT INTO recipes VALUES (5, 'Sed quaerat ipsum velit ut dolor eius.', 1);
INSERT INTO recipes VALUES (6, 'Etincidunt neque aliquam labore quaerat.', 1);

INSERT INTO ingredients VALUES (1, 960, 1, 10);
INSERT INTO ingredients VALUES (2, 139, 1, 5);
INSERT INTO ingredients VALUES (3, 448, 1, 2);
INSERT INTO ingredients VALUES (4, 923, 1, 3);
INSERT INTO ingredients VALUES (5, 506, 1, 5);
INSERT INTO ingredients VALUES (6, 306, 1, 6);
INSERT INTO ingredients VALUES (7, 431, 1, 12);
INSERT INTO ingredients VALUES (8, 468, 1, 3);
INSERT INTO ingredients VALUES (9, 13, 1, 7);

INSERT INTO dishes VALUES (2, 'Chicken', NULL, 7719, '1');

INSERT INTO recipes VALUES (1, 'Etincidunt modi sed quaerat dolore adipisci magnam quisquam.', 2);
INSERT INTO recipes VALUES (2, 'Sed labore magnam numquam.', 2);
INSERT INTO recipes VALUES (3, 'Amet dolorem modi magnam ut.', 2);
INSERT INTO recipes VALUES (4, 'Quiquia velit modi dolore quiquia neque etincidunt.', 2);
INSERT INTO recipes VALUES (5, 'Dolore amet modi ut dolorem dolorem.', 2);
INSERT INTO recipes VALUES (6, 'Ipsum velit dolorem non quiquia.', 2);
INSERT INTO recipes VALUES (7, 'Neque voluptatem dolor est eius ipsum.', 2);
INSERT INTO recipes VALUES (8, 'Modi porro porro dolorem adipisci.', 2);

INSERT INTO ingredients VALUES (10, 144, 2, 8);
INSERT INTO ingredients VALUES (11, 992, 2, 9);
INSERT INTO ingredients VALUES (12, 685, 2, 6);
INSERT INTO ingredients VALUES (13, 338, 2, 7);
INSERT INTO ingredients VALUES (14, 557, 2, 10);

INSERT INTO dish_categories VALUES (2, 'Main Course', NULL);

INSERT INTO dishes VALUES (3, 'Beef', NULL, 1772, '2');

INSERT INTO recipes VALUES (1, 'Dolorem voluptatem labore voluptatem magnam velit.', 3);

INSERT INTO ingredients VALUES (15, 230, 3, 2);
INSERT INTO ingredients VALUES (16, 802, 3, 11);
INSERT INTO ingredients VALUES (17, 890, 3, 8);
INSERT INTO ingredients VALUES (18, 597, 3, 1);
INSERT INTO ingredients VALUES (19, 383, 3, 8);
INSERT INTO ingredients VALUES (20, 530, 3, 5);
INSERT INTO ingredients VALUES (21, 282, 3, 1);

INSERT INTO dish_categories VALUES (3, 'Drinks', NULL);

INSERT INTO dishes VALUES (4, 'A drink', NULL, 9379, '3');

INSERT INTO recipes VALUES (1, 'Non quaerat velit ipsum numquam porro.', 4);
INSERT INTO recipes VALUES (2, 'Voluptatem porro porro quaerat non est dolor dolore.', 4);
INSERT INTO recipes VALUES (3, 'Magnam ut dolor amet.', 4);
INSERT INTO recipes VALUES (4, 'Dolore velit adipisci numquam.', 4);
INSERT INTO recipes VALUES (5, 'Voluptatem magnam porro dolorem.', 4);
INSERT INTO recipes VALUES (6, 'Numquam etincidunt modi est est est non magnam.', 4);

INSERT INTO ingredients VALUES (22, 614, 4, 8);
INSERT INTO ingredients VALUES (23, 988, 4, 1);
INSERT INTO ingredients VALUES (24, 723, 4, 4);
INSERT INTO ingredients VALUES (25, 587, 4, 7);
INSERT INTO ingredients VALUES (26, 229, 4, 6);
INSERT INTO ingredients VALUES (27, 997, 4, 9);
INSERT INTO ingredients VALUES (28, 977, 4, 1);

INSERT INTO receipts VALUES (1, 0, 1, 1);
INSERT INTO receipts VALUES (2, 0, 1, 2);
INSERT INTO receipts VALUES (3, 0, 1, 3);

COMMIT;
