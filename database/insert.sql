INSERT INTO employee_kinds VALUES (1, 'waiter');
INSERT INTO employee_kinds VALUES (2, 'cook');

INSERT INTO employees VALUES (1, 'Adam', 'Sulkowski', 1);
INSERT INTO employees VALUES (2, 'Kamil', 'Krawczyk', 1);
INSERT INTO employees VALUES (3, 'Karol', 'Krawczyk', 1);
INSERT INTO employees VALUES (4, 'Kamil', 'Rogozinski', 1);
INSERT INTO employees VALUES (5, 'Karol', 'Krawczyk', 1);
INSERT INTO employees VALUES (6, 'Karol', 'Krawczyk', 1);
INSERT INTO employees VALUES (7, 'Bartlomiej', 'Sudol', 1);
INSERT INTO employees VALUES (8, 'Kamil', 'Sulkowski', 1);
INSERT INTO employees VALUES (9, 'Karol', 'Sudol', 1);
INSERT INTO employees VALUES (10, 'Kamil', 'Krawczyk', 2);
INSERT INTO employees VALUES (11, 'Bartlomiej', 'Rogozinski', 2);
INSERT INTO employees VALUES (12, 'Adam', 'Sulkowski', 2);
INSERT INTO employees VALUES (13, 'Adam', 'Krawczyk', 2);
INSERT INTO employees VALUES (14, 'Kamil', 'Sulkowski', 2);
INSERT INTO employees VALUES (15, 'Kamil', 'Sudol', 2);

INSERT INTO tables VALUES (1, 'Near the Window');
INSERT INTO tables VALUES (2, 'Near the Doors');
INSERT INTO tables VALUES (3, 'Over the Bar');

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

INSERT INTO dishes VALUES (1, 'Tomato', 'tomato.jpg', 1499, '1');

INSERT INTO recipes VALUES (1, 'Velit voluptatem tempora ut dolorem numquam sed.', 1);
INSERT INTO recipes VALUES (2, 'Consectetur quiquia adipisci ipsum.', 1);
INSERT INTO recipes VALUES (3, 'Aliquam eius quisquam amet voluptatem velit.', 1);
INSERT INTO recipes VALUES (4, 'Aliquam voluptatem tempora dolore dolorem sit porro modi.', 1);
INSERT INTO recipes VALUES (5, 'Consectetur eius eius dolore velit dolore numquam.', 1);

INSERT INTO ingredients VALUES (1, 746, 1, 10);
INSERT INTO ingredients VALUES (2, 667, 1, 8);
INSERT INTO ingredients VALUES (3, 810, 1, 3);
INSERT INTO ingredients VALUES (4, 424, 1, 4);
INSERT INTO ingredients VALUES (5, 59, 1, 10);
INSERT INTO ingredients VALUES (6, 719, 1, 12);
INSERT INTO ingredients VALUES (7, 62, 1, 7);
INSERT INTO ingredients VALUES (8, 5, 1, 1);
INSERT INTO ingredients VALUES (9, 453, 1, 5);

INSERT INTO dishes VALUES (2, 'Chicken', 'chicken.jpg', 8175, '1');

INSERT INTO recipes VALUES (1, 'Ipsum neque tempora quiquia voluptatem eius neque.', 2);
INSERT INTO recipes VALUES (2, 'Dolore non adipisci numquam voluptatem quaerat sed.', 2);
INSERT INTO recipes VALUES (3, 'Dolore quisquam labore non eius non amet.', 2);
INSERT INTO recipes VALUES (4, 'Porro dolor porro tempora quisquam eius non.', 2);
INSERT INTO recipes VALUES (5, 'Quisquam quisquam voluptatem etincidunt.', 2);
INSERT INTO recipes VALUES (6, 'Quaerat magnam aliquam velit dolorem quaerat adipisci.', 2);
INSERT INTO recipes VALUES (7, 'Voluptatem velit sit porro magnam.', 2);

