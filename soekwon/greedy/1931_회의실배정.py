import sys
#sys.stdin = open("input.txt", "rt")

if __name__ == "__main__":
    n = int(input())

    li = [tuple(map(int,input().split())) for _ in range(n)]
    res = [0] *(n)

    li.sort(key = lambda x : (x[1], x[0]))

    lastval = li[0][1]
    cnt = 1

    if n != 1:
        for i in range(1, n):
            res[i] = 1
            if li[i][0] >= lastval:
                lastval = li[i][1]
                cnt += 1


    print(cnt)
