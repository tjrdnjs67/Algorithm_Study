from collections import deque

def bfs():
    # fire
    while f_queue:
        x, y = f_queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >=R or ny < 0 or ny>=C :
                continue
            if graph[nx][ny] == "#" or f_visited[nx][ny] != 0 :
                continue
            
            f_visited[nx][ny] = f_visited[x][y] + 1
            f_queue.append((nx,ny))
    
    # jihoon
    while j_queue:
        x, y = j_queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >=R or ny < 0 or ny>=C :
                return j_visited[x][y] + 1
            
            if graph[nx][ny] == "#" or j_visited[nx][ny] != 0 or (f_visited[nx][ny] != 0 and f_visited[nx][ny] <= j_visited[x][y]+1):
                continue
            
            j_visited[nx][ny] = j_visited[x][y] + 1
            j_queue.append((nx,ny))

    return -1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
R, C = map(int, input().split())
graph = []
for i in range(R):
    graph.append(list(input().strip()))
    
f_visited = [[0] * C for _ in range(R)]
j_visited = [[0] * C for _ in range(R)]

f_queue = deque()
j_queue = deque()

for i in range(R):
    for j in range(C):
        if graph[i][j] == "J":
            j_queue.append((i,j))
        elif graph[i][j] == "F":
            f_queue.append((i,j))
res = bfs()
if res == -1:
    print("IMPOSSIBLE")
else:
    print(res)

    