INSERT INTO ingredients VALUES (10, 198, 2, 6);
INSERT INTO ingredients VALUES (11, 815, 2, 2);
INSERT INTO ingredients VALUES (12, 456, 2, 3);
INSERT INTO ingredients VALUES (13, 660, 2, 12);
INSERT INTO ingredients VALUES (14, 629, 2, 7);
INSERT INTO ingredients VALUES (15, 582, 2, 3);
INSERT INTO ingredients VALUES (16, 154, 2, 6);
INSERT INTO ingredients VALUES (17, 427, 2, 10);
INSERT INTO ingredients VALUES (18, 303, 2, 9);

INSERT INTO dishes VALUES (3, 'Pumpkin', 'pumpkin.jpg', 3585, '1');

INSERT INTO recipes VALUES (1, 'Dolorem est etincidunt sed amet non quaerat.', 3);
INSERT INTO recipes VALUES (2, 'Consectetur eius ut est quiquia numquam neque adipisci.', 3);
INSERT INTO recipes VALUES (3, 'Magnam labore sit dolore non.', 3);
INSERT INTO recipes VALUES (4, 'Ipsum labore adipisci sit dolore voluptatem dolore ipsum.', 3);
INSERT INTO recipes VALUES (5, 'Ipsum consectetur quisquam quiquia.', 3);
INSERT INTO recipes VALUES (6, 'Modi sed sit voluptatem voluptatem dolorem consectetur.', 3);
INSERT INTO recipes VALUES (7, 'Non est dolorem dolorem.', 3);

INSERT INTO ingredients VALUES (19, 603, 3, 10);
INSERT INTO ingredients VALUES (20, 934, 3, 8);
INSERT INTO ingredients VALUES (21, 273, 3, 3);
INSERT INTO ingredients VALUES (22, 443, 3, 11);
INSERT INTO ingredients VALUES (23, 874, 3, 10);
INSERT INTO ingredients VALUES (24, 440, 3, 1);

INSERT INTO dishes VALUES (4, 'Cream', 'cream.jpg', 9246, '1');

INSERT INTO recipes VALUES (1, 'Sit dolor sit dolore porro dolore.', 4);
INSERT INTO recipes VALUES (2, 'Adipisci dolor eius quaerat dolor ipsum sed dolore.', 4);
INSERT INTO recipes VALUES (3, 'Numquam amet non etincidunt non.', 4);
INSERT INTO recipes VALUES (4, 'Velit neque voluptatem labore quaerat.', 4);
INSERT INTO recipes VALUES (5, 'Adipisci labore adipisci aliquam modi sit est.', 4);
INSERT INTO recipes VALUES (6, 'Tempora non sed eius neque ut dolore.', 4);
INSERT INTO recipes VALUES (7, 'Est magnam magnam voluptatem amet quiquia quiquia.', 4);
INSERT INTO recipes VALUES (8, 'Labore est quaerat neque numquam quaerat.', 4);

INSERT INTO ingredients VALUES (25, 964, 4, 8);
INSERT INTO ingredients VALUES (26, 101, 4, 8);
INSERT INTO ingredients VALUES (27, 900, 4, 5);
INSERT INTO ingredients VALUES (28, 398, 4, 7);
INSERT INTO ingredients VALUES (29, 148, 4, 9);

INSERT INTO dishes VALUES (5, 'Carrot', 'carrot.jpg', 9299, '1');

INSERT INTO recipes VALUES (1, 'Consectetur non voluptatem dolor est magnam voluptatem.', 5);
INSERT INTO recipes VALUES (2, 'Modi dolorem dolore ipsum sed sit quisquam adipisci.', 5);
INSERT INTO recipes VALUES (3, 'Quaerat etincidunt ipsum adipisci eius consectetur magnam numquam.', 5);
INSERT INTO recipes VALUES (4, 'Tempora dolore est aliquam etincidunt.', 5);
INSERT INTO recipes VALUES (5, 'Dolorem quiquia eius sed dolor voluptatem non tempora.', 5);

