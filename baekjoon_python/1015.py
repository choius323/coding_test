"""

1015번 - 수열 정렬
https://www.acmicpc.net/problem/1015

lst에는 A의 각 숫자가 몇 번째 숫자인지 저장했다.
같은 숫자가 2번 있으면 나중에 있는 숫자는 1이 늘어나야 하기 때문에 출력할 때마다 lst[a]의 값을 1씩 늘린다.
또, lst에 저장할 때 A를 역순으로 저장해야 작은 숫자부터 출력할 수 있다.

"""

n = int(input())
A = list(map(int, input().split()))
lst = [0] * 1001
count = n - 1

for a in sorted(A, reverse=True):
    lst[a] = count
    count -= 1

for a in A:
    print(lst[a], end=" ")
    lst[a] += 1

"""

"""
