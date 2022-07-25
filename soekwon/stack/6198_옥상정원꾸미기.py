import sys

if __name__ == "__main__":
    n = int(input())
    
    li = []
    res = 0
    for _ in range(n):
        val = int(input())

        if len(li) == 0:
            li.append(val)
        else:
            while li and val >= li[-1]:
                li.pop()

            if len(li) == 0:
                li.append(val)
            else:
                res += len(li)
                li.append(val)

    print(res)
