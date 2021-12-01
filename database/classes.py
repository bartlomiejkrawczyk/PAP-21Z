from typing import List, Dict
from random import choice, randint
import lorem  # type: ignore

EMPLOYEE_KINDS: List[str] = ['waiter', 'cook']


class EmployeeKind:
    def __init__(self, id: int, kind: str) -> None:
        self.id = id
        self.kind = kind

    def __str__(self) -> str:
        return f'INSERT INTO employee_kinds VALUES ({self.id}, \'{self.kind}\');\n'

    @staticmethod
    def generate_employee_kinds() -> List['EmployeeKind']:
        kinds: List['EmployeeKind'] = []
        for i, kind in enumerate(EMPLOYEE_KINDS, start=1):  # type: ignore
            kinds.append(EmployeeKind(i, kind))  # type: ignore
        return kinds


EMPLOYEES = 10

FIRST_NAMES = ['Adam', 'Bartlomiej', 'Kamil', 'Karol']
LAST_NAMES = ['Krawczyk', 'Sudol', 'Sulkowski', 'Rogozinski']


class Employee:
    i: int = 1

    def __init__(self, name: str, last_name: str, employee_kind: int) -> None:
        self.id = Employee.i
        Employee.i += 1
        self.name = name
        self.last_name = last_name
        self.employee_kind = employee_kind

    def __str__(self) -> str:
        return f'INSERT INTO employees VALUES ({self.id}, \'{self.name}\', \'{self.last_name}\', {self.employee_kind});\n'

    @staticmethod
    def generate_employees(kinds: List[EmployeeKind]) -> List['Employee']:
        employees: List['Employee'] = []
        i = 0
        for kind in kinds:
            i += 1
            for _ in range(randint(EMPLOYEES // 2, EMPLOYEES)):
                employees.append(
                    Employee(choice(FIRST_NAMES), choice(LAST_NAMES), kind.id))
        return employees


TABLES = ['Near the Window', 'Near the Doors', 'Over the Bar']


class Table:
    def __init__(self, id: int, name: str) -> None:
        self.id = id
        self.name = name

    def __str__(self) -> str:
        return f'INSERT INTO tables VALUES ({self.id}, \'{self.name}\');\n'

    @staticmethod
    def generate_tables() -> List['Table']:
        tables: List['Table'] = []
        for i, name in enumerate(TABLES, start=1):  # type: ignore
            tables.append(Table(i, name))  # type: ignore
        return tables


PRODUCT_CATEGORIES = ['Drinks', 'Meat', 'Vegetables', 'Fruits', 'Dairy']


class ProductCategory:
    def __init__(self, id: int, name: str) -> None:
        self.id = id
        self.name = name

    def __str__(self) -> str:
        return f'INSERT INTO product_categories VALUES ({self.id}, \'{self.name}\');\n'

    @staticmethod
    def generate_product_categories() -> List['ProductCategory']:
        categories: List['ProductCategory'] = []
        for i, category in enumerate(PRODUCT_CATEGORIES, start=1):  # type: ignore
            categories.append(ProductCategory(i, category))  # type: ignore
        return categories


class Product:
    i = 1

    def __init__(self, name: str, quantity: int, min_quantity: int, unit: str, category: int) -> None:
        self.id = Product.i
        Product.i += 1
        self.name = name
        self.quantity = quantity
        self.min_quantity = min_quantity
        self.unit = unit
        self.category = category

    def __str__(self) -> str:
        return f'INSERT INTO products VALUES ({self.id}, \'{self.name}\', {self.quantity}, {self.min_quantity}, \'{self.unit}\', {self.category});\n'

    @staticmethod
    def generate_products() -> List['Product']:
        return PRODUCTS


PRODUCTS: List['Product'] = [
    Product('Coca-Cola 500ml', 0, 100, 'bottle', 1),
    Product('Coca-Cola 1l', 0, 50, 'bottle', 1),
    Product('Sprite 500ml', 0, 50, 'bottle', 1),
    Product('Fanta 500ml', 0, 50, 'bottle', 1),
    Product('Chicken Breasts', 0, 10000, 'g', 2),
    Product('Chicken Wings', 0, 10000, 'g', 2),
    Product('Beef', 0, 10000, 'g', 2),
    Product('Pork Chop', 0, 10000, 'g', 2),
    Product('Onions', 0, 1000, 'g', 3),
    Product('Pepper', 0, 1000, 'g', 3),
    Product('Carrot', 0, 1000, 'g', 3),
    Product('Apple', 0, 100, 'fruit', 4)
]

DISHES: Dict[str, List[str]] = {
    'Soups': [
        'Tomato',
        'Chicken'
    ],
    'Main Course': [
        'Beef',
    ],
    'Drinks': [
        'A drink',
    ]
}


class DishCategory:
    def __init__(self, id: int, name: str, dishes: List[str]) -> None:
        self.id = id
        self.name = name
        self.dishes = [Dish(name, self.id) for name in dishes]

    def __str__(self) -> str:
        result = f'\nINSERT INTO dish_categories VALUES ({self.id}, \'{self.name}\', NULL);\n'
        for dish in self.dishes:
            result += str(dish)
        return result

    @staticmethod
    def generate_categories() -> List['DishCategory']:
        return [DishCategory(i, name, DISHES[name]) for i, name in enumerate(DISHES.keys(), start=1)]


class Dish:
    i: int = 1

    def __init__(self, name: str, category: int) -> None:
        self.id = Dish.i
        Dish.i += 1
        self.name = name
        self.price = randint(1000, 10000)
        self.category = category
        self.recipe = [Recipe(i, self.id) for i in range(1, randint(2, 10))]
        self.ingredients = [Ingredient(self.id)
                            for _ in range(1, randint(2, 10))]

    def __str__(self) -> str:
        result = f'\nINSERT INTO dishes VALUES ({self.id}, \'{self.name}\', NULL, {self.price}, \'{self.category}\');\n\n'
        for recipe in self.recipe:
            result += str(recipe)
        result += '\n'
        for ingredient in self.ingredients:
            result += str(ingredient)
        return result


class Ingredient:
    i: int = 1

    def __init__(self, dish: int) -> None:
        self.id = Ingredient.i
        Ingredient.i += 1
        self.quantity = randint(1, 1000)
        self.dish = dish
        self.product = choice(PRODUCTS).id

    def __str__(self) -> str:
        return f'INSERT INTO ingredients VALUES ({self.id}, {self.quantity}, {self.dish}, {self.product});\n'


class Recipe:
    def __init__(self, step: int, dish: int) -> None:
        self.step = step
        self.recipe: str = lorem.sentence()  # type: ignore
        self.dish = dish

    def __str__(self) -> str:
        return f'INSERT INTO recipes VALUES ({self.step}, \'{self.recipe}\', {self.dish});\n'


class Receipt:
    i: int = 1

    def __init__(self, employee: int, table: int, dishes: List[Dish]) -> None:
        self.id = Receipt.i
        Receipt.i += 1
        self.payment = 0
        self.employee = employee
        self.table = table
        self.orders = [Order(choice(dishes).id, self.id)
                       for _ in range(randint(1, 10))]

    def __str__(self) -> str:
        result = f'INSERT INTO receipts VALUES ({self.id}, {self.payment}, {self.employee}, {self.table});\n\n'
        for order in self.orders:
            result += str(order)
        result += '\n'
        return result

    @staticmethod
    def generate_receipts(employees: List[Employee], tables: List[Table], dishes: List[Dish]) -> List['Receipt']:
        waiters = [
            employee for employee in employees if employee.employee_kind == 1]
        receipts: List[Receipt] = []
        for waiter in waiters:
            receipts.extend(
                [Receipt(waiter.id, table.id, dishes) for table in tables])
        return receipts


class Order:
    i: int = 1

    def __init__(self, dish: int, receipt: int) -> None:
        self.id = Order.i
        Order.i += 1
        self.date = '21/01/01'
        self.dish = dish
        self.receipt = receipt
        self.status = randint(1, 3)

    def __str__(self) -> str:
        return f'INSERT INTO orders VALUES ({self.id}, \'{self.date}\', {self.dish}, {self.receipt}, {self.status}, NULL);\n'
