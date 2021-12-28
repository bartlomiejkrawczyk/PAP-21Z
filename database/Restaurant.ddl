-- Generated by Oracle SQL Developer Data Modeler 21.2.0.165.1515
--   at:        2021-12-28 13:37:06 CET
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE dish_categories (
    id         NUMBER NOT NULL,
    name       VARCHAR2(63 BYTE) NOT NULL,
    image_path VARCHAR2(255 BYTE)
);

ALTER TABLE dish_categories ADD CONSTRAINT dish_categories_pk PRIMARY KEY ( id );

CREATE TABLE dishes (
    id               NUMBER NOT NULL,
    name             VARCHAR2(63 BYTE) NOT NULL,
    image_path       VARCHAR2(255 BYTE),
    price            NUMBER(9) NOT NULL,
    dish_category_id NUMBER NOT NULL
);

ALTER TABLE dishes ADD CONSTRAINT dishes_pk PRIMARY KEY ( id );

CREATE TABLE employee_kinds (
    id   NUMBER NOT NULL,
    name VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE employee_kinds ADD CONSTRAINT employee_kinds_pk PRIMARY KEY ( id );

CREATE TABLE employees (
    id               NUMBER NOT NULL,
    first_name       VARCHAR2(63 BYTE) NOT NULL,
    family_name      VARCHAR2(255 BYTE) NOT NULL,
    employee_kind_id NUMBER NOT NULL
);

ALTER TABLE employees ADD CONSTRAINT employees_pk PRIMARY KEY ( id );

CREATE TABLE ingredients (
    id         NUMBER NOT NULL,
    quantity   NUMBER(16) NOT NULL,
    dish_id    NUMBER NOT NULL,
    product_id NUMBER NOT NULL
);

ALTER TABLE ingredients ADD CONSTRAINT ingredients_pk PRIMARY KEY ( id );

CREATE TABLE orders (
    id          NUMBER NOT NULL,
    "date"      NUMBER(14) NOT NULL,
    dish_id     NUMBER NOT NULL,
    receipt_id  NUMBER NOT NULL,
    status      NUMBER(2) NOT NULL,
    employee_id NUMBER
);

ALTER TABLE orders ADD CONSTRAINT orders_pk PRIMARY KEY ( id );

ALTER TABLE orders ADD CONSTRAINT orders_id_un UNIQUE ( id );

CREATE TABLE product_categories (
    id   NUMBER NOT NULL,
    name VARCHAR2(63 BYTE) NOT NULL
);

ALTER TABLE product_categories ADD CONSTRAINT product_categories_pk PRIMARY KEY ( id );

CREATE TABLE products (
    id                  NUMBER NOT NULL,
    name                VARCHAR2(63 BYTE) NOT NULL,
    quantity            NUMBER(16) NOT NULL,
    min_quantity        NUMBER(16),
    unit                VARCHAR2(10 CHAR) NOT NULL,
    product_category_id NUMBER NOT NULL
);

ALTER TABLE products ADD CONSTRAINT products_pk PRIMARY KEY ( id );

CREATE TABLE receipts (
    id          NUMBER NOT NULL,
    payment     NUMBER(9),
    employee_id NUMBER NOT NULL,
    table_id    NUMBER NOT NULL
);

ALTER TABLE receipts ADD CONSTRAINT receipts_pk PRIMARY KEY ( id );

CREATE TABLE recipes (
    step    NUMBER(3) NOT NULL,
    recipe  VARCHAR2(500 CHAR) NOT NULL,
    dish_id NUMBER NOT NULL
);

ALTER TABLE recipes ADD CONSTRAINT recipe_pk PRIMARY KEY ( dish_id,
                                                           step );

CREATE TABLE special_requests (
    id       NUMBER NOT NULL,
    request  VARCHAR2(60 CHAR) NOT NULL,
    order_id NUMBER NOT NULL
);

ALTER TABLE special_requests ADD CONSTRAINT special_requests_pk PRIMARY KEY ( id );

CREATE TABLE tables (
    id   NUMBER NOT NULL,
    name VARCHAR2(63 BYTE) NOT NULL
);

ALTER TABLE tables ADD CONSTRAINT tables_pk PRIMARY KEY ( id );

ALTER TABLE dishes
    ADD CONSTRAINT dishes_dish_categories_fk FOREIGN KEY ( dish_category_id )
        REFERENCES dish_categories ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_employee_kinds_fk FOREIGN KEY ( employee_kind_id )
        REFERENCES employee_kinds ( id );

ALTER TABLE ingredients
    ADD CONSTRAINT ingredients_dishes_fk FOREIGN KEY ( dish_id )
        REFERENCES dishes ( id );

ALTER TABLE ingredients
    ADD CONSTRAINT ingredients_products_fk FOREIGN KEY ( product_id )
        REFERENCES products ( id );

ALTER TABLE orders
    ADD CONSTRAINT orders_dishes_fk FOREIGN KEY ( dish_id )
        REFERENCES dishes ( id );

ALTER TABLE orders
    ADD CONSTRAINT orders_employees_fk FOREIGN KEY ( employee_id )
        REFERENCES employees ( id );

ALTER TABLE orders
    ADD CONSTRAINT orders_receipts_fk FOREIGN KEY ( receipt_id )
        REFERENCES receipts ( id );

ALTER TABLE products
    ADD CONSTRAINT products_product_categories_fk FOREIGN KEY ( product_category_id )
        REFERENCES product_categories ( id );

ALTER TABLE receipts
    ADD CONSTRAINT receipts_employees_fk FOREIGN KEY ( employee_id )
        REFERENCES employees ( id );

ALTER TABLE receipts
    ADD CONSTRAINT receipts_tables_fk FOREIGN KEY ( table_id )
        REFERENCES tables ( id );

ALTER TABLE recipes
    ADD CONSTRAINT recipes_dishes_fk FOREIGN KEY ( dish_id )
        REFERENCES dishes ( id );

ALTER TABLE special_requests
    ADD CONSTRAINT special_requests_orders_fk FOREIGN KEY ( order_id )
        REFERENCES orders ( id );

CREATE SEQUENCE dish_categories_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER dish_categories_id_trg BEFORE
    INSERT ON dish_categories
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := dish_categories_id_seq.nextval;
END;
/

CREATE SEQUENCE dishes_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER dishes_id_trg BEFORE
    INSERT ON dishes
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := dishes_id_seq.nextval;
END;
/

CREATE SEQUENCE employee_kinds_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER employee_kinds_id_trg BEFORE
    INSERT ON employee_kinds
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := employee_kinds_id_seq.nextval;
END;
/

CREATE SEQUENCE employees_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER employees_id_trg BEFORE
    INSERT ON employees
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := employees_id_seq.nextval;
END;
/

CREATE SEQUENCE product_categories_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER product_categories_id_trg BEFORE
    INSERT ON product_categories
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := product_categories_id_seq.nextval;
END;
/

CREATE SEQUENCE products_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER products_id_trg BEFORE
    INSERT ON products
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := products_id_seq.nextval;
END;
/

CREATE SEQUENCE receipts_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER receipts_id_trg BEFORE
    INSERT ON receipts
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := receipts_id_seq.nextval;
END;
/

CREATE SEQUENCE tables_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tables_id_trg BEFORE
    INSERT ON tables
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := tables_id_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            12
-- CREATE INDEX                             0
-- ALTER TABLE                             25
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           8
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          8
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
