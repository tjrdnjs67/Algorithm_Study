import sys

if __name__ == "__main__":
    n = int(input())
    li = list(map(int,input().split()))
    
    
    idx = []
    li2 = []

    res = [-1] * n
    
    for i, val in enumerate(li):
        if len(li2) == 0:
            idx.append(i)
            li2.append(val)
        else:
            if li2[-1] < val:
                while li2 and li2[-1] < val:
                    res[idx.pop()] = val
                    li2.pop()
              
            idx.append(i)
            li2.append(val)

    for val in res:
        print(val, end = ' ')
