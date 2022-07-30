import sys

def recursion(n, f, e):
    if n == 1:
        li.append((f,e))
        return


    recursion(n-1, f, 6-f-e)
    li.append((f,e))
    recursion(n-1, 6-f-e, e)

if __name__ == "__main__":
    n = int(input())
    li = []
    recursion(n,1,3)
    print(len(li))
    for i in li:
        print(i[0], i[1])
