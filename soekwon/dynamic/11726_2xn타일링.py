import sys
#sys.stdin = open("input.txt", "rt")


if __name__ == "__main__":
    N = int(input())
    li = [0] * (N + 1)

    li[1] = 1
    if N == 1:
        print(1)
    elif N == 2:
        print(2)
    else:
        li[2] = 2
        for i in range(3,N+1):
            li[i] = (li[i-1] + li[i-2] ) % 10007

        print(li[N])
