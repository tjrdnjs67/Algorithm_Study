import sys
input = sys.stdin.readline

output = []

def star(num,end):
    if num == end*3:
        return
    compare = [ i + (num//3) for i in range(num//3)]
    for i in range(len(output)):
        for j in range(len(output)):
            if (i % num) in compare and (j % num) in compare:
                output[i][j] = " "
    star(num*3,end)

if __name__ == "__main__":
    N = int(input())
    output = [["*"]*N]*N
    star(3,N)
    for line in output:
        sys.stdout.write("".join(line))
        sys.stdout.write("\n")
