DECLARE
    v_count  INT;
    v_name VARCHAR2(20);
    TYPE namesarray IS VARRAY(14) OF VARCHAR2(20);
    names    namesarray;
BEGIN
    names := namesarray('special_requests', 'orders', 'receipts', 'recipes', 'ingredients', 'dishes', 'dish_categories', 'employees', 'employee_kinds',
                        'products', 'product_categories',
                         'tables');

    FOR i IN 1..names.count LOOP
        v_name := names(i);

        EXECUTE IMMEDIATE 'DELETE FROM ' || v_name;
    END LOOP;
END;
