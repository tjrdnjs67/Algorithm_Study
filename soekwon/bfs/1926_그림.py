import sys

dx = [-1,0,1,0]
dy = [0,1,0,-1]


if __name__ == "__main__":
    n, m  = map(int,input().split())
    li = [ list(map(int,input().split())) for _ in range(n)]
    
    cnt = 0
    ma = 0

    for i in range(n):
        for j in range(m):
            if li[i][j] == 1:
                ch = []
                ch.append((i,j))

                cnt += 1
                num = 1
                while ch:
                    t = ch.pop()
                    for dir in range(4):
                        nx = t[0] + dx[dir]
                        ny = t[1] + dy[dir]

                        if 0 <= nx < n and 0 <= ny < m and li[nx][ny] == 1:
                            num += 1
                            ch.append((nx,ny))
                            li[nx][ny] = 0
                    li[t[0]][t[1]] = 0
                ma = max(ma,num)
    print(cnt)
    print(ma)