INSERT INTO ingredients VALUES (30, 685, 5, 7);
INSERT INTO ingredients VALUES (31, 166, 5, 12);
INSERT INTO ingredients VALUES (32, 8, 5, 11);
INSERT INTO ingredients VALUES (33, 648, 5, 3);
INSERT INTO ingredients VALUES (34, 147, 5, 8);
INSERT INTO ingredients VALUES (35, 879, 5, 4);
INSERT INTO ingredients VALUES (36, 70, 5, 11);

INSERT INTO dish_categories VALUES (2, 'Main Course', NULL);

INSERT INTO dishes VALUES (6, 'Beef', 'beef.jpg', 4057, '2');

INSERT INTO recipes VALUES (1, 'Porro numquam ipsum magnam.', 6);
INSERT INTO recipes VALUES (2, 'Tempora labore dolore voluptatem dolor dolorem tempora sit.', 6);
INSERT INTO recipes VALUES (3, 'Ut ut tempora dolor tempora quisquam eius non.', 6);

INSERT INTO ingredients VALUES (37, 399, 6, 8);

INSERT INTO dishes VALUES (7, 'Hamburger', 'hamburger.jpg', 7625, '2');

INSERT INTO recipes VALUES (1, 'Consectetur tempora dolore modi dolor sit sit.', 7);
INSERT INTO recipes VALUES (2, 'Quisquam est numquam dolorem sit modi.', 7);

INSERT INTO ingredients VALUES (38, 213, 7, 7);
INSERT INTO ingredients VALUES (39, 561, 7, 12);
INSERT INTO ingredients VALUES (40, 726, 7, 5);
INSERT INTO ingredients VALUES (41, 211, 7, 8);
INSERT INTO ingredients VALUES (42, 809, 7, 10);
INSERT INTO ingredients VALUES (43, 749, 7, 1);
INSERT INTO ingredients VALUES (44, 603, 7, 3);
INSERT INTO ingredients VALUES (45, 549, 7, 1);

INSERT INTO dishes VALUES (8, 'Spaghetti', 'spaghetti.jpg', 6656, '2');

INSERT INTO recipes VALUES (1, 'Eius ut quiquia voluptatem sed porro aliquam etincidunt.', 8);
INSERT INTO recipes VALUES (2, 'Tempora consectetur porro non labore sit adipisci.', 8);
INSERT INTO recipes VALUES (3, 'Voluptatem numquam dolore dolorem adipisci.', 8);

INSERT INTO ingredients VALUES (46, 730, 8, 10);
INSERT INTO ingredients VALUES (47, 392, 8, 10);
INSERT INTO ingredients VALUES (48, 784, 8, 6);
INSERT INTO ingredients VALUES (49, 131, 8, 8);
INSERT INTO ingredients VALUES (50, 709, 8, 4);
INSERT INTO ingredients VALUES (51, 135, 8, 5);
INSERT INTO ingredients VALUES (52, 420, 8, 3);
INSERT INTO ingredients VALUES (53, 549, 8, 9);
INSERT INTO ingredients VALUES (54, 274, 8, 6);

INSERT INTO dishes VALUES (9, 'Pizza', 'pizza.jpg', 5974, '2');

INSERT INTO recipes VALUES (1, 'Aliquam tempora etincidunt magnam ipsum dolorem quisquam quaerat.', 9);
INSERT INTO recipes VALUES (2, 'Labore velit magnam numquam voluptatem sit modi dolorem.', 9);
INSERT INTO recipes VALUES (3, 'Non amet quaerat velit dolor.', 9);
INSERT INTO recipes VALUES (4, 'Adipisci amet ut dolore porro quisquam sit tempora.', 9);
INSERT INTO recipes VALUES (5, 'Non eius non eius velit.', 9);
INSERT INTO recipes VALUES (6, 'Est eius numquam magnam dolore dolor.', 9);
INSERT INTO recipes VALUES (7, 'Dolore modi aliquam sed dolor voluptatem.', 9);
INSERT INTO recipes VALUES (8, 'Voluptatem neque sed quisquam.', 9);

