import sys
#sys.stdin = open("input.txt", "rt")


if __name__ == "__main__":
    N = int(input())

    for _ in range(N):
        n = int(input())
        li = [0] * (n + 1)


        if n == 1:
            print(1)
            continue

        if n == 2:
            print(2)
            continue


        li[1] = 1
        li[2] = 1
        li[3] = 1

        for i in range(1,n+1):
            if i - 1 >= 0:
                li[i] += li[i-1]
            if i - 2 >= 0:
                li[i] += li[i-2]
            if i - 3 >= 0:
                li[i] += li[i-3]

        print(li[n])
