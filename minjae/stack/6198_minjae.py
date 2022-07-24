import sys
input = sys.stdin.readline

#개념이 어려운 문제
#인풋
N = int(input())
building = []
for _ in range(N):
    building.append(int(input()))


sum = 0
look = []
for i in building:
    # 비어있지 않거나 stack 안에 나보다 낮은 건물이 있으면 뱉음
    while look and (look[-1]<=i):
        look.pop()
    #다 뱉었으면 넣음
    look.append(i)
    #stack의 길이 -1 == 나를 볼 수 있는 건물의 수
    sum += len(look) - 1

print(sum)
