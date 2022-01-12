--------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER tg_orders_insert
BEFORE INSERT ON orders 
FOR EACH ROW
DECLARE
    v_quantity NUMBER;
BEGIN
    FOR ingredient IN (SELECT * FROM ingredients WHERE dish_id = :new.dish_id)
    LOOP
        UPDATE products
        SET quantity = quantity - ingredient.quantity
        WHERE id = ingredient.product_id
        RETURNING quantity INTO v_quantity;
        
        IF v_quantity < 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Not enough products available to prepare this order!');
        END IF;
    END LOOP;
END;
/
SELECT * FROM products;

INSERT INTO orders VALUES (0, 0, 1, 1, 1, NULL);

SELECT * FROM products;

UPDATE ingredients
SET quantity = 1000000;

INSERT INTO orders VALUES (-1, 0, 1, 1, 1, NULL);

SELECT * FROM products;
SELECT * FROM ingredients;

ROLLBACK;

--------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER tg_orders_delete
AFTER DELETE ON orders
FOR EACH ROW
BEGIN
    FOR ingredient IN (SELECT * FROM ingredients WHERE dish_id = :old.dish_id)
    LOOP
        UPDATE products
        SET quantity = quantity + ingredient.quantity
        WHERE id = ingredient.product_id;
    END LOOP;
END;
/

INSERT INTO orders VALUES (0, 0, 1, 1, 1, NULL);
SELECT * FROM products;
DELETE FROM orders WHERE id = 0;
SELECT * FROM products;

ROLLBACK;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE close_receipt(p_id NUMBER)
AS
    v_not_ready_orders NUMBER;
    v_payment NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_payment
    FROM receipts r
    JOIN orders o ON r.id = o.receipt_id
    JOIN dishes d ON o.dish_id = d.id
    WHERE r.id = 1 AND o.status != 3;
    
    IF v_payment != 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Cannot close receipt with ongoing orders!');
    END IF;
    
    SELECT SUM(d.price)
    INTO v_payment
    FROM receipts r
    JOIN orders o ON r.id = o.receipt_id
    JOIN dishes d ON o.dish_id = d.id
    WHERE r.id = p_id;
    
    UPDATE receipts
    SET payment = v_payment
    WHERE id = p_id;
END;
/

SELECT *
FROM receipts r
JOIN orders o ON r.id = o.receipt_id
JOIN dishes d ON o.dish_id = d.id
WHERE r.id = 1;

EXEC CLOSE_RECEIPT(1);

UPDATE orders 
SET status = 3 
WHERE receipt_id = 1;

SELECT *
FROM receipts r
JOIN orders o ON r.id = o.receipt_id
JOIN dishes d ON o.dish_id = d.id
WHERE r.id = 1;

EXEC CLOSE_RECEIPT(1);

SELECT * FROM receipts WHERE id = 1;

ROLLBACK;

--------------------------------------------------------------------------------

CREATE OR REPLACE
PROCEDURE test_procedure(
        p_in IN NUMBER,
        p_in_out IN OUT NUMBER,
        p_out OUT NUMBER
    )
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE(p_in);
    DBMS_OUTPUT.PUT_LINE(p_in_out);
    DBMS_OUTPUT.PUT_LINE(p_out);
--    p_in := 4;
    p_in_out := 5;
    p_out := 6;
END;
/
DECLARE
    a NUMBER := 1;
    b NUMBER := 2;
    c NUMBER := 3;
BEGIN
    DBMS_OUTPUT.PUT_LINE(a);
    DBMS_OUTPUT.PUT_LINE(b);
    DBMS_OUTPUT.PUT_LINE(c);
    DBMS_OUTPUT.PUT_LINE( '---');
    TEST_PROCEDURE(a, b, c);
    DBMS_OUTPUT.PUT_LINE( '---');
    DBMS_OUTPUT.PUT_LINE(a);
    DBMS_OUTPUT.PUT_LINE(b);
    DBMS_OUTPUT.PUT_LINE(c);
END;
/

--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION calculate_total_sum_of_employees_receipts(p_id NUMBER)
RETURN NUMBER
AS
    v_total_payment NUMBER;
BEGIN
    SELECT SUM(payment)
    INTO v_total_payment
    FROM receipts WHERE employee_id = p_id;
    
    RETURN ROUND(v_total_payment / 100, 2);
END;
/

SELECT e.*, calculate_total_sum_of_employees_receipts(e.id) earnings 
FROM employees e
WHERE e.employee_kind_id = 1;

--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION calculate_total_worth_of_prepared_dishes(p_id NUMBER)
RETURN NUMBER
AS
    v_total_worth NUMBER;
BEGIN
    SELECT SUM(d.price)
    INTO v_total_worth
    FROM dishes d
    JOIN orders o ON d.id = o.dish_id
    WHERE o.employee_id = p_id AND o.status IN (2, 3);
    
    RETURN ROUND(v_total_worth / 100, 2);
END;
/

SELECT e.*, calculate_total_worth_of_prepared_dishes(e.id) worth 
FROM employees e
WHERE e.employee_kind_id = 2;