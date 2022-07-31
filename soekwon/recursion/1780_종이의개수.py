import sys

def recursion(n, sr, er, sc, ec):
    if n == 1:
        if board[er - 1][ec - 1] == -1:
            res[2] += 1
        else:
            res[board[er - 1][ec - 1]] += 1
        return

    tf = True
    val = board[er-1][ec-1]
    for i in range(sr,er):
        for j in range(sc,ec):
            if board[i][j] != val:
                tf = False
                break
        if tf == False:
            break
    else:
        if board[er - 1][ec - 1] == -1:
            res[2] += 1
        else:
            res[board[er - 1][ec - 1]] += 1
        return

    for i in range(3):
        for j in range(3):
            recursion(n//3, sr + (n//3 * i), sr + (n//3 * i) + n//3, sc + (n//3 * j), sc + (n//3 * j) + n//3)
    

if __name__ == "__main__":
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(n)]
    res = [0,0,0]
    recursion(n,0,n,0,n)

    print(res[2])
    print(res[0])
    print(res[1])
