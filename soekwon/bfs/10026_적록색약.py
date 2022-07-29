import sys

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

if __name__ == "__main__":
   N = int(input())
   board = [list(input()) for _ in range(N)]

   rgb = [[0] * N for _ in range(N)]
   ggb = [[0] * N for _ in range(N)]

   res1 = 0
   res2 = 0
   

   for i in range(N):
       for j in range(N):
           if rgb[i][j] == 0:
               res1 += 1
               rgb[i][j] = 1
               li = []
               li.append((i,j))
               while li:
                   pos = li.pop()

                   for dir in range(4):
                       nx = pos[0] + dx[dir]
                       ny = pos[1] + dy[dir]
                       if 0 <= nx < N and 0 <= ny < N and rgb[nx][ny] == 0 and board[nx][ny] == board[pos[0]][pos[1]]:
                           rgb[nx][ny] = 1
                           li.append((nx,ny))
           if board[i][j] == 'R':
                board[i][j] = 'G'
   
   for i in range(N):
       for j in range(N):
           if ggb[i][j] == 0:
               res2 += 1
               ggb[i][j] = 1
               li = []
               li.append((i,j))
               while li:
                   pos = li.pop()

                   for dir in range(4):
                       nx = pos[0] + dx[dir]
                       ny = pos[1] + dy[dir]
                       if 0 <= nx < N and 0 <= ny < N and ggb[nx][ny] == 0 and board[nx][ny] == board[pos[0]][pos[1]]:
                           ggb[nx][ny] = 1
                           li.append((nx,ny))
   print(res1, res2)
