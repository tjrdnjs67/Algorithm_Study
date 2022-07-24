import sys
input = sys.stdin.readline

from collections import deque

def find_four(board,start_location):
    #상하좌우
    dy = [-1,1,0,0]
    dx = [0,0,-1,1]
    result = deque()
    for i in range(4):
        y = start_location[0]+dy[i]
        x = start_location[1]+dx[i]
        if(0 <= y < len(board) and 0 <= x < len(board[0])):
            if board[y][x] == 1:
                result.append([y,x])
    return result

## visit 처리를 2번해서 시간초과 걸렸었다.
def bfs(board,start_location):
    que = deque()
    que.append(start_location)
    count = 0
    while que:
        visit = que.popleft()
        for n in find_four(board,visit):
            if board[n[0]][n[1]] == 1:
                que.append(n)
                count += 1
                board[n[0]][n[1]] = 0
    return count

sero, garo = map(int, input().split(" "))

board = []
for _ in range(sero):
    board.append(list(map(int,input().split(" "))))

result = deque()
for i in range(len(board)):
    for j in range(len(board[0])):
        if board[i][j] == 1:
            input_int = bfs(board,[i,j])
            if input_int == 0:
                input_int = 1
            result.append(input_int)
if result:
    print(len(result))
    print(max(result))
else:
    print(0)
    print(0)

