"""

1260번 - DFS와 BFS
https://www.acmicpc.net/problem/1260

반례 정리 - https://www.acmicpc.net/board/view/24356
아무리 해봐도 어디서 잘못됐는지 모르겠다..

"""

import sys
from collections import deque


def dfs(checkedDFS: list):
    global stack
    if len(checkedDFS) == num:
        stack.pop()
        return checkedDFS
    for value in sorted(graph[stack[-1]]):
        if value not in checkedDFS:
            stack += [value]
            checkedDFS = dfs(checkedDFS + [value])
    stack.pop()
    return checkedDFS


def bfs():
    checkedBFS = [v]
    queue = deque()
    queue.append(v)
    while len(checkedBFS) < num:
        if len(queue) == 0:
            break
        elif queue[0] not in graph.keys():
            queue.popleft()
        else:
            lst = [node for node in sorted(graph[queue.popleft()]) if node not in checkedBFS]
            # print(checkedBFS, lst)
            checkedBFS += lst
            for temp in lst:
                queue.append(temp)
        # print(queue)

    return checkedBFS


n, m, v = map(int, sys.stdin.readline().split())
graph = {}
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())

    if a in graph.keys():
        graph[a] += [b]
    else:
        graph[a] = [b]

    if b in graph.keys():
        graph[b] += [a]
    else:
        graph[b] = [a]
num = len(graph.keys())
# print(graph)

stack = [v]
print(*dfs([v])) if v in graph.keys() else print(v)

print(*bfs()) if v in graph.keys() else print(v)