INSERT INTO ingredients VALUES (55, 696, 9, 6);
INSERT INTO ingredients VALUES (56, 237, 9, 7);
INSERT INTO ingredients VALUES (57, 414, 9, 9);
INSERT INTO ingredients VALUES (58, 328, 9, 5);
INSERT INTO ingredients VALUES (59, 389, 9, 8);

INSERT INTO dish_categories VALUES (3, 'Drinks', NULL);

INSERT INTO dishes VALUES (10, 'Coca-Cola', 'coca-cola.jpg', 4431, '3');

INSERT INTO recipes VALUES (1, 'Numquam neque modi etincidunt labore.', 10);
INSERT INTO recipes VALUES (2, 'Velit quaerat porro sit quisquam dolorem.', 10);
INSERT INTO recipes VALUES (3, 'Numquam dolorem sed porro.', 10);
INSERT INTO recipes VALUES (4, 'Ut etincidunt numquam consectetur tempora etincidunt est numquam.', 10);

INSERT INTO ingredients VALUES (60, 692, 10, 3);
INSERT INTO ingredients VALUES (61, 423, 10, 4);
INSERT INTO ingredients VALUES (62, 988, 10, 3);
INSERT INTO ingredients VALUES (63, 144, 10, 10);

INSERT INTO dishes VALUES (11, 'Fanta', 'fanta.jpg', 4287, '3');

INSERT INTO recipes VALUES (1, 'Labore ipsum tempora quisquam aliquam velit porro.', 11);
INSERT INTO recipes VALUES (2, 'Tempora dolore porro voluptatem non sed.', 11);
INSERT INTO recipes VALUES (3, 'Dolore non labore magnam amet non non velit.', 11);
INSERT INTO recipes VALUES (4, 'Etincidunt dolorem tempora ut labore dolore.', 11);
INSERT INTO recipes VALUES (5, 'Est quaerat neque adipisci.', 11);
INSERT INTO recipes VALUES (6, 'Numquam sit quisquam consectetur numquam.', 11);
INSERT INTO recipes VALUES (7, 'Sed sit modi labore.', 11);
INSERT INTO recipes VALUES (8, 'Etincidunt sit adipisci magnam etincidunt.', 11);

INSERT INTO ingredients VALUES (64, 762, 11, 7);
INSERT INTO ingredients VALUES (65, 92, 11, 8);
INSERT INTO ingredients VALUES (66, 663, 11, 1);
INSERT INTO ingredients VALUES (67, 153, 11, 1);
INSERT INTO ingredients VALUES (68, 11, 11, 8);
INSERT INTO ingredients VALUES (69, 201, 11, 11);
INSERT INTO ingredients VALUES (70, 77, 11, 11);

INSERT INTO dishes VALUES (12, 'Sprite', 'sprite.jpg', 1882, '3');

INSERT INTO recipes VALUES (1, 'Neque dolorem eius adipisci.', 12);

INSERT INTO ingredients VALUES (71, 663, 12, 2);
INSERT INTO ingredients VALUES (72, 233, 12, 9);
INSERT INTO ingredients VALUES (73, 733, 12, 1);
INSERT INTO ingredients VALUES (74, 165, 12, 6);
INSERT INTO ingredients VALUES (75, 937, 12, 4);
INSERT INTO ingredients VALUES (76, 891, 12, 10);
INSERT INTO ingredients VALUES (77, 374, 12, 3);

INSERT INTO dishes VALUES (13, 'Beer', 'beer.jpg', 3160, '3');

