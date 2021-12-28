INSERT INTO employee_kinds VALUES (1, 'waiter');
INSERT INTO employee_kinds VALUES (2, 'cook');

INSERT INTO employees VALUES (1, 'Kamil', 'Sulkowski', 1);
INSERT INTO employees VALUES (2, 'Kamil', 'Sulkowski', 1);
INSERT INTO employees VALUES (3, 'Kamil', 'Sudol', 1);
INSERT INTO employees VALUES (4, 'Karol', 'Sudol', 1);
INSERT INTO employees VALUES (5, 'Bartlomiej', 'Krawczyk', 1);
INSERT INTO employees VALUES (6, 'Bartlomiej', 'Sudol', 2);
INSERT INTO employees VALUES (7, 'Adam', 'Rogozinski', 2);
INSERT INTO employees VALUES (8, 'Bartlomiej', 'Sudol', 2);
INSERT INTO employees VALUES (9, 'Karol', 'Rogozinski', 2);
INSERT INTO employees VALUES (10, 'Adam', 'Sulkowski', 2);
INSERT INTO employees VALUES (11, 'Bartlomiej', 'Krawczyk', 2);
INSERT INTO employees VALUES (12, 'Karol', 'Krawczyk', 2);

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

INSERT INTO dishes VALUES (1, 'Tomato', NULL, 6763, '1');

INSERT INTO recipes VALUES (1, 'Quisquam neque sit dolore ut.', 1);
INSERT INTO recipes VALUES (2, 'Neque consectetur amet porro dolor modi sed porro.', 1);
INSERT INTO recipes VALUES (3, 'Dolor consectetur dolorem non adipisci quisquam etincidunt consectetur.', 1);
INSERT INTO recipes VALUES (4, 'Dolore sit tempora sit est numquam adipisci ut.', 1);
INSERT INTO recipes VALUES (5, 'Quaerat non tempora voluptatem quisquam dolorem.', 1);

INSERT INTO ingredients VALUES (1, 829, 1, 4);
INSERT INTO ingredients VALUES (2, 318, 1, 10);
INSERT INTO ingredients VALUES (3, 325, 1, 6);
INSERT INTO ingredients VALUES (4, 491, 1, 12);
INSERT INTO ingredients VALUES (5, 95, 1, 1);
INSERT INTO ingredients VALUES (6, 761, 1, 2);

INSERT INTO dishes VALUES (2, 'Chicken', NULL, 6771, '1');

INSERT INTO recipes VALUES (1, 'Non adipisci tempora porro voluptatem.', 2);
INSERT INTO recipes VALUES (2, 'Dolorem porro tempora quiquia magnam sed.', 2);
INSERT INTO recipes VALUES (3, 'Ipsum dolorem sit aliquam sed dolor ut.', 2);

INSERT INTO ingredients VALUES (7, 214, 2, 7);
INSERT INTO ingredients VALUES (8, 741, 2, 10);
INSERT INTO ingredients VALUES (9, 612, 2, 9);
INSERT INTO ingredients VALUES (10, 433, 2, 5);
INSERT INTO ingredients VALUES (11, 583, 2, 11);
INSERT INTO ingredients VALUES (12, 335, 2, 8);
INSERT INTO ingredients VALUES (13, 644, 2, 10);
INSERT INTO ingredients VALUES (14, 266, 2, 2);
INSERT INTO ingredients VALUES (15, 501, 2, 7);

INSERT INTO dish_categories VALUES (2, 'Main Course', NULL);

INSERT INTO dishes VALUES (3, 'Beef', NULL, 7901, '2');

INSERT INTO recipes VALUES (1, 'Numquam quiquia velit dolore.', 3);
INSERT INTO recipes VALUES (2, 'Neque neque amet ipsum.', 3);

INSERT INTO ingredients VALUES (16, 977, 3, 12);
INSERT INTO ingredients VALUES (17, 844, 3, 7);
INSERT INTO ingredients VALUES (18, 439, 3, 11);
INSERT INTO ingredients VALUES (19, 388, 3, 12);
INSERT INTO ingredients VALUES (20, 98, 3, 11);

INSERT INTO dish_categories VALUES (3, 'Drinks', NULL);

INSERT INTO dishes VALUES (4, 'A drink', NULL, 8016, '3');

