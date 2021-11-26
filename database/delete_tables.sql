DECLARE
    v_count  INT;
    v_name VARCHAR2(20);
    TYPE namesarray IS VARRAY(14) OF VARCHAR2(20);
    names    namesarray;
BEGIN
    names := namesarray('dish_categories', 'dishes', 'employee_kinds', 'employee_kind', 'employees', 'ingredients',
                       'orders', 'product_categories', 'products', 'receipts',
                       'recipes', 'recipe', 'special_requests', 'tables');

    FOR i IN 1..names.count LOOP
        v_name := names(i);
        
        SELECT COUNT(*) INTO v_count FROM user_tables WHERE table_name = upper(v_name);
        IF v_count = 1 THEN
            DBMS_OUTPUT.PUT_LINE('Dropping table: ' || v_name);
            EXECUTE IMMEDIATE 'DROP TABLE '|| v_name || ' CASCADE CONSTRAINTS';
        END IF;
    END LOOP;
END;
