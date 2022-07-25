# 균형잡힌 세상
while(True):
    str = input()
    if str == '.':
        break
    stack = []
    check = True
    for s in str:
        if s == '(':
            stack.append(s)
        elif s == '[':
            stack.append(s)
        elif s == ')':
            if not stack or stack.pop()!= '(':
                check = False
                break
        elif s == ']':
            if not stack or stack.pop() != '[':
                check = False
                break

    if check and not stack:
        print("yes")
    else:
        print("no")