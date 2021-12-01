from typing import List, Callable
from classes import EmployeeKind, Employee, Table, ProductCategory, Product, DishCategory, Receipt, Dish

EMPLOYEE_KINDS = EmployeeKind.generate_employee_kinds()


def insert_employee_kinds() -> List[str]:
    return [str(kind) for kind in EMPLOYEE_KINDS]


EMPLOYEES = Employee.generate_employees(EMPLOYEE_KINDS)


def insert_employees() -> List[str]:
    return [str(employee) for employee in EMPLOYEES]


TABLES = Table.generate_tables()


def insert_tables() -> List[str]:
    return [str(table) for table in TABLES]


PRODUCTS = Product.generate_products()


def insert_product_categories() -> List[str]:
    return [str(category) for category in ProductCategory.generate_product_categories()]


def insert_products() -> List[str]:
    return [str(product) for product in PRODUCTS]


CATEGORIES = DishCategory.generate_categories()


def insert_dish_categories() -> List[str]:
    return [str(category) for category in CATEGORIES]


DISHES: List[Dish] = []
for category in CATEGORIES:
    DISHES.extend(category.dishes)


def insert_receipts() -> List[str]:
    return [str(receipt) for receipt in Receipt.generate_receipts(EMPLOYEES, TABLES, DISHES)]


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
    insert_receipts
]


def main():
    lines: List[str] = []
    for func in FUNCTIONS:
        lines += func()
        lines.append('\n')

    write_lines(lines)


if __name__ == '__main__':
    main()