INSERT INTO recipes VALUES (1, 'Non aliquam quaerat dolorem dolorem sed tempora eius.', 13);
INSERT INTO recipes VALUES (2, 'Magnam sed quiquia ipsum sit dolor velit.', 13);
INSERT INTO recipes VALUES (3, 'Amet sit magnam sit adipisci sit tempora.', 13);
INSERT INTO recipes VALUES (4, 'Amet porro amet ipsum quisquam velit quaerat.', 13);
INSERT INTO recipes VALUES (5, 'Dolore sit quaerat numquam neque dolorem sed.', 13);
INSERT INTO recipes VALUES (6, 'Non voluptatem dolore eius labore.', 13);

INSERT INTO ingredients VALUES (78, 706, 13, 10);
INSERT INTO ingredients VALUES (79, 145, 13, 10);
INSERT INTO ingredients VALUES (80, 238, 13, 10);
INSERT INTO ingredients VALUES (81, 739, 13, 1);
INSERT INTO ingredients VALUES (82, 625, 13, 2);
INSERT INTO ingredients VALUES (83, 995, 13, 1);
INSERT INTO ingredients VALUES (84, 11, 13, 8);
INSERT INTO ingredients VALUES (85, 148, 13, 11);

INSERT INTO receipts VALUES (1, 0, 1, 1);

INSERT INTO orders VALUES (1, 1459790506872, 10, 1, 2, NULL);
INSERT INTO orders VALUES (2, 1425312784065, 10, 1, 1, NULL);
INSERT INTO orders VALUES (3, 1429796017976, 12, 1, 2, NULL);
INSERT INTO orders VALUES (4, 1621142235714, 7, 1, 2, NULL);
INSERT INTO orders VALUES (5, 1397393056935, 7, 1, 1, NULL);
INSERT INTO orders VALUES (6, 1631925309456, 8, 1, 2, NULL);

INSERT INTO receipts VALUES (2, 0, 1, 2);

INSERT INTO orders VALUES (7, 1379478623752, 1, 2, 2, NULL);

INSERT INTO receipts VALUES (3, 0, 1, 3);

INSERT INTO orders VALUES (8, 1615481278209, 10, 3, 2, NULL);
INSERT INTO orders VALUES (9, 1425284704263, 4, 3, 1, NULL);
INSERT INTO orders VALUES (10, 1555993440627, 10, 3, 1, NULL);
INSERT INTO orders VALUES (11, 1591282404544, 9, 3, 2, NULL);
INSERT INTO orders VALUES (12, 1259821977341, 7, 3, 2, NULL);
INSERT INTO orders VALUES (13, 1237225041100, 4, 3, 1, NULL);
INSERT INTO orders VALUES (14, 1582987523120, 7, 3, 3, NULL);
INSERT INTO orders VALUES (15, 1299440338990, 13, 3, 3, NULL);
INSERT INTO orders VALUES (16, 1366018760338, 8, 3, 2, NULL);
INSERT INTO orders VALUES (17, 1471995072126, 2, 3, 3, NULL);

INSERT INTO receipts VALUES (4, 0, 2, 1);

INSERT INTO orders VALUES (18, 1402986519181, 13, 4, 2, NULL);
INSERT INTO orders VALUES (19, 1409012942204, 5, 4, 1, NULL);
INSERT INTO orders VALUES (20, 1519136399196, 1, 4, 2, NULL);
INSERT INTO orders VALUES (21, 1262899031593, 11, 4, 2, NULL);
INSERT INTO orders VALUES (22, 1454141841480, 12, 4, 3, NULL);
INSERT INTO orders VALUES (23, 1619066688777, 12, 4, 2, NULL);

INSERT INTO receipts VALUES (5, 0, 2, 2);

INSERT INTO orders VALUES (24, 1356415616083, 12, 5, 1, NULL);
INSERT INTO orders VALUES (25, 1621157802824, 7, 5, 1, NULL);
INSERT INTO orders VALUES (26, 1452318747820, 9, 5, 2, NULL);
INSERT INTO orders VALUES (27, 1145705401464, 13, 5, 3, NULL);
INSERT INTO orders VALUES (28, 1525595115469, 6, 5, 3, NULL);
INSERT INTO orders VALUES (29, 1204899314716, 11, 5, 1, NULL);
INSERT INTO orders VALUES (30, 1546887981395, 1, 5, 3, NULL);

INSERT INTO receipts VALUES (6, 0, 2, 3);

INSERT INTO orders VALUES (31, 1347952482665, 11, 6, 3, NULL);
INSERT INTO orders VALUES (32, 1171480117379, 10, 6, 3, NULL);
INSERT INTO orders VALUES (33, 1635782902977, 12, 6, 2, NULL);
INSERT INTO orders VALUES (34, 1606282670754, 9, 6, 3, NULL);
INSERT INTO orders VALUES (35, 1238746321970, 10, 6, 1, NULL);
INSERT INTO orders VALUES (36, 1480721700975, 5, 6, 1, NULL);
INSERT INTO orders VALUES (37, 1550748039687, 10, 6, 2, NULL);
INSERT INTO orders VALUES (38, 1198825305243, 8, 6, 2, NULL);
INSERT INTO orders VALUES (39, 1385706512490, 3, 6, 2, NULL);

INSERT INTO receipts VALUES (7, 0, 3, 1);

INSERT INTO orders VALUES (40, 1313553734811, 7, 7, 2, NULL);
INSERT INTO orders VALUES (41, 1296948194600, 1, 7, 3, NULL);
INSERT INTO orders VALUES (42, 1289481784277, 3, 7, 2, NULL);

INSERT INTO receipts VALUES (8, 0, 3, 2);

INSERT INTO orders VALUES (43, 1568281881071, 1, 8, 1, NULL);

INSERT INTO receipts VALUES (9, 0, 3, 3);

INSERT INTO orders VALUES (44, 1300740480053, 12, 9, 1, NULL);

INSERT INTO receipts VALUES (10, 0, 4, 1);

INSERT INTO orders VALUES (45, 1389943187040, 11, 10, 2, NULL);
INSERT INTO orders VALUES (46, 1387599747896, 9, 10, 3, NULL);
INSERT INTO orders VALUES (47, 1397977556270, 10, 10, 3, NULL);
INSERT INTO orders VALUES (48, 1566073691869, 13, 10, 3, NULL);
INSERT INTO orders VALUES (49, 1604057031197, 1, 10, 3, NULL);
INSERT INTO orders VALUES (50, 1569956147488, 6, 10, 2, NULL);
INSERT INTO orders VALUES (51, 1491325825611, 8, 10, 1, NULL);
INSERT INTO orders VALUES (52, 1304675138118, 10, 10, 2, NULL);
INSERT INTO orders VALUES (53, 1525263314698, 2, 10, 3, NULL);

INSERT INTO receipts VALUES (11, 0, 4, 2);

INSERT INTO orders VALUES (54, 1593892710915, 13, 11, 3, NULL);
INSERT INTO orders VALUES (55, 1607362577436, 8, 11, 2, NULL);
INSERT INTO orders VALUES (56, 1183287837168, 6, 11, 1, NULL);
INSERT INTO orders VALUES (57, 1556827313394, 3, 11, 3, NULL);
INSERT INTO orders VALUES (58, 1211058865805, 8, 11, 1, NULL);

INSERT INTO receipts VALUES (12, 0, 4, 3);

INSERT INTO orders VALUES (59, 1265219777534, 10, 12, 1, NULL);
INSERT INTO orders VALUES (60, 1245686061778, 3, 12, 3, NULL);
INSERT INTO orders VALUES (61, 1569382235824, 13, 12, 1, NULL);
INSERT INTO orders VALUES (62, 1495768807056, 11, 12, 2, NULL);
INSERT INTO orders VALUES (63, 1201378327647, 13, 12, 2, NULL);

INSERT INTO receipts VALUES (13, 0, 5, 1);

INSERT INTO orders VALUES (64, 1368687143434, 6, 13, 2, NULL);

