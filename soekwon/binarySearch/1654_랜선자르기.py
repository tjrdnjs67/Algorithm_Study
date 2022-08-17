import sys
#sys.stdin = open("input.txt", "rt")

if __name__ == "__main__":
    n , k = map(int, input().split())
    li = [int(input()) for _ in range(n)]

    li.sort()

    s = 1
    e = li[n-1]
    res = 0

    while s<=e:
        mid = (s+e)//2
        cnt = 0
        for i in li:
            cnt += i // mid

        if cnt >= k:
            s = mid + 1
        else:
            e = mid - 1
            
    print(e)
