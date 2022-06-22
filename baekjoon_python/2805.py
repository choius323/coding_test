"""

2805번 - 나무 자르기
https://www.acmicpc.net/problem/2805

이분 탐색을 변형해서 활용하는 문제이다.
보통 이분 탐색은 값이 어떤 인덱스에 들어가야 하는지 찾지만 이 문제에서는 어떤 값이 들어가야 하는지 찾아야 한다.

"""

n, m = map(int, input().split())
tree = list(map(int, input().split()))
left = 0
right = max(tree)

while left <= right:
    cut = 0
    mid = (left + right) // 2
    for t in tree:
        if t > mid:
            cut += t - mid
    if cut >= m:
        left = mid + 1
    else:
        right = mid - 1

print(right)

"""

"""
