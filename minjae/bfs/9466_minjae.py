import sys
input = sys.stdin.readline

from collections import defaultdict
from collections import deque

graph = []
team = []

# 79%에서 시간 초과 발생
def loop_bfs(bool_visited,team,input_node):
    que = deque([input_node])
    visited = []
    while que:
        now = que.popleft()
        visited.append(now)
        next = graph[now]
        bool_visited[now] = True
        #1인팀이면 나가기
        if now == next:
            team[now] = True
            return [now]
        #순환에 성공했으면
        if next in set(visited):
            #순환을 이루는 애들만 바꿈
            for v in visited[visited.index(next):]:
                team[v] = True
            return
        if bool_visited[next]:
            return
        que.append(next)

if __name__ == "__main__":
    case_size = int(input())
    for _ in range(case_size):
        student_size = int(input())
        visited = [False]*student_size
        team = [False]*student_size
        graph = list(map(lambda x:int(x)-1, input().split(" ")))

        for i in range(student_size):
            if visited[i]:
                continue
            loop_bfs(visited,team,i)

        print(f"{team.count(False)}")

# 팀 결성된 사람들은 저장해서 다시 탐색하지 않도록 한다.
# 처음 시작한 노드에서 순회하다가 다시 처음 노드로 돌아오면 팀
# 자기가 자기 선택하면 팀

# 2
# 7
# 3 1 3 7 3 4 6
# 8
# 1 2 3 4 5 6 7 8

