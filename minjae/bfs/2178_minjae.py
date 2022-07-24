from collections import deque
import sys
input = sys.stdin.readline


def bfs(board):
    que = deque()
    que.append([0,0])
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    while que:
        location = que.popleft()
        for i in range(4):
            y = location[0] + dy[i]
            x = location[1] + dx[i]
            if x < 0 or x >= len(board[0]) or y < 0 or y >= len(board):
                continue
            if board[y][x] == 0:
                continue
            if board[y][x] == 1:
                que.append([y,x])
                board[y][x] = board[location[0]][location[1]] + 1

    return board[len(board)-1][len(board[0])-1]


line_count, element_count = map(int, input().split(" "))
board = []
for _ in range(line_count):
    board.append( list(map(int, list(input().replace("\n","")))) )

print( bfs(board) )
