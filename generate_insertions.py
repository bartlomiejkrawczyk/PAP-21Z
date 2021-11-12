from typing import List, Callable, Dict, Tuple
from random import randint, choice


EMPLOYEE_KINDS = ['waiter', 'cook']


def insert_employee_kinds() -> List[str]:

    return ['INSERT INTO employee_kinds VALUES '
            f'({i}, \'{kind}\');\n'
            for i, kind in enumerate(EMPLOYEE_KINDS, start=1)]


EMPLOYEES = 10

FIRST_NAMES = ['Adam', 'Bartlomiej', 'Kamil', 'Karol']
LAST_NAMES = ['Krawczyk', 'Sudol', 'Sulkowski', 'Rogozinski']


def insert_employees() -> List[str]:

    return ['INSERT INTO employees VALUES '
            f'({i}, \'{choice(FIRST_NAMES)}\', \'{choice(LAST_NAMES)}\', {randint(1, len(EMPLOYEE_KINDS))});\n'
            for i in range(1, EMPLOYEES + 1)]


TABLES = ['pod oknem', 'przy drzwiach', 'przy barze']


def insert_tables() -> List[str]:

    return ['INSERT INTO tables VALUES '
            f'({i}, \'{name}\');\n'
            for i, name in enumerate(TABLES, start=1)]


PRODUCTS: Dict[str, List[Tuple[str, int, int, str]]] = {
    'Drinks': [
        ('Coca-Cola 500ml', 0, 100, 'bottle'),
        ('Coca-Cola 1l', 0, 50, 'bottle'),
        ('Sprite 500ml', 0, 50, 'bottle'),
        ('Fanta 500ml', 0, 50, 'bottle')
    ],
    'Meat': [
        ('Chicken Breasts', 0, 10000, 'g'),
        ('Chicken Wings', 0, 10000, 'g'),
        ('Beef', 0, 10000, 'g'),
        ('Pork Chop', 0, 10000, 'g')
    ],
    'Vegetables': [
        ('Onions', 0, 1000, 'g'),
        ('Pepper', 0, 1000, 'g'),
        ('Carrot', 0, 1000, 'g')
    ],
    'Fruits': [
        ('Apple', 0, 100, 'fruit')
    ]
}


def insert_product_categories() -> List[str]:
    return ['INSERT INTO product_categories VALUES '
            f'({i}, \'{name}\');\n'
            for i, name in enumerate(PRODUCTS.keys(), start=1)]


def insert_products() -> List[str]:
    lines = []
    for i, products in enumerate(PRODUCTS.values(), start=1):
        lines += ['INSERT INTO products VALUES '
                  f'({i * 10 + idx}, {product[2]}, \'{product[0]}\', {product[1]}, \'{product[3]}\', {i});\n'
                  for idx, product in enumerate(products)]
    return lines


def insert_dish_categories() -> List[str]:
    return []


def insert_dishes() -> List[str]:
    return []


def insert_ingredients() -> List[str]:
    return []


def insert_recipes() -> List[str]:
    return []


def insert_receipts() -> List[str]:
    return []


def insert_orders() -> List[str]:
    return []


def insert_special_requests() -> List[str]:
    return []


def write_lines(lines: List[str]) -> None:
    lines.append("COMMIT;\n")
    with open('insert.sql', 'w') as handle:
        handle.writelines(lines)


FUNCTIONS: List[Callable[[], List[str]]] = [
    insert_employee_kinds,
    insert_employees,
    insert_tables,
    insert_product_categories,
    insert_products,
    insert_dish_categories,
    insert_dishes,
    insert_ingredients,
    insert_recipes,
    insert_receipts,
    insert_orders,
    insert_special_requests
]


def main():
    lines: List[str] = []
    for func in FUNCTIONS:
        lines += func()
        lines.append('\n')

    write_lines(lines)


if __name__ == '__main__':
    main()
