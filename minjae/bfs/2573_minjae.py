import sys

input = sys.stdin.readline
from collections import deque

board = []
visited = []

def bfs(board, start, visited):
    zero = []
    tmp = 0
    # 상하좌우
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    que = deque([start])
    while que:
        tmp += 1
        visit = que.popleft()
        visited[visit[0]][visit[1]] = True
        for i in range(4):
            y = visit[0] + dy[i]
            x = visit[1] + dx[i]
            if 0 > x or x >= len(board[0]) or 0 > y or y >= len(board):
                continue
            # 연결 찾기
            if board[y][x] > 0 and (not visited[y][x]):
                que.append([y, x])
                visited[y][x] = True
            # 주변에 바다가 있고
            elif board[y][x] == 0:
                #완전히 녹지 않았으면
                if board[visit[0]][visit[1]] > 1:
                    board[visit[0]][visit[1]] -= 1
                #다른 것에 영향이 생길 수 있으니깐 위치만 다른 곳에 저장해둠
                elif board[visit[0]][visit[1]] == 1:
                    zero.append(visit)
    for lo in zero:
        board[lo[0]][lo[1]] = 0
    #print(tmp)
    #showBoard()
    return board

def allClear():
    for line in board:
        for e in line:
            if e != 0:
                return False
    return True

def showBoard():
    print("-----------")
    for line in board:
        print(line)


if __name__ == "__main__":
    row, col = map(int, input().split(" "))
    board = []
    for _ in range(row):
        board.append(list(map(int, input().split(" "))))

    result = -1
    count = 0
    while count < 2:
        result += 1
        visited = [[False for _ in range(col)] for _ in range(row)]
        count = 0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] != 0 and not visited[i][j]:
                    #print(result, [i,j])
                    board = bfs(board, [i, j], visited)
                    count += 1
        if(allClear()):
            result = 0
            break
    print(result)

## timeout
## python3 37%
## pypy3 93%% fail
