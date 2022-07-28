import sys
sys.stdin = open("input.txt","rt")

def DFS(v):
    global result
    visited[v] = True
    cycle.append(v)
    number = li[v]

    if visited[number]:
        if number in cycle:
            result += cycle[cycle.index(number):]
        return
    else:
        DFS(number)


if __name__ == "__main__":
    T = int(input())

    for test_case in range(1,T+1):
        n = int(input())
        li = [0] + list(map(int,input().split()))
        visited = [True] + [False] * n
        result = []

        for i in range(1,n+1):
            if not visited[i]:
                cycle = []
                DFS(i)
        print(n - len(result))
