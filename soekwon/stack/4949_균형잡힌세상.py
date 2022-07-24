import sys

if __name__ == "__main__":
   
   while True:
       li = []
       tf = True

       s = input()
       if len(s) == 1 and s[0] == '.':
           break

       for i in s:
           if i == '[':
               li.append(i)
           elif i == '(':
                li.append(i)
           elif i == ']':
                if len(li) == 0:
                    tf = False
                    break
                if li[-1] != '[':
                    tf = False
                    break
                li.pop()
           elif i == ')':
                if len(li) == 0:
                    tf = False
                    break
                if li[-1] != '(':
                    tf = False
                    break
                li.pop()
           else:
               continue
       
       if li:
           tf = False
           while li:
               li.pop()
       
       if tf == True:
           print("yes")
       else:
           print("no")
