INSERT INTO employee_kinds VALUES (1, 'waiter');
INSERT INTO employee_kinds VALUES (2, 'cook');

INSERT INTO employees VALUES (1, 'Adam', 'Sulkowski', 1);
INSERT INTO employees VALUES (2, 'Karol', 'Sudol', 1);
INSERT INTO employees VALUES (3, 'Kamil', 'Sudol', 1);
INSERT INTO employees VALUES (4, 'Adam', 'Sudol', 1);
INSERT INTO employees VALUES (5, 'Kamil', 'Rogozinski', 1);
INSERT INTO employees VALUES (6, 'Kamil', 'Rogozinski', 2);
INSERT INTO employees VALUES (7, 'Adam', 'Sulkowski', 2);
INSERT INTO employees VALUES (8, 'Kamil', 'Krawczyk', 2);
INSERT INTO employees VALUES (9, 'Adam', 'Krawczyk', 2);
INSERT INTO employees VALUES (10, 'Bartlomiej', 'Krawczyk', 2);

INSERT INTO tables VALUES (1, 'Near the Window');
INSERT INTO tables VALUES (2, 'Near the Doors');
INSERT INTO tables VALUES (3, 'Over the Bar');

INSERT INTO product_categories VALUES (1, 'Drinks');
INSERT INTO product_categories VALUES (2, 'Meat');
INSERT INTO product_categories VALUES (3, 'Vegetables');
INSERT INTO product_categories VALUES (4, 'Fruits');
INSERT INTO product_categories VALUES (5, 'Dairy');

INSERT INTO products VALUES (1, 'Coca-Cola 500ml', 999999, 100, 'bottle', 1);
INSERT INTO products VALUES (2, 'Coca-Cola 1l', 999999, 50, 'bottle', 1);
INSERT INTO products VALUES (3, 'Sprite 500ml', 999999, 50, 'bottle', 1);
INSERT INTO products VALUES (4, 'Fanta 500ml', 999999, 50, 'bottle', 1);
INSERT INTO products VALUES (5, 'Chicken Breasts', 999999, 10000, 'g', 2);
INSERT INTO products VALUES (6, 'Chicken Wings', 999999, 10000, 'g', 2);
INSERT INTO products VALUES (7, 'Beef', 999999, 10000, 'g', 2);
INSERT INTO products VALUES (8, 'Pork Chop', 999999, 10000, 'g', 2);
INSERT INTO products VALUES (9, 'Onions', 999999, 1000, 'g', 3);
INSERT INTO products VALUES (10, 'Pepper', 999999, 1000, 'g', 3);
INSERT INTO products VALUES (11, 'Carrot', 999999, 1000, 'g', 3);
INSERT INTO products VALUES (12, 'Apple', 999999, 100, 'fruit', 4);


INSERT INTO dish_categories VALUES (1, 'Soups', NULL);

INSERT INTO dishes VALUES (1, 'Tomato', 'tomato.jpg', 8370, '1');

INSERT INTO recipes VALUES (1, 'Aliquam magnam dolor voluptatem aliquam neque aliquam.', 1);
INSERT INTO recipes VALUES (2, 'Consectetur quaerat dolor dolore amet.', 1);
INSERT INTO recipes VALUES (3, 'Ut labore magnam neque.', 1);
INSERT INTO recipes VALUES (4, 'Neque modi consectetur quiquia sed quisquam labore sit.', 1);
INSERT INTO recipes VALUES (5, 'Amet ut dolorem eius.', 1);
INSERT INTO recipes VALUES (6, 'Aliquam est dolorem magnam voluptatem dolorem aliquam etincidunt.', 1);

INSERT INTO ingredients VALUES (1, 831, 1, 6);

INSERT INTO dishes VALUES (2, 'Chicken', 'chicken.jpg', 6200, '1');

INSERT INTO recipes VALUES (1, 'Numquam neque non quaerat dolor numquam etincidunt labore.', 2);
INSERT INTO recipes VALUES (2, 'Amet tempora numquam neque quisquam magnam.', 2);
INSERT INTO recipes VALUES (3, 'Non non quiquia sit numquam porro.', 2);
INSERT INTO recipes VALUES (4, 'Porro adipisci quaerat etincidunt magnam labore.', 2);
INSERT INTO recipes VALUES (5, 'Ut modi ipsum aliquam quaerat dolore.', 2);
INSERT INTO recipes VALUES (6, 'Magnam consectetur amet eius neque modi quiquia.', 2);
INSERT INTO recipes VALUES (7, 'Ipsum velit labore magnam.', 2);
INSERT INTO recipes VALUES (8, 'Sit magnam neque magnam ut aliquam magnam quaerat.', 2);

INSERT INTO ingredients VALUES (2, 713, 2, 9);
INSERT INTO ingredients VALUES (3, 797, 2, 11);
INSERT INTO ingredients VALUES (4, 701, 2, 5);
INSERT INTO ingredients VALUES (5, 968, 2, 6);
INSERT INTO ingredients VALUES (6, 156, 2, 11);
INSERT INTO ingredients VALUES (7, 709, 2, 1);
INSERT INTO ingredients VALUES (8, 76, 2, 4);
INSERT INTO ingredients VALUES (9, 12, 2, 1);
INSERT INTO ingredients VALUES (10, 751, 2, 10);

INSERT INTO dishes VALUES (3, 'Pumpkin', 'pumpkin.jpg', 1463, '1');

INSERT INTO recipes VALUES (1, 'Quiquia voluptatem neque dolorem tempora sit.', 3);
INSERT INTO recipes VALUES (2, 'Etincidunt neque labore consectetur porro amet sed labore.', 3);
INSERT INTO recipes VALUES (3, 'Adipisci porro modi sed ipsum eius sed.', 3);
INSERT INTO recipes VALUES (4, 'Dolore voluptatem sit non dolor ipsum numquam.', 3);
INSERT INTO recipes VALUES (5, 'Dolore est porro numquam quisquam sed.', 3);
INSERT INTO recipes VALUES (6, 'Eius quiquia dolorem eius dolorem ut quisquam modi.', 3);
INSERT INTO recipes VALUES (7, 'Dolore etincidunt porro dolorem voluptatem modi voluptatem.', 3);
INSERT INTO recipes VALUES (8, 'Eius ut aliquam dolore eius.', 3);

INSERT INTO ingredients VALUES (11, 761, 3, 4);
INSERT INTO ingredients VALUES (12, 121, 3, 4);
INSERT INTO ingredients VALUES (13, 663, 3, 6);
INSERT INTO ingredients VALUES (14, 697, 3, 10);
INSERT INTO ingredients VALUES (15, 287, 3, 5);
INSERT INTO ingredients VALUES (16, 937, 3, 2);
INSERT INTO ingredients VALUES (17, 493, 3, 8);
INSERT INTO ingredients VALUES (18, 549, 3, 10);
INSERT INTO ingredients VALUES (19, 938, 3, 7);

INSERT INTO dishes VALUES (4, 'Cream', 'cream.jpg', 1303, '1');

INSERT INTO recipes VALUES (1, 'Aliquam eius voluptatem etincidunt porro sit.', 4);
INSERT INTO recipes VALUES (2, 'Sed consectetur velit sed tempora dolore etincidunt porro.', 4);
INSERT INTO recipes VALUES (3, 'Non quiquia eius modi.', 4);
INSERT INTO recipes VALUES (4, 'Quaerat numquam voluptatem sed.', 4);
INSERT INTO recipes VALUES (5, 'Modi non adipisci eius adipisci sed amet sit.', 4);
INSERT INTO recipes VALUES (6, 'Eius est amet aliquam sed dolore.', 4);

