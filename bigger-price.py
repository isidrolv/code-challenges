# Tienes una lista con todos los productos disponibles en una tienda. Los datos están representados
#  como una lista de diccionarios.
#
# Tu misión es encontrar los productos más caros de la lista. El número de productos que buscamos 
# se indicará como primer argumento y la lista completa como segundo argumento.
#
# Entrada: un entero y una lista de diccionarios. Cada diccionario tiene las dos claves "nombre" 
#          y "precio".
# Salida: El mismo formato que el segundo argumento de entrada.
# 
# Ejemplo:
# 
# assert bigger_price(
#     2,
#     [
#         {"name": "bread", "price": 100},
#         {"name": "wine", "price": 138},
#         {"name": "meat", "price": 15},
#         {"name": "water", "price": 1},
#     ],
# 
# ) == [{"name": "wine", "price": 138}, {"name": "bread", "price": 100}]
# 
# assert bigger_price(
#     1, [{"name": "pen", "price": 5}, {"name": "whiteboard", "price": 170}]
# ) == [{"name": "whiteboard", "price": 170}]
# 
# ¿Cómo mejorar esta misión? https://github.com/CheckiO-Missions/checkio-mission-bigger-price


""" def bigger_price(limit: int, data: list[dict]) -> list[dict]:
    " ""
    TOP most expensive goods
    " ""
    # your code here
    return sorted(data, key=lambda x: x["price"], reverse=True)[:limit]
 """


""" Esta función encuentra los `limit` productos más caros de una lista `data`:

```python
bigger_price = lambda limit, data: sorted(data, key=lambda item: -item["price"])[:limit]
```

- `lambda limit, data: ...` — define una función anónima con dos parámetros: 
    `limit` (cuántos productos quieres) y `data` (la lista de diccionarios).
- `sorted(data, key=lambda item: -item["price"])` — ordena la lista `data` 
    usando como clave el precio de cada producto, pero negado (`-item["price"]`). 
    Como `sorted` ordena de menor a mayor, negar el precio invierte el orden efectivo, 
    dejando los precios más altos primero (equivalente a usar `reverse=True`, pero 
    permite hacerlo en una sola expresión lambda sin usar el argumento `reverse`).
- `[:limit]` — toma solo los primeros `limit` elementos de esa lista ya ordenada, 
es decir, los `limit` productos más caros.

En resumen, es una versión de una línea (con `lambda`) de:
```python
def bigger_price(limit, data):
    return sorted(data, key=lambda item: item["price"], reverse=True)[:limit]
```
 """
# Lambda syntax for finding the most expensive products
bigger_price = lambda limit, data: sorted(data, key=lambda item: item["price"], reverse=True)[:limit]

print("Example:")
print(
    bigger_price(
        2,
        [
            {"name": "bread", "price": 100},
            {"name": "wine", "price": 138},
            {"name": "meat", "price": 15},
            {"name": "water", "price": 1},
            {"name": "cheese", "price": 50},
            {"name": "butter", "price": 80},
            {"name": "eggs", "price": 30},
            {"name": "milk", "price": 60},
            {"name": "chocolate", "price": 120},
            {"name": "coffee", "price": 190},
        ],
    )
)

assert bigger_price(
    2,
    [
        {"name": "bread", "price": 100},
        {"name": "wine", "price": 138},
        {"name": "meat", "price": 15},
        {"name": "water", "price": 1},
    ],
) == [{"name": "wine", "price": 138}, {"name": "bread", "price": 100}]
assert bigger_price(
    1, [{"name": "pen", "price": 5}, {"name": "whiteboard", "price": 170}]
) == [{"name": "whiteboard", "price": 170}]

print("The mission is done! Click 'Check Solution' to earn rewards!")