INSERT INTO receipts VALUES (14, 0, 5, 2);

INSERT INTO orders VALUES (65, 1216768931841, 3, 14, 3, NULL);
INSERT INTO orders VALUES (66, 1628516363220, 9, 14, 3, NULL);
INSERT INTO orders VALUES (67, 1221825170378, 4, 14, 1, NULL);
INSERT INTO orders VALUES (68, 1211898765995, 8, 14, 1, NULL);
INSERT INTO orders VALUES (69, 1491600547926, 3, 14, 2, NULL);
INSERT INTO orders VALUES (70, 1568202316843, 11, 14, 3, NULL);

INSERT INTO receipts VALUES (15, 0, 5, 3);

INSERT INTO orders VALUES (71, 1441709286080, 3, 15, 3, NULL);

INSERT INTO receipts VALUES (16, 0, 6, 1);

INSERT INTO orders VALUES (72, 1498444034272, 2, 16, 1, NULL);
INSERT INTO orders VALUES (73, 1351195958099, 5, 16, 2, NULL);
INSERT INTO orders VALUES (74, 1146504475539, 12, 16, 1, NULL);
INSERT INTO orders VALUES (75, 1238314653466, 5, 16, 2, NULL);
INSERT INTO orders VALUES (76, 1470155916862, 2, 16, 1, NULL);
INSERT INTO orders VALUES (77, 1516192460483, 9, 16, 3, NULL);
INSERT INTO orders VALUES (78, 1521090138579, 6, 16, 2, NULL);

INSERT INTO receipts VALUES (17, 0, 6, 2);

INSERT INTO orders VALUES (79, 1391569221779, 6, 17, 3, NULL);
INSERT INTO orders VALUES (80, 1166266269651, 6, 17, 3, NULL);

INSERT INTO receipts VALUES (18, 0, 6, 3);

INSERT INTO orders VALUES (81, 1365361925428, 12, 18, 3, NULL);
INSERT INTO orders VALUES (82, 1596115487401, 1, 18, 1, NULL);
INSERT INTO orders VALUES (83, 1285019227521, 12, 18, 2, NULL);
INSERT INTO orders VALUES (84, 1280016491438, 2, 18, 3, NULL);
INSERT INTO orders VALUES (85, 1547725475148, 5, 18, 1, NULL);
INSERT INTO orders VALUES (86, 1497445822040, 11, 18, 1, NULL);
INSERT INTO orders VALUES (87, 1541117155561, 3, 18, 3, NULL);
INSERT INTO orders VALUES (88, 1451611970258, 13, 18, 1, NULL);

INSERT INTO receipts VALUES (19, 0, 7, 1);

INSERT INTO orders VALUES (89, 1542828924246, 5, 19, 2, NULL);
INSERT INTO orders VALUES (90, 1621905983281, 1, 19, 1, NULL);
INSERT INTO orders VALUES (91, 1586535335533, 7, 19, 2, NULL);
INSERT INTO orders VALUES (92, 1477624898971, 13, 19, 2, NULL);
INSERT INTO orders VALUES (93, 1323295559566, 12, 19, 2, NULL);
INSERT INTO orders VALUES (94, 1319841902785, 4, 19, 2, NULL);

INSERT INTO receipts VALUES (20, 0, 7, 2);

INSERT INTO orders VALUES (95, 1276969201302, 9, 20, 3, NULL);
INSERT INTO orders VALUES (96, 1582379556702, 13, 20, 1, NULL);
INSERT INTO orders VALUES (97, 1269208517122, 10, 20, 1, NULL);
INSERT INTO orders VALUES (98, 1241773235155, 10, 20, 2, NULL);

INSERT INTO receipts VALUES (21, 0, 7, 3);

INSERT INTO orders VALUES (99, 1496918368951, 6, 21, 1, NULL);
INSERT INTO orders VALUES (100, 1523049561103, 9, 21, 2, NULL);
INSERT INTO orders VALUES (101, 1251055093306, 4, 21, 2, NULL);
INSERT INTO orders VALUES (102, 1288983514732, 6, 21, 2, NULL);

