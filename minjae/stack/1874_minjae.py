from collections import deque
import sys
input = sys.stdin.readline

#입력 파트
N = int(input())
sample_list = []
for i in range(N):
    sample_list.append(int(input()))
sample_list = deque(sample_list)

#실제 연산
count = 1
result = []
tmp = []
while count <= N:
    tmp.append(count)
    result.append("+")
    count += 1
    while tmp[-1] == sample_list[0]:
        tmp.pop()
        sample_list.popleft()
        result.append("-")
        #둘중 하나가 비면 중지
        if not tmp or not sample_list:
            break

# 만약 스택이 남으면
if(tmp):
    print("NO")
else:
    for r in result:
        print(r)