INSERT INTO ingredients VALUES (20, 736, 4, 1);
INSERT INTO ingredients VALUES (21, 640, 4, 2);
INSERT INTO ingredients VALUES (22, 830, 4, 12);
INSERT INTO ingredients VALUES (23, 405, 4, 8);
INSERT INTO ingredients VALUES (24, 799, 4, 7);

INSERT INTO dishes VALUES (5, 'Carrot', 'carrot.jpg', 9284, '1');

INSERT INTO recipes VALUES (1, 'Non quisquam porro eius est etincidunt modi.', 5);
INSERT INTO recipes VALUES (2, 'Quaerat etincidunt ipsum dolor amet aliquam.', 5);
INSERT INTO recipes VALUES (3, 'Consectetur sed aliquam amet neque ut adipisci adipisci.', 5);
INSERT INTO recipes VALUES (4, 'Velit dolor porro numquam est quaerat sed aliquam.', 5);
INSERT INTO recipes VALUES (5, 'Est adipisci quiquia labore numquam modi.', 5);
INSERT INTO recipes VALUES (6, 'Aliquam labore amet eius velit.', 5);
INSERT INTO recipes VALUES (7, 'Neque ut voluptatem velit labore.', 5);
INSERT INTO recipes VALUES (8, 'Etincidunt quisquam numquam velit velit.', 5);
INSERT INTO recipes VALUES (9, 'Etincidunt neque consectetur ipsum eius.', 5);

INSERT INTO ingredients VALUES (25, 833, 5, 1);
INSERT INTO ingredients VALUES (26, 334, 5, 3);
INSERT INTO ingredients VALUES (27, 983, 5, 11);
INSERT INTO ingredients VALUES (28, 98, 5, 4);
INSERT INTO ingredients VALUES (29, 530, 5, 12);
INSERT INTO ingredients VALUES (30, 839, 5, 7);
INSERT INTO ingredients VALUES (31, 332, 5, 9);

INSERT INTO dish_categories VALUES (2, 'Main Course', NULL);

INSERT INTO dishes VALUES (6, 'Beef', 'beef.jpg', 4418, '2');

INSERT INTO recipes VALUES (1, 'Labore tempora tempora labore porro.', 6);
INSERT INTO recipes VALUES (2, 'Ut modi eius magnam non aliquam ipsum.', 6);
INSERT INTO recipes VALUES (3, 'Consectetur neque dolorem adipisci quaerat ipsum magnam sed.', 6);
INSERT INTO recipes VALUES (4, 'Porro amet velit aliquam eius ipsum.', 6);
INSERT INTO recipes VALUES (5, 'Ipsum voluptatem quiquia dolor.', 6);
INSERT INTO recipes VALUES (6, 'Voluptatem dolore neque sed etincidunt dolore dolore.', 6);
INSERT INTO recipes VALUES (7, 'Non ut ut est ipsum.', 6);
INSERT INTO recipes VALUES (8, 'Quiquia eius ut ut magnam etincidunt.', 6);

INSERT INTO ingredients VALUES (32, 338, 6, 2);
INSERT INTO ingredients VALUES (33, 575, 6, 9);

INSERT INTO dishes VALUES (7, 'Hamburger', 'hamburger.jpg', 9664, '2');

INSERT INTO recipes VALUES (1, 'Eius adipisci ut amet ipsum numquam est sit.', 7);
INSERT INTO recipes VALUES (2, 'Sed voluptatem quisquam eius est.', 7);
INSERT INTO recipes VALUES (3, 'Neque eius modi eius voluptatem.', 7);

INSERT INTO ingredients VALUES (34, 262, 7, 6);
INSERT INTO ingredients VALUES (35, 490, 7, 5);
INSERT INTO ingredients VALUES (36, 811, 7, 12);
INSERT INTO ingredients VALUES (37, 306, 7, 6);
INSERT INTO ingredients VALUES (38, 846, 7, 12);
INSERT INTO ingredients VALUES (39, 913, 7, 1);
INSERT INTO ingredients VALUES (40, 590, 7, 5);
INSERT INTO ingredients VALUES (41, 125, 7, 7);
INSERT INTO ingredients VALUES (42, 467, 7, 6);

