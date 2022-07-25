import sys
from collections import deque as dq

dx = [-1,0,1,0]
dy = [0,1,0,-1]

if __name__ == "__main__":
   n , m = map(int,input().split())
   board = [list(map(int, input())) for _ in range(n)]
   ch = [[0] * m for _ in range(n)]
   
   li = []
   li = dq(li)
   li.append((0,0))
   ch[0][0] = 1

   while li:
       item  = li.popleft()

       for dir in range(4):
           nx = item[0] + dx[dir]
           ny = item[1] + dy[dir]

           if 0 <= nx < n and 0 <= ny < m and ch[nx][ny] == 0 and board[nx][ny] == 1:
               ch[nx][ny] = ch[item[0]][item[1]] + 1
               li.append((nx,ny))
   print(ch[n-1][m-1])
