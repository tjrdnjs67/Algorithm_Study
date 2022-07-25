# 미로탐색
from collections import deque

def bfs(x, y):
    #상 우 하 좌
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    
    queue = deque()
    queue.append((x, y))
    
    while(queue):
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 배열의 범위를 넘어가는 경우
            if nx < 0 or nx >= n or ny < 0 or ny >= m :
                continue
            # 이동할 수 없는 칸인 경우
            elif graph[nx][ny] == 0:
                continue
            # 이동할 수 있는 칸인 경우
            if graph[nx][ny] == 1:
                # graph[nx][ny] = 0
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))
    return graph[n-1][m-1]

n, m = map(int, input().split())
graph =[]

for i in range(n):
    graph.append(list(map(int, input())))

print(bfs(0,0))
    