INSERT INTO recipes VALUES (1, 'Numquam eius ipsum porro tempora.', 4);
INSERT INTO recipes VALUES (2, 'Amet sed aliquam ut eius.', 4);
INSERT INTO recipes VALUES (3, 'Adipisci dolore dolore dolor labore.', 4);
INSERT INTO recipes VALUES (4, 'Tempora non adipisci quiquia ipsum etincidunt numquam.', 4);
INSERT INTO recipes VALUES (5, 'Velit etincidunt etincidunt neque ipsum.', 4);
INSERT INTO recipes VALUES (6, 'Ipsum amet etincidunt eius neque est non adipisci.', 4);
INSERT INTO recipes VALUES (7, 'Tempora quisquam adipisci non etincidunt etincidunt dolore.', 4);
INSERT INTO recipes VALUES (8, 'Etincidunt etincidunt porro amet.', 4);

INSERT INTO ingredients VALUES (21, 895, 4, 7);
INSERT INTO ingredients VALUES (22, 457, 4, 8);

INSERT INTO receipts VALUES (1, 0, 1, 1);

INSERT INTO orders VALUES (1, 1530864616068, 2, 1, 3, NULL);
INSERT INTO orders VALUES (2, 1379996362231, 4, 1, 2, NULL);
INSERT INTO orders VALUES (3, 1234772882166, 3, 1, 2, NULL);
INSERT INTO orders VALUES (4, 1553527903902, 4, 1, 1, NULL);
INSERT INTO orders VALUES (5, 1463096154474, 1, 1, 3, NULL);
INSERT INTO orders VALUES (6, 1201454448716, 1, 1, 3, NULL);

INSERT INTO receipts VALUES (2, 0, 1, 2);

INSERT INTO orders VALUES (7, 1479667226341, 1, 2, 1, NULL);
INSERT INTO orders VALUES (8, 1603325178527, 1, 2, 1, NULL);
INSERT INTO orders VALUES (9, 1430363884596, 1, 2, 3, NULL);

INSERT INTO receipts VALUES (3, 0, 1, 3);

INSERT INTO orders VALUES (10, 1608129449334, 2, 3, 3, NULL);
INSERT INTO orders VALUES (11, 1509705653939, 4, 3, 2, NULL);
INSERT INTO orders VALUES (12, 1323259157137, 4, 3, 1, NULL);
INSERT INTO orders VALUES (13, 1247208696760, 4, 3, 1, NULL);
INSERT INTO orders VALUES (14, 1570847310949, 2, 3, 3, NULL);
INSERT INTO orders VALUES (15, 1568809790604, 4, 3, 2, NULL);
INSERT INTO orders VALUES (16, 1509309140895, 4, 3, 1, NULL);
INSERT INTO orders VALUES (17, 1232212762531, 3, 3, 3, NULL);

INSERT INTO receipts VALUES (4, 0, 2, 1);

INSERT INTO orders VALUES (18, 1146277365663, 4, 4, 3, NULL);
INSERT INTO orders VALUES (19, 1574659556250, 2, 4, 2, NULL);
INSERT INTO orders VALUES (20, 1301455762615, 3, 4, 1, NULL);

INSERT INTO receipts VALUES (5, 0, 2, 2);

INSERT INTO orders VALUES (21, 1523690787249, 3, 5, 2, NULL);
INSERT INTO orders VALUES (22, 1456418106125, 2, 5, 1, NULL);

INSERT INTO receipts VALUES (6, 0, 2, 3);

INSERT INTO orders VALUES (23, 1416202900039, 2, 6, 2, NULL);
INSERT INTO orders VALUES (24, 1322462071217, 3, 6, 3, NULL);
INSERT INTO orders VALUES (25, 1290471796504, 3, 6, 3, NULL);
INSERT INTO orders VALUES (26, 1177158870501, 3, 6, 2, NULL);
INSERT INTO orders VALUES (27, 1593815143012, 2, 6, 3, NULL);
INSERT INTO orders VALUES (28, 1589821434368, 2, 6, 1, NULL);
INSERT INTO orders VALUES (29, 1561263609778, 2, 6, 2, NULL);
INSERT INTO orders VALUES (30, 1361028832823, 1, 6, 3, NULL);
INSERT INTO orders VALUES (31, 1260581348259, 1, 6, 1, NULL);

INSERT INTO receipts VALUES (7, 0, 3, 1);

