def get_initial_direction(elements: list[int]) -> int:
    i = 1
    while i < len(elements) and elements[i] == elements[i - 1]:
        print(elements[i], elements[i + 1])
        i += 1

    if i == len(elements):
        direction = 1

    # Si el primero es manor, direccion es UP, de lo contrario DOWN.
    direction = 1 if elements[i] > elements[i - 1] else 0
    
    return direction


def changing_direction(elements: list[int]) -> int:
    # your code here
    print(elements)
    
    if len(elements) < 2:
        return 0
    
    i = 0
    tag = elements[0]
    cds = 0

    # Buscar la primera diferencia entre elementos

    direction = get_initial_direction(elements)
        
    tag_direction = direction

    print("initial direction", "UP" if direction == 1 else "DOWN")

    while i < len(elements):
        print("elements[", i, "] =", elements[i])
        if elements[i] > tag:
            print("elements[", i, "]{", elements[i], "} >", tag, "direction = UP")
            direction = 1  # UP
        if elements[i] < tag:
            print("elements[", i, "]{", elements[i], "} <", tag, "direction = DOWN")
            direction = 0  # DOWN
        if tag_direction != direction:
            tag_direction = direction
            cds += 1
        tag = elements[i]
        i += 1
    print("Number of change directions:", cds, " for ", elements)
    return cds


print("Example:")
print(changing_direction([1, 2, 3, 4, 5]))

# These "asserts" are used for self-checking

assert changing_direction([1, 2, 3, 4, 5]) == 0
assert changing_direction([1, 2, 3, 2, 1]) == 1
assert changing_direction([1, 2, 2, 1, 2, 2]) == 2
assert changing_direction([6, 6, 6, 4, 1, 2, 5, 9, 7, 8, 5, 9, 4, 2, 6]) == 7
assert changing_direction([1, 2, 3, 5, 4, 2, 5, 7, 8, 3, 2, 1]) == 3
assert changing_direction([1, 2, 2, 1, 2, 1, 2]) == 4

print("The mission is done! Click 'Check Solution' to earn rewards!")
