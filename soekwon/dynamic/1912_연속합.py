import sys
#sys.stdin = open("input.txt", "rt")

if __name__ == "__main__":
    n = int(input())

    li = list(map(int,input().split()))


    res = li[0]
    s = e = 0
    sum = li[0]

    if n == 1:
        print(res)
    else:
        for i in range(1,n):
            sum += li[i]

            if sum < li[i]:
                sum = li[i]

            if sum > res:
                res = sum

            if sum < 0:
                sum = 0
        print(res)
