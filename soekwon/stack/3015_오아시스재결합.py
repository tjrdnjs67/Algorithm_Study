import sys

if __name__ == "__main__":
   n = int(input())
   li = list()
   res = 0
   for i in range(n):
       val = int(input())
       if li:
           cnt = 0

           while li and li[-1][0] < val:
               res += li.pop()[1]

           if li:              
               if li[-1][0] == val:
                   cnt = li.pop()[1]
                   res += cnt
                   if li:
                       res += 1

               else:
                   res += 1
               
           li.append((val,cnt+1))          
       else:
           li.append((val,1))
   print(res)
