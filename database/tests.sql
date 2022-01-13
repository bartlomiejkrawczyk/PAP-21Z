-- skrypty powinny zawierać nietrywialne zapytania wykorzystujące różne rodzaje złączeń, filtrowanie, grupowanie danych a także zaimplementowane funkcje, wywołania procedur, prezentacje działania triggerów


--------------------------------------------------------------------------------
-- Nie trywialne zapytania wykorzystujące różne rodzaje złączeń, filtrowanie, grupowanie danych
--------------------------------------------------------------------------------

-- Opłacone rachunki przypisane do kelnerów
SELECT r.id, e.first_name, e.family_name, r.payment
FROM employees e
JOIN receipts r ON r.employee_id = e.id
WHERE payment != 0;

-- Wszystkie zaserwowane dania oraz kelner je podający
SELECT e.id, e.first_name, e.family_name, d.name
FROM employees e
JOIN receipts r ON r.employee_id = e.id
JOIN orders o ON o.receipt_id = r.id
JOIN dishes d ON o.dish_id = d.id
WHERE o.status = 3;

-- Sumaryczna cena wszystkich podanych dań, przypisana do kelnerów
SELECT e.id, e.first_name, e.family_name, sum(d.price)
FROM employees e
JOIN receipts r ON r.employee_id = e.id
JOIN orders o ON o.receipt_id = r.id
JOIN dishes d ON o.dish_id = d.id
WHERE o.status = 3
GROUP BY e.id, e.first_name, e.family_name;


-- Ilość wszystkich wydanych dań danego typu
SELECT d.id, d.name, COUNT(*)
FROM dishes d
JOIN orders o ON o.dish_id = d.id
WHERE o.status = 3
GROUP BY d.id, d.name
ORDER BY COUNT(*) DESC;

--
SELECT *
FROM special_requests rq
RIGHT JOIN orders o ON o.id = rq.order_id;


--------------------------------------------------------------------------------
-- Prezentacja działania triggerów
--------------------------------------------------------------------------------

-- TRIGGER tg_orders_insert
DECLARE
    v_new_id NUMBER;
    v_receipt_id NUMBER;
BEGIN
    SELECT id + 1 INTO v_new_id FROM orders ORDER BY id DESC FETCH FIRST 1 ROW ONLY;
    SELECT r.id INTO v_receipt_id FROM receipts r WHERE r.payment = 0 FETCH FIRST 1 ROW ONLY;

    FOR ingredient IN (SELECT p.* FROM ingredients i JOIN dishes d ON d.id = i.dish_id JOIN products p ON p.id = i.product_id WHERE d.id = 1)
    LOOP
        DBMS_OUTPUT.PUT_LINE(ingredient.name || ' ' || ingredient.quantity);
    END LOOP;

    INSERT INTO orders VALUES (v_new_id, 0, 1, v_receipt_id, 1, NULL);
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------------------------------');

    FOR ingredient IN (SELECT p.* FROM ingredients i JOIN dishes d ON d.id = i.dish_id JOIN products p ON p.id = i.product_id WHERE d.id = 1)
    LOOP
        DBMS_OUTPUT.PUT_LINE(ingredient.name || ' ' || ingredient.quantity);
    END LOOP;

    ROLLBACK;
END;
/

DECLARE
    v_max_quantity NUMBER;
    v_new_id NUMBER;
    v_receipt_id NUMBER;
BEGIN
    SELECT MAX(quantity) INTO v_max_quantity FROM products;

    UPDATE ingredients
    SET quantity = v_max_quantity;

    SELECT id + 1 INTO v_new_id FROM orders ORDER BY id DESC FETCH FIRST 1 ROW ONLY;
    SELECT r.id INTO v_receipt_id FROM receipts r WHERE r.payment = 0 FETCH FIRST 1 ROW ONLY;

    INSERT INTO orders VALUES (v_new_id, 0, 1, v_receipt_id, 1, NULL);

    ROLLBACK;
END;
/

--------------------------------------------------------------------------------

-- TRIGGER tg_orders_delete

DECLARE
    v_new_id NUMBER;
    v_receipt_id NUMBER;
BEGIN
    SELECT id + 1 INTO v_new_id FROM orders ORDER BY id DESC FETCH FIRST 1 ROW ONLY;
    SELECT r.id INTO v_receipt_id FROM receipts r WHERE r.payment = 0 FETCH FIRST 1 ROW ONLY;

    INSERT INTO orders VALUES (v_new_id, 0, 1, v_receipt_id, 1, NULL);

    FOR ingredient IN (SELECT p.* FROM ingredients i JOIN dishes d ON d.id = i.dish_id JOIN products p ON p.id = i.product_id WHERE d.id = 1)
    LOOP
        DBMS_OUTPUT.PUT_LINE(ingredient.name || ' ' || ingredient.quantity);
    END LOOP;

    DELETE FROM orders WHERE id = v_new_id;

    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------------------------------');

    FOR ingredient IN (SELECT p.* FROM ingredients i JOIN dishes d ON d.id = i.dish_id JOIN products p ON p.id = i.product_id WHERE d.id = 1)
    LOOP
        DBMS_OUTPUT.PUT_LINE(ingredient.name || ' ' || ingredient.quantity);
    END LOOP;

    ROLLBACK;
END;
/


--------------------------------------------------------------------------------
-- Wywołania procedur
--------------------------------------------------------------------------------

-- PROCEDURE close_receipt(p_id NUMBER)

DECLARE
    v_receipt_id NUMBER;
BEGIN
    SELECT r.id
    INTO v_receipt_id
    FROM receipts r
    JOIN orders o ON o.receipt_id = r.id
    WHERE o.status != 3
    FETCH FIRST 1 ROW ONLY;

    CLOSE_RECEIPT(v_receipt_id);
END;
/

DECLARE
    v_receipt_id NUMBER;
    v_payment NUMBER;
BEGIN
    SELECT r.id
    INTO v_receipt_id
    FROM receipts r
    JOIN orders o ON o.receipt_id = r.id
    WHERE payment = 0
        AND o.id IS NOT NULL
    FETCH FIRST 1 ROW ONLY;

    UPDATE orders
    SET status = 3
    WHERE receipt_id = v_receipt_id;

    CLOSE_RECEIPT(v_receipt_id);

    SELECT payment INTO v_payment FROM receipts WHERE id = v_receipt_id;
    DBMS_OUTPUT.PUT_LINE('Payment: ' || v_payment);

    ROLLBACK;
END;
/

--------------------------------------------------------------------------------

-- increase_product_quantity(p_name VARCHAR2, p_quantity NUMBER)

SELECT * FROM products WHERE id = 12;

EXEC increase_product_quantity('apple', 100);

SELECT * FROM products WHERE id = 12;

ROLLBACK;

EXEC increase_product_quantity('cola', 100);

EXEC increase_product_quantity('abc', 100);

--------------------------------------------------------------------------------
-- Zastosowane funkcje
--------------------------------------------------------------------------------

-- FUNCTION calculate_total_sum_of_employees_receipts(p_id NUMBER)

SELECT e.*, calculate_total_sum_of_employees_receipts(e.id) earnings
FROM employees e
WHERE e.employee_kind_id = 1;

--------------------------------------------------------------------------------

-- FUNCTION calculate_total_worth_of_prepared_dishes(p_id NUMBER)

SELECT e.*, calculate_total_worth_of_prepared_dishes(e.id) worth
FROM employees e
WHERE e.employee_kind_id = 2;

