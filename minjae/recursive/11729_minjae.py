import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def hanoi(size,now,end,rest):
    if size == 1:
        print(now,end)
    else:
        hanoi(size-1,now,rest,end)
        print(now,end)
        hanoi(size-1,rest,end,now)

if __name__ == "__main__":
    count = int(input())
    result = 1
    for i in range(1,count):
        result = result*2 + 1
    print(result)
    hanoi(count,1,3,2)
