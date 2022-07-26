import sys
from collections import deque as dq

if __name__ == "__main__":
    R, C = map(int,input().split())
    map = [list(input()) for _ in range(R)]
    cmap = [[0] * C for _ in range(R)]

    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    
    jx = jy = 0
    li = dq([])
    for i in range(R):
        for j in range(C):
            if map[i][j] == 'F':
                li.append((i,j))
            if map[i][j] == 'J':
                jx = i
                jy = j

    while li:
        pos = li.popleft()
        for dir in range(4):
            nx = pos[0] + dx[dir]
            ny = pos[1] + dy[dir]

            if 0 <= nx < R and 0 <= ny < C and map[nx][ny] != '#':
                if cmap[nx][ny] == 0:
                     cmap[nx][ny] = cmap[pos[0]][pos[1]] + 1
                     map[nx][ny] = 'F'
                     li.append((nx,ny))
                else:
                    if cmap[nx][ny] > cmap[pos[0]][pos[1]] + 1:
                        cmap[nx][ny] = cmap[pos[0]][pos[1]] + 1
                        map[nx][ny] = 'F'
                        li.append((nx,ny))
               


    li.append((jx,jy))
    cmap[jx][jy] = 0
    map[jx][jy] = 'J'

    while li:
        pos = li.popleft()
        for dir in range(4):
            nx = pos[0] + dx[dir]
            ny = pos[1] + dy[dir]

            if 0 <= nx < R and 0 <= ny < C and map[nx][ny] != '#':
                if map[nx][ny] == '.':
                    cmap[nx][ny] = cmap[pos[0]][pos[1]] + 1
                    map[nx][ny] = 'J'
                    li.append((nx,ny))
                else:
                    if cmap[nx][ny] > cmap[pos[0]][pos[1]] + 1:
                         cmap[nx][ny] = cmap[pos[0]][pos[1]] + 1
                         map[nx][ny] = 'J'
                         li.append((nx,ny))
                
                
    
    min = 214700000
    resx = -1
    resy = -1
    for i in range(R):
        for j in range(C):
            if 1 <= i < R -1 and 1 <= j < C-1:
                continue

            if map[i][j] == 'J' and min > cmap[i][j]:
                min = cmap[i][j]
                resx = i
                resy = j
    if resx != -1:
        print(cmap[resx][resy] + 1)
    else:
        print("IMPOSSIBLE")
