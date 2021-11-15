from typing import List, Callable, Dict, Tuple
from random import randint, choice, sample
import lorem

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


PRODUCTS_LEN = 12
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
                  f'({i * 10 + idx}, \'{product[0]}\', {product[1]}, {product[2]}, \'{product[3]}\', {i});\n'
                  for idx, product in enumerate(products)]
    return lines


TEMP = [p for p in PRODUCTS.values()]
INGREDIENTS = []
for t in TEMP:
    INGREDIENTS += t
DISHES = {
    'Soups': [
        ('Tomato', sample(range(1, PRODUCTS_LEN), k=randint(1, 10))),
        ('Chicken', sample(range(1, PRODUCTS_LEN), k=randint(1, 10))),
    ],
    'Main Course': [
        ('Beef', sample(range(1, PRODUCTS_LEN), k=randint(1, 10))),
    ],
    'Drinks': [
        ('A drink', [randint(1, 3)]),
    ]
}


def insert_dish_categories() -> List[str]:
    return ['INSERT INTO dish_categories VALUES '
            f'({i}, \'{name}\', NULL);\n'
            for i, name in enumerate(DISHES.keys(), start=1)]


def insert_dishes() -> List[str]:
    lines = []
    for i, dishes in enumerate(DISHES.values(), start=1):
        lines += ['INSERT INTO dishes VALUES '
                  f'({i * 10 + idx}, \'{dish[0]}\', NULL, {randint(99, 10000)}, {i});\n'
                  for idx, dish in enumerate(dishes, start=1)]
    return lines


def insert_ingredients() -> List[str]:
    lines = []
    for i, dishes in enumerate(DISHES.values(), start=1):
        for idx, dish in enumerate(dishes, start=1):
            lines += ['INSERT INTO ingredients VALUES '
                      f'({i * 100 + idx * 10 + index}, {randint(1, 100)}, {i * 10 + idx}, {ingredient});\n'
                      for index, ingredient in enumerate(dish[1], start=1)]
    return lines


def insert_recipes() -> List[str]:
    lines = []
    for i, dishes in enumerate(DISHES.values(), start=1):
        for idx, dish in enumerate(dishes, start=1):
            lines += ['INSERT INTO recipes VALUES '
                      f'({step}, \'{lorem.sentence()}\', {i * 10 + idx});\n'
                      for step in range(1, randint(1, 10))]
    return lines


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
