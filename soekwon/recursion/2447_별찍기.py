import sys

prints = [['*','*','*'],
         ['*',' ','*'],
         ['*','*','*']]

def recursion(n,sr,er,sc,ec):
    if n == 3:
        for i in range(sr,er):
            for j in range(sc,ec):
                board[i][j] = prints[i-sr][j-sc]
        return

    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue

            recursion(n//3, sr + n//3 * i, (sr + n//3 * i) + n//3, sc + n//3 * j, (sc + n//3 * j) + n//3)
    
        

n = int(input())
board = [[' '] * n for _ in range(n)]
    
recursion(n,0,n,0,n)
for i in board:
    for j in i:
        print(j,end='')
    print()
