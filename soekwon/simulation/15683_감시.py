import sys
import copy
#sys.stdin = open("input.txt", "rt")


def upd(x, y, dir):
    dir %= 4
    while True:
        x += dx[dir]
        y += dy[dir]
        if x < 0 or x >= n or y < 0 or y >= m  or cpli[x][y] == 6:
            return
        if cpli[x][y] != 0: 
            continue
        cpli[x][y] = 7
if __name__ == "__main__":
   n, m = map(int,input().split())
   li = [list(map(int, input().split())) for _ in range(n)]
   
   dx = [-1,0,1,0]
   dy = [0,1,0,-1]

   camera = []
   mn = 0
   for i in range(n):
       for j in range(m):
           if 1 <= li[i][j] <= 5:
               camera.append((i,j))
           else:
                mn += 1
   
   for i in range(1 << (2 * len(camera))):
       cpli = copy.deepcopy(li)

       
       num = i
       for j in range(len(camera)):
           dir = num % 4
           num //= 4
           
           x = camera[j][0]
           y = camera[j][1]
           if cpli[x][y] == 1:
                upd(x,y,dir)
           elif cpli[x][y] == 2:
               upd(x,y,dir)
               upd(x,y,dir+2)
           elif cpli[x][y] == 3:
               upd(x,y,dir)
               upd(x,y,dir+1)
           elif cpli[x][y] == 4:
               upd(x,y,dir)
               upd(x,y,dir+1)
               upd(x,y,dir+2)
           else:
               upd(x,y,dir)
               upd(x,y,dir+1)
               upd(x,y,dir+2)
               upd(x,y,dir+3)

       val = 0
       for a in range(n):
            for b in range(m):
                if cpli[a][b] == 0:
                    val += 1
       mn = min(mn, val)
   print(mn)



       
