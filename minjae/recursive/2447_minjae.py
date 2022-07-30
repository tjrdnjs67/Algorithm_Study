import sys
input = sys.stdin.readline

output = []

def star(num):
    if num == 1:
        return
    compare = [ i + (num//3) for i in range(num//3)]
    for i in range(len(output)):
        for j in range(len(output)):
            if (i % num) in compare and (j % num) in compare:
                output[i][j] = " "
    star(num//3)

if __name__ == "__main__":
    N = int(input())
    output = [["*" for _ in range(N)] for _ in range(N)]
    star(N)
    for line in output:
        print("".join(line))

