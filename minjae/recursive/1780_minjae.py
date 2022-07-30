import sys
input = sys.stdin.readline

sys.setrecursionlimit(2500)

from collections import defaultdict

count = defaultdict(int)

def count_paper(board):
    # 9개짜리면 각각 구해서 더함
    if len(board) == 3:
        if search_all(board):
            count[board[0][0]] += 1
            return
        else:
            for i in range(3):
                for j in range(3):
                    count[board[i][j]] += 1
            return
    # 아니면 쪼개서 연산
    else:
        #만약 모든 종이가 같은 색이면
        if search_all(board):
            count[board[0][0]] += 1
            return
        else:
        #아니면 9개 쪼개서 찾음
            for sub in seperate_board(board):
                count_paper(sub)
            return

def search_all(search_board):
    compare = search_board[0][0]
    for line in search_board:
        for e in line:
            if e != compare:
                return False
    return True

def seperate_board(input_board):
    sub_len = len(input_board)//3
    result = [[[ 0 for _ in range(sub_len)] for _ in range(sub_len)] for _ in range(9)]
    for i in range(9):
        for y in range(sub_len):
            for x in range(sub_len):
                result[i][y][x] = input_board[(i//3)*sub_len + y][ ((i%3)*sub_len) + x]
    return result

if __name__ == "__main__":
    size = int(input())
    board = []
    for _ in range(size):
        board.append(list(map(int,input().split())))

    count_paper(board)

    print(count[-1])
    print(count[0])
    print(count[1])

