import re 

def backward_string_by_word(text: str) -> str:
    
    if text == "":
        return ""
    
    words = text.split()
    sps = re.findall(r'\s+', text)
    sps.insert(0, "")
    
    new_text = ""
    
    if len(words)==1:
        return words[0][::-1]
    idx = 1
    for word in words:
        space = sps[idx] if idx < len(words) else ""
        new_text += word[::-1] + space
        idx += 1
        
    print("'", new_text.strip(), "'")
    return new_text.strip()


print("Example:")
print(backward_string_by_word(""))

# These "asserts" are used for self-checking
assert backward_string_by_word("") == ""
assert backward_string_by_word("world") == "dlrow"
assert backward_string_by_word("hello world") == "olleh dlrow"
assert backward_string_by_word("hello  world") == "olleh  dlrow"
assert backward_string_by_word("welcome to a game") == "emoclew ot a emag"

print("The mission is done! Click 'Check Solution' to earn rewards!")
