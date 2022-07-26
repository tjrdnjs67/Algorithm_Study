import sys
input = sys.stdin.readline

from collections import deque

board = []

def bfs(board,location,fire_location):
    #상하좌우
    dy = [-1,1,0,0]
    dx = [0,0,-1,1]

    que = deque()
    que.append(location)
    fire_que = deque()
    for f in fire_locations:
        fire_que.append(f)
    visit = []
    fired = []
    count = 0
    while que:
        showBoard(board)
        visit = que.popleft()
        if fire_que:
            fired = fire_que.popleft()
        else:
            fired = [-1,-1]
        count += 1
        for i in range(4):
            y = visit[0] + dy[i]
            x = visit[1] + dx[i]
            fireY = fired[0] + dy[i]
            fireX = fired[1] + dx[i]
            if( 0 > x or x >= len(board[0]) or 0 > y or y >= len(board) ):
                return count
            if( 0 > fireX or fireX >= len(board[0]) or 0 > fireY or fireY >= len(board)):
                continue
            #불이랑 친구랑 한번에 연산해야됨
            if board[y][x] == ".":
                board[y][x] = "J"
                if board[fireY][fireX] == "." or board[fireY][fireX] == "J":
                    que.append([y,x])
                    if board[fireY][fireX] == "J":
                        board[fireY][fireX] = "F"
                        que.remove([fireY,fireX])
                    board[fireY][fireX] = "F"
                    fire_que.append([fireY,fireX])
            ##위에서 여기까지 수정해야됨
    return -1

def showBoard(board):
    print("--------------")
    for line in board:
        print(line)

if __name__ == "__main__":
    N, M = map(int,input().split(" "))

    for _ in range(N):
        board.append(list(input().strip()))

    start_location = []
    fire_locations = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == "J":
                start_location = [i,j]
            if board[i][j] == "F":
                fire_locations.append([i,j])

    result = bfs(board,start_location,fire_locations)
    if result == -1:
        print("IMPOSSIBLE")
    else:
        print(result)
