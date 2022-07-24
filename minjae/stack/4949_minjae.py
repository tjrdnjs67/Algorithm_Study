import sys
input = sys.stdin.readline

string=input().replace("\n","")
while(string != '.'):
    stack = []
    for i in string:
        if i =='(' or i =='[':
            stack.append(i)
        elif i==')':
            if '(' not in stack:
                stack.append(i)
                break
            elif stack[-1] !='(':
                break
            else:
                stack.pop()
        elif i==']':
            if '[' not in stack:
                stack.append(i)
                break
            elif stack[-1] != '[':
                break
            else:
                stack.pop()
    print('yes' if len(stack) == 0 else 'no')
    string = input().replace("\n","")