INSERT INTO receipts VALUES (22, 0, 8, 1);

INSERT INTO orders VALUES (103, 1414440468645, 13, 22, 2, NULL);
INSERT INTO orders VALUES (104, 1495758947874, 8, 22, 1, NULL);
INSERT INTO orders VALUES (105, 1235623853223, 12, 22, 1, NULL);
INSERT INTO orders VALUES (106, 1239775432476, 13, 22, 1, NULL);
INSERT INTO orders VALUES (107, 1350013831255, 2, 22, 1, NULL);

INSERT INTO receipts VALUES (23, 0, 8, 2);

INSERT INTO orders VALUES (108, 1382997271919, 2, 23, 1, NULL);
INSERT INTO orders VALUES (109, 1371313087425, 2, 23, 1, NULL);
INSERT INTO orders VALUES (110, 1176635786533, 13, 23, 3, NULL);

INSERT INTO receipts VALUES (24, 0, 8, 3);

INSERT INTO orders VALUES (111, 1491425160306, 5, 24, 1, NULL);
INSERT INTO orders VALUES (112, 1381860359661, 12, 24, 1, NULL);
INSERT INTO orders VALUES (113, 1359225458632, 8, 24, 3, NULL);
INSERT INTO orders VALUES (114, 1272596327105, 8, 24, 1, NULL);

INSERT INTO receipts VALUES (25, 0, 9, 1);

INSERT INTO orders VALUES (115, 1483107334500, 12, 25, 1, NULL);
INSERT INTO orders VALUES (116, 1284721622322, 8, 25, 1, NULL);
INSERT INTO orders VALUES (117, 1601902624171, 13, 25, 1, NULL);
INSERT INTO orders VALUES (118, 1194195685173, 9, 25, 3, NULL);
INSERT INTO orders VALUES (119, 1185744996522, 11, 25, 2, NULL);
INSERT INTO orders VALUES (120, 1626862384275, 12, 25, 3, NULL);
INSERT INTO orders VALUES (121, 1162634242950, 2, 25, 1, NULL);

INSERT INTO receipts VALUES (26, 0, 9, 2);

INSERT INTO orders VALUES (122, 1603045750692, 3, 26, 3, NULL);
INSERT INTO orders VALUES (123, 1359851854856, 9, 26, 1, NULL);
INSERT INTO orders VALUES (124, 1394256557262, 12, 26, 3, NULL);
INSERT INTO orders VALUES (125, 1608635094841, 11, 26, 3, NULL);
INSERT INTO orders VALUES (126, 1638119108082, 11, 26, 2, NULL);
INSERT INTO orders VALUES (127, 1482167439174, 9, 26, 2, NULL);
INSERT INTO orders VALUES (128, 1370740566788, 4, 26, 1, NULL);
INSERT INTO orders VALUES (129, 1528669253519, 7, 26, 1, NULL);
INSERT INTO orders VALUES (130, 1407592933832, 2, 26, 3, NULL);
INSERT INTO orders VALUES (131, 1435944914996, 2, 26, 1, NULL);

INSERT INTO receipts VALUES (27, 0, 9, 3);

INSERT INTO orders VALUES (132, 1238037906197, 6, 27, 1, NULL);
INSERT INTO orders VALUES (133, 1268951541390, 6, 27, 2, NULL);
INSERT INTO orders VALUES (134, 1491792602506, 1, 27, 1, NULL);
INSERT INTO orders VALUES (135, 1604177702082, 12, 27, 2, NULL);
INSERT INTO orders VALUES (136, 1233711706324, 10, 27, 2, NULL);
INSERT INTO orders VALUES (137, 1434611831028, 6, 27, 3, NULL);
INSERT INTO orders VALUES (138, 1446404183299, 10, 27, 3, NULL);


COMMIT;
