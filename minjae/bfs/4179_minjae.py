import sys
input = sys.stdin.readline

from collections import deque

def bfs(board,location,fire_location):
    dy = [-1,1,0,0]
    dx = [0,0,-1,1]

    que = deque()
    que.append(location)
    fire_que = deque([fire_location])
    count = 0
    while que:
        visit = que.popleft()
        fired = fire_que.popleft()

        for i in range(4):
            y = visit[0] + dy[i]
            x = visit[0] + dx[i]
            fireX = fired[0] + dy[i]
            fireY = fired[1] + dx[i]
            if( (0 <= x < len(board[0])) and (0 <= y < len(board)) ):
                if board[y][x] == ".":
                    print([y,x])
                    count += 1
                    que.append([y,x])
                    board[visit[0]][visit[1]] == "."
                    board[y][x] == "J"
            else:
                count += 1
                return count
            if(0 <= fireX < len(board[0]) and 0<= fireY < len(board)):
                if board[fireY][fireX] == ".":
                    fire_que.append([fireY,fireY])
                    board[fired[0]][fired[1]] = "F"


    return -1

def showBoard(board):
    for line in board:
        print(line)

if __name__ == "__main__":
    N, M = map(int,input().split(" "))
    board = []

    for _ in range(N):
        board.append(list(input().strip()))

    for i in range(N):
        for j in range(M):
            if board[i][j] == "J":
                start_location = [i,j]
            if board[i][j] == "F":
                fire_location = [i,j]

    result = bfs(board,start_location,fire_location)
    if result == -1:
        print("IMPOSSIBLE")
    else:
        print(result)
