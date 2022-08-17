import sys
#sys.stdin = open("input.txt", "rt")

if __name__ == "__main__":
   test_case = int(input())

   for _ in range(test_case):
       n = int(input())
       li = list(map(int,sys.stdin.readline().split()))

       val = 0
       idx = 0
       for i in range(n):
           if li[i] >= val:
               val = li[i]
               idx = i
       s = 0
       cnt = 0
       res = 0
       for i in range(n):
           if i == idx:
               res += (li[i] * cnt) - s
               s = 0
               cnt = 0
               if i < n - 1:
                   val = 0
                   for j in range(i+1,n):
                        if li[j] >= val:
                            val = li[j]
                            idx = j
               else:
                   continue
           else:
               s += li[i]
               cnt += 1
       print(res)