INSERT INTO dishes VALUES (8, 'Spaghetti', 'spaghetti.jpg', 1278, '2');

INSERT INTO recipes VALUES (1, 'Quaerat porro ipsum sed.', 8);
INSERT INTO recipes VALUES (2, 'Magnam neque quiquia numquam est labore.', 8);

INSERT INTO ingredients VALUES (43, 293, 8, 6);
INSERT INTO ingredients VALUES (44, 769, 8, 11);

INSERT INTO dishes VALUES (9, 'Pizza', 'pizza.jpg', 2775, '2');

INSERT INTO recipes VALUES (1, 'Aliquam labore numquam etincidunt dolore non.', 9);
INSERT INTO recipes VALUES (2, 'Sed dolorem quaerat porro quisquam sed est dolorem.', 9);
INSERT INTO recipes VALUES (3, 'Dolore dolorem modi adipisci.', 9);
INSERT INTO recipes VALUES (4, 'Dolore modi velit dolorem non neque.', 9);
INSERT INTO recipes VALUES (5, 'Sed etincidunt dolore velit quiquia quisquam.', 9);

INSERT INTO ingredients VALUES (45, 160, 9, 3);
INSERT INTO ingredients VALUES (46, 191, 9, 5);
INSERT INTO ingredients VALUES (47, 21, 9, 7);
INSERT INTO ingredients VALUES (48, 28, 9, 5);

INSERT INTO dish_categories VALUES (3, 'Drinks', NULL);

INSERT INTO dishes VALUES (10, 'Coca-Cola', 'coca-cola.jpg', 8995, '3');

INSERT INTO recipes VALUES (1, 'Adipisci magnam consectetur voluptatem velit neque neque.', 10);
INSERT INTO recipes VALUES (2, 'Non neque eius tempora.', 10);
INSERT INTO recipes VALUES (3, 'Non tempora dolor amet ipsum sed.', 10);
INSERT INTO recipes VALUES (4, 'Ut labore tempora quaerat sit numquam.', 10);
INSERT INTO recipes VALUES (5, 'Labore velit sit voluptatem dolore etincidunt quaerat.', 10);
INSERT INTO recipes VALUES (6, 'Aliquam ipsum sit sed amet ipsum.', 10);

INSERT INTO ingredients VALUES (49, 729, 10, 4);

INSERT INTO dishes VALUES (11, 'Fanta', 'fanta.jpg', 2669, '3');

INSERT INTO recipes VALUES (1, 'Velit dolorem adipisci sit porro ut numquam.', 11);
INSERT INTO recipes VALUES (2, 'Etincidunt quisquam velit quiquia aliquam dolore.', 11);
INSERT INTO recipes VALUES (3, 'Quisquam ut ipsum ipsum est ipsum.', 11);
INSERT INTO recipes VALUES (4, 'Dolorem quaerat aliquam sed quisquam sit consectetur.', 11);
INSERT INTO recipes VALUES (5, 'Ipsum non numquam sit adipisci ipsum ipsum quiquia.', 11);
INSERT INTO recipes VALUES (6, 'Modi non porro voluptatem.', 11);
INSERT INTO recipes VALUES (7, 'Amet adipisci ipsum sed quisquam numquam modi adipisci.', 11);

INSERT INTO ingredients VALUES (50, 231, 11, 8);
INSERT INTO ingredients VALUES (51, 528, 11, 3);
INSERT INTO ingredients VALUES (52, 467, 11, 4);
INSERT INTO ingredients VALUES (53, 178, 11, 5);
INSERT INTO ingredients VALUES (54, 373, 11, 8);
INSERT INTO ingredients VALUES (55, 752, 11, 7);

INSERT INTO dishes VALUES (12, 'Sprite', 'sprite.jpg', 2905, '3');

