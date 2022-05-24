"""

12852번 - 1로 만들기 2
https://www.acmicpc.net/problem/12852

DP를 이용해 1에서 올라가는 방식을 사용했다.
visited[i]에는 i가 되기 전 숫자를 저장해서 n이 되는 경로를 찾을 수 있게 한다.

"""
import collections

n = int(input())
deque = collections.deque()
visited = [0] * (n+1)
deque.append(1)
visited[1] = 0
count = -1
isFind = False

while len(deque) > 0 and not isFind:
    count += 1
    for _ in range(len(deque)):
        pre = deque.popleft()
        if pre == n:
            isFind = True
            break
        for post in [pre * 3, pre * 2, pre + 1]:
            if post <= n and visited[post] == 0:
                deque.append(post)
                visited[post] = pre

print(count)
q = n
while q != 0:
    print(q, end=" ")
    q = visited[q]

"""

"""
