def eval_postfix(expr: str) -> str:
    stack = []
    ops = {
        "+": lambda a, b: a + b,
        "-": lambda a, b: a - b,
        "*": lambda a, b: a * b,
        "/": lambda a, b: a / b,
    }
    for ch in expr:
        if ch in ops:
            b = stack.pop()   # segundo operando (el más reciente en el stack)
            a = stack.pop()   # primer operando
            stack.append(ops[ch](a, b))
        else:
            stack.append(int(ch))
    return str(stack.pop())

print(eval_postfix("32+"))       # "5"
print(eval_postfix("12-44-+"))   # "-1"