INSERT INTO recipes VALUES (1, 'Ipsum tempora porro modi ipsum.', 12);
INSERT INTO recipes VALUES (2, 'Sit quisquam neque quisquam labore labore.', 12);
INSERT INTO recipes VALUES (3, 'Labore dolor dolor ut labore sit dolorem quaerat.', 12);

INSERT INTO ingredients VALUES (56, 951, 12, 4);
INSERT INTO ingredients VALUES (57, 982, 12, 10);
INSERT INTO ingredients VALUES (58, 491, 12, 9);
INSERT INTO ingredients VALUES (59, 118, 12, 3);

INSERT INTO dishes VALUES (13, 'Beer', 'beer.jpg', 3240, '3');

INSERT INTO recipes VALUES (1, 'Quiquia amet velit dolorem velit labore.', 13);
INSERT INTO recipes VALUES (2, 'Ut sit voluptatem velit tempora numquam labore quaerat.', 13);
INSERT INTO recipes VALUES (3, 'Dolore dolorem ut tempora modi labore.', 13);
INSERT INTO recipes VALUES (4, 'Voluptatem modi est modi dolor dolorem.', 13);
INSERT INTO recipes VALUES (5, 'Velit magnam eius etincidunt ipsum quiquia sed.', 13);

INSERT INTO ingredients VALUES (60, 476, 13, 12);
INSERT INTO ingredients VALUES (61, 465, 13, 1);
INSERT INTO ingredients VALUES (62, 137, 13, 8);
INSERT INTO ingredients VALUES (63, 489, 13, 8);
INSERT INTO ingredients VALUES (64, 601, 13, 3);

INSERT INTO receipts VALUES (1, 0, 1, 1);

INSERT INTO orders VALUES (1, 1392710591777, 3, 1, 3, 6);
INSERT INTO orders VALUES (2, 1315183363679, 12, 1, 2, 6);
INSERT INTO orders VALUES (3, 1251833553304, 11, 1, 2, 10);
INSERT INTO orders VALUES (4, 1234620887549, 11, 1, 2, 8);
INSERT INTO orders VALUES (5, 1254764535365, 8, 1, 1, NULL);
INSERT INTO orders VALUES (6, 1160538898591, 2, 1, 2, 6);
INSERT INTO orders VALUES (7, 1427610300806, 2, 1, 1, NULL);
INSERT INTO orders VALUES (8, 1476084710464, 11, 1, 3, 10);

INSERT INTO receipts VALUES (2, 0, 1, 2);

INSERT INTO orders VALUES (9, 1443653686758, 12, 2, 2, 7);
INSERT INTO orders VALUES (10, 1378735192997, 8, 2, 3, 8);
INSERT INTO orders VALUES (11, 1485043972496, 12, 2, 3, 10);
INSERT INTO orders VALUES (12, 1538856214576, 11, 2, 1, 7);
INSERT INTO orders VALUES (13, 1617159788162, 9, 2, 3, 9);
INSERT INTO orders VALUES (14, 1423162167039, 3, 2, 1, 9);
INSERT INTO orders VALUES (15, 1317994743617, 8, 2, 3, 10);
INSERT INTO orders VALUES (16, 1457613166472, 11, 2, 2, 7);
INSERT INTO orders VALUES (17, 1546912762486, 8, 2, 3, 9);

INSERT INTO receipts VALUES (3, 0, 1, 3);

INSERT INTO orders VALUES (18, 1362911599919, 5, 3, 2, 8);
INSERT INTO orders VALUES (19, 1586665718260, 9, 3, 3, 10);
INSERT INTO orders VALUES (20, 1350770953204, 11, 3, 2, 7);
INSERT INTO orders VALUES (21, 1604902053940, 8, 3, 3, 9);
INSERT INTO orders VALUES (22, 1272374776144, 6, 3, 2, 8);
INSERT INTO orders VALUES (23, 1413029631165, 5, 3, 2, 6);
INSERT INTO orders VALUES (24, 1481021668236, 7, 3, 3, 10);
INSERT INTO orders VALUES (25, 1281048588240, 10, 3, 3, 7);
INSERT INTO orders VALUES (26, 1581972063736, 5, 3, 1, 8);
INSERT INTO orders VALUES (27, 1584808960138, 5, 3, 3, 7);

