import sys
input = sys.stdin.readline

from collections import defaultdict
from collections import deque


if __name__ == "__main__":
    # case_size = int(input())
    # for _ in range(case_size):
    student_size = int(input())
    graph = defaultdict(int)
    linked = list(map(int,input().split(" ")))
    for i in range(1,student_size+1):
        graph[i] = linked[i-1]

    print(graph)



# 팀 결성된 사람들은 저장해서 다시 탐색하지 않도록 한다.
# 처음 시작한 노드에서 순회하다가 다시 처음 노드로 돌아오면 팀
# 자기가 자기 선택하면 팀