INSERT INTO orders VALUES (32, 1350352625348, 3, 7, 2, NULL);
INSERT INTO orders VALUES (33, 1511409321739, 2, 7, 2, NULL);
INSERT INTO orders VALUES (34, 1294313795064, 3, 7, 2, NULL);
INSERT INTO orders VALUES (35, 1308667461737, 2, 7, 3, NULL);
INSERT INTO orders VALUES (36, 1592200409359, 2, 7, 2, NULL);
INSERT INTO orders VALUES (37, 1315779263078, 3, 7, 1, NULL);
INSERT INTO orders VALUES (38, 1640684126853, 2, 7, 1, NULL);
INSERT INTO orders VALUES (39, 1369011505253, 4, 7, 2, NULL);
INSERT INTO orders VALUES (40, 1571805855271, 3, 7, 1, NULL);

INSERT INTO receipts VALUES (8, 0, 3, 2);

INSERT INTO orders VALUES (41, 1618295089948, 4, 8, 2, NULL);
INSERT INTO orders VALUES (42, 1501364029179, 2, 8, 3, NULL);
INSERT INTO orders VALUES (43, 1147041881370, 1, 8, 2, NULL);
INSERT INTO orders VALUES (44, 1250886090251, 4, 8, 2, NULL);
INSERT INTO orders VALUES (45, 1330918749381, 2, 8, 2, NULL);
INSERT INTO orders VALUES (46, 1552336351394, 4, 8, 3, NULL);
INSERT INTO orders VALUES (47, 1379507380774, 2, 8, 1, NULL);
INSERT INTO orders VALUES (48, 1219385041581, 3, 8, 3, NULL);

INSERT INTO receipts VALUES (9, 0, 3, 3);

INSERT INTO orders VALUES (49, 1315381034146, 4, 9, 3, NULL);
INSERT INTO orders VALUES (50, 1399687237171, 2, 9, 1, NULL);

INSERT INTO receipts VALUES (10, 0, 4, 1);

INSERT INTO orders VALUES (51, 1596796289971, 4, 10, 3, NULL);
INSERT INTO orders VALUES (52, 1548181890264, 3, 10, 3, NULL);
INSERT INTO orders VALUES (53, 1214459675463, 1, 10, 1, NULL);
INSERT INTO orders VALUES (54, 1243203510360, 3, 10, 3, NULL);
INSERT INTO orders VALUES (55, 1254649523190, 1, 10, 1, NULL);

INSERT INTO receipts VALUES (11, 0, 4, 2);

INSERT INTO orders VALUES (56, 1585431642996, 2, 11, 1, NULL);
INSERT INTO orders VALUES (57, 1274010194566, 4, 11, 1, NULL);

INSERT INTO receipts VALUES (12, 0, 4, 3);

INSERT INTO orders VALUES (58, 1224485642546, 3, 12, 2, NULL);
INSERT INTO orders VALUES (59, 1506262880769, 1, 12, 2, NULL);
INSERT INTO orders VALUES (60, 1273368470412, 1, 12, 1, NULL);
INSERT INTO orders VALUES (61, 1311425263879, 2, 12, 2, NULL);
INSERT INTO orders VALUES (62, 1564517380596, 2, 12, 3, NULL);
INSERT INTO orders VALUES (63, 1586548720039, 1, 12, 1, NULL);

INSERT INTO receipts VALUES (13, 0, 5, 1);

INSERT INTO orders VALUES (64, 1282851377713, 2, 13, 3, NULL);

INSERT INTO receipts VALUES (14, 0, 5, 2);

INSERT INTO orders VALUES (65, 1300097669690, 1, 14, 1, NULL);
INSERT INTO orders VALUES (66, 1421593953270, 4, 14, 2, NULL);
INSERT INTO orders VALUES (67, 1484946377054, 3, 14, 2, NULL);
INSERT INTO orders VALUES (68, 1349036266208, 3, 14, 3, NULL);
INSERT INTO orders VALUES (69, 1488113784316, 1, 14, 1, NULL);
INSERT INTO orders VALUES (70, 1415876726541, 1, 14, 1, NULL);
INSERT INTO orders VALUES (71, 1591205166721, 1, 14, 3, NULL);
INSERT INTO orders VALUES (72, 1483189978975, 2, 14, 1, NULL);
INSERT INTO orders VALUES (73, 1259731167077, 2, 14, 3, NULL);
INSERT INTO orders VALUES (74, 1357564988031, 4, 14, 1, NULL);

INSERT INTO receipts VALUES (15, 0, 5, 3);

INSERT INTO orders VALUES (75, 1513955487795, 1, 15, 1, NULL);
INSERT INTO orders VALUES (76, 1274681848094, 4, 15, 3, NULL);
INSERT INTO orders VALUES (77, 1508089797851, 2, 15, 1, NULL);


COMMIT;
