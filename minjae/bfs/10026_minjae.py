import sys
from collections import deque

def bfs(start_location, color):
    global size
    que = deque([start_location])
    dy = [-1,1,0,0]
    dx = [0,0,-1,1]

    while que:
        now = que.popleft()
        board[now[0]][now[1]] = "."
        for i in range(4):
            y = now[0] + dy[i]
            x = now[1] + dx[i]
            if 0 <= y < size and 0 <= x < size:
                if board[y][x] == color:
                    que.append([y,x])
                    board[y][x] = "."

def green_to_red(x):
    if x == "G":
        return "R"
    else:
        return x

def showBoard(input_board):
    print("------------------")
    for line in input_board:
        print(line)

if __name__ == "__main__":
    size = int(input())
    board = []
    for _ in range(size):
        board.append(list(input().strip()))

    blind_board = []
    for line in board:
        blind_board.append(list(map(green_to_red,line)))

    #showBoard(blind_board)

    count_nomal = 0
    for i in range(size):
        for j in range(size):
            if board[i][j] != ".":
                bfs([i,j],board[i][j])
                count_nomal += 1
                #showBoard(board)

    count_color_blind = 0
    board = blind_board.copy()
    for i in range(size):
        for j in range(size):
            if board[i][j] != ".":
                bfs([i,j],board[i][j])
                count_color_blind += 1
                #showBoard(blind_board)

    print(count_nomal,count_color_blind)
    #print(count_color_blind)
