def dfs(x):
    global res                              # 결과 리스트를 담을 배열
    visited[x] = True                       # 방문했다고 기록하고
    cycle.append(x)                         # 탐색했다고 저장, 사이클이 만들어지는지 확인하기 위함
    num = arr[x]                            # 다음 방문할 노드
    
    if visited[num]:                        # 다음 방문할 노드의 다음이 이미 방문을 했다면 
        if num in cycle:                    # 탐색한 것이면 사이클이 생긴 것
            res += cycle[cycle.index(num):] # 결과 배열에 추가하고
        return
    else:
        dfs(num)                            # 다음 방문한 노드가 방문되지 않았다면 탐색
        
T = int(input())                                # 총 test의 수   
for _ in range(T):
    n = int(input())                            # 학생수 입력
    arr = [0] +list(map(int, input().split()))  # 배열 생성
    visited = [False] * (n+1)                   # 방문하면 True를 저장할 배열
    res = []                                    # 팀을 구성하게 되면 추가
    for i in range(1, n+1):
        if not visited[i]:                      # 방문하지 않았다면
            cycle = []                          # 방문한 node를 담을 배열을 만들고
            dfs(i)                              # 탐색 시작
    print(n - len(res))
    