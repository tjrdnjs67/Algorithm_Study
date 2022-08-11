import sys
#sys.stdin = open("input.txt", "rt")

dx = [-1,0,1,0]
dy = [0,1,0,-1]


if __name__ == "__main__":
    n, m = map(int,input().split())
    r, c, d = map(int,input().split())
    li = [list(map(int,input().split())) for _ in range(n)]
    checked = [[False] * m for _ in range(n)]

    queue = []
    queue.append((r,c))

    cnt = 1   
    while queue:
        cur = queue.pop(0)
        checked[cur[0]][cur[1]] = True
        for i in range(4):
            nx = cur[0] + dx[(d + 3) % 4]
            ny = cur[1] + dy[(d + 3) % 4]
            d = (d + 3) % 4
            if 0 <= nx < n and 0 <= ny < m and  li[nx][ny] == 0 and checked[nx][ny] == False:
                queue.append((nx,ny))
                cnt += 1
                break
        else:
            nx = cur[0] - dx[d]
            ny = cur[1] - dy[d]
            if 0 <= nx < n and 0 <= ny < m and li[nx][ny] == 0:
                queue.append((nx,ny))
            else:
                break
    print(cnt)
