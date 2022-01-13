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

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE close_receipt(p_id NUMBER)
AS
    v_not_ready_orders NUMBER;
    v_payment NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_not_ready_orders
    FROM receipts r
    JOIN orders o ON r.id = o.receipt_id
    JOIN dishes d ON o.dish_id = d.id
    WHERE r.id = p_id AND o.status != 3;

    IF v_not_ready_orders != 0 THEN
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

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE increase_product_quantity(p_name VARCHAR2, p_quantity NUMBER)
AS
BEGIN
    UPDATE products
    SET quantity = quantity + p_quantity
    WHERE LOWER(name) LIKE '%' || LOWER(p_name) || '%';

    IF SQL%ROWCOUNT != 1 THEN
        RAISE_APPLICATION_ERROR(-20003, SQL%ROWCOUNT || ' rows affected! Abborting procedure!');
    END IF;
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