INSERT INTO receipts VALUES (4, 0, 2, 1);

INSERT INTO orders VALUES (28, 1413703894195, 2, 4, 3, 10);
INSERT INTO orders VALUES (29, 1371648368363, 13, 4, 1, 8);
INSERT INTO orders VALUES (30, 1160975298417, 1, 4, 2, 8);
INSERT INTO orders VALUES (31, 1214010606360, 8, 4, 1, NULL);
INSERT INTO orders VALUES (32, 1525922424741, 2, 4, 1, NULL);
INSERT INTO orders VALUES (33, 1341362569614, 5, 4, 1, 7);
INSERT INTO orders VALUES (34, 1447869333366, 13, 4, 1, 9);
INSERT INTO orders VALUES (35, 1214430358709, 11, 4, 2, 9);
INSERT INTO orders VALUES (36, 1566573006626, 12, 4, 3, 9);
INSERT INTO orders VALUES (37, 1375998659250, 5, 4, 3, 6);

INSERT INTO receipts VALUES (5, 0, 2, 2);

INSERT INTO orders VALUES (38, 1261849181323, 10, 5, 2, 8);
INSERT INTO orders VALUES (39, 1537259449500, 8, 5, 1, 8);

INSERT INTO receipts VALUES (6, 0, 2, 3);

INSERT INTO orders VALUES (40, 1306092316409, 9, 6, 1, NULL);
INSERT INTO orders VALUES (41, 1140952910547, 6, 6, 1, NULL);
INSERT INTO orders VALUES (42, 1210988489659, 5, 6, 2, 9);
INSERT INTO orders VALUES (43, 1345857960706, 11, 6, 3, 7);
INSERT INTO orders VALUES (44, 1155063993147, 4, 6, 3, 8);
INSERT INTO orders VALUES (45, 1351231324214, 13, 6, 2, 9);
INSERT INTO orders VALUES (46, 1486480489454, 10, 6, 3, 9);
INSERT INTO orders VALUES (47, 1237833661421, 12, 6, 3, 8);
INSERT INTO orders VALUES (48, 1388108264674, 7, 6, 1, NULL);

INSERT INTO receipts VALUES (7, 0, 3, 1);

INSERT INTO orders VALUES (49, 1292122566001, 7, 7, 3, 9);
INSERT INTO orders VALUES (50, 1451610964356, 2, 7, 3, 8);

INSERT INTO receipts VALUES (8, 0, 3, 2);

INSERT INTO orders VALUES (51, 1366102892453, 12, 8, 1, 8);
INSERT INTO orders VALUES (52, 1322714974595, 13, 8, 2, 9);
INSERT INTO orders VALUES (53, 1496941410049, 4, 8, 1, NULL);
INSERT INTO orders VALUES (54, 1469658981907, 2, 8, 1, 10);
INSERT INTO orders VALUES (55, 1331968913775, 10, 8, 3, 6);
INSERT INTO orders VALUES (56, 1573572926027, 9, 8, 3, 9);
INSERT INTO orders VALUES (57, 1300553485412, 5, 8, 2, 10);
INSERT INTO orders VALUES (58, 1284126157058, 7, 8, 3, 10);
INSERT INTO orders VALUES (59, 1404103452174, 7, 8, 3, 6);
INSERT INTO orders VALUES (60, 1482419022783, 5, 8, 3, 8);

INSERT INTO receipts VALUES (9, 0, 3, 3);

INSERT INTO orders VALUES (61, 1636388325797, 12, 9, 3, 8);

INSERT INTO receipts VALUES (10, 0, 4, 1);

INSERT INTO orders VALUES (62, 1335038891343, 11, 10, 3, 8);
INSERT INTO orders VALUES (63, 1527210391402, 9, 10, 1, NULL);
INSERT INTO orders VALUES (64, 1342717523404, 9, 10, 1, NULL);
INSERT INTO orders VALUES (65, 1285010787014, 8, 10, 3, 10);
INSERT INTO orders VALUES (66, 1459638328148, 2, 10, 3, 8);
INSERT INTO orders VALUES (67, 1144961865944, 13, 10, 3, 9);
INSERT INTO orders VALUES (68, 1448062564530, 3, 10, 1, NULL);
INSERT INTO orders VALUES (69, 1553124481352, 1, 10, 1, NULL);
INSERT INTO orders VALUES (70, 1457684675178, 11, 10, 2, 7);
INSERT INTO orders VALUES (71, 1211244234946, 12, 10, 1, NULL);

INSERT INTO receipts VALUES (11, 0, 4, 2);

INSERT INTO orders VALUES (72, 1583452611373, 5, 11, 1, 9);
INSERT INTO orders VALUES (73, 1330497375005, 1, 11, 1, NULL);
INSERT INTO orders VALUES (74, 1212292664979, 5, 11, 2, 10);
INSERT INTO orders VALUES (75, 1502315601136, 13, 11, 1, 6);
INSERT INTO orders VALUES (76, 1454340988253, 7, 11, 1, NULL);
INSERT INTO orders VALUES (77, 1568569899254, 4, 11, 1, 10);
INSERT INTO orders VALUES (78, 1463117209189, 7, 11, 3, 10);

INSERT INTO receipts VALUES (12, 0, 4, 3);

INSERT INTO orders VALUES (79, 1510709787035, 4, 12, 2, 6);
INSERT INTO orders VALUES (80, 1315008965868, 2, 12, 2, 10);
INSERT INTO orders VALUES (81, 1366396085344, 1, 12, 1, 8);

INSERT INTO receipts VALUES (13, 0, 5, 1);

INSERT INTO orders VALUES (82, 1510378052842, 3, 13, 2, 7);
INSERT INTO orders VALUES (83, 1405903602477, 6, 13, 2, 6);
INSERT INTO orders VALUES (84, 1153759964653, 8, 13, 1, NULL);
INSERT INTO orders VALUES (85, 1368168027904, 9, 13, 2, 6);
INSERT INTO orders VALUES (86, 1196928881156, 10, 13, 2, 8);
INSERT INTO orders VALUES (87, 1175534837820, 8, 13, 1, 8);
INSERT INTO orders VALUES (88, 1413483909179, 7, 13, 2, 9);
INSERT INTO orders VALUES (89, 1593196341268, 10, 13, 1, 7);
INSERT INTO orders VALUES (90, 1508668859633, 1, 13, 2, 9);

INSERT INTO receipts VALUES (14, 0, 5, 2);

INSERT INTO orders VALUES (91, 1147290116477, 3, 14, 1, NULL);
INSERT INTO orders VALUES (92, 1285893353987, 8, 14, 3, 9);
INSERT INTO orders VALUES (93, 1462572996751, 2, 14, 1, NULL);
INSERT INTO orders VALUES (94, 1178976520239, 7, 14, 2, 7);
INSERT INTO orders VALUES (95, 1399578782745, 6, 14, 3, 7);
INSERT INTO orders VALUES (96, 1582442575763, 8, 14, 2, 8);

INSERT INTO receipts VALUES (15, 0, 5, 3);

INSERT INTO orders VALUES (97, 1209354557932, 6, 15, 3, 9);
INSERT INTO orders VALUES (98, 1227111045464, 12, 15, 3, 8);
INSERT INTO orders VALUES (99, 1245344968074, 2, 15, 1, NULL);
INSERT INTO orders VALUES (100, 1415764969804, 6, 15, 3, 8);
INSERT INTO orders VALUES (101, 1395709600393, 6, 15, 1, 8);
INSERT INTO orders VALUES (102, 1254985046460, 12, 15, 1, 8);


COMMIT;
