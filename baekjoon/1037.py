"""

최솟값과 최댓값을 곱하면 원래 값이 나온다

"""
T = int(input())
num = list(map(int, input().split()))
print(min(num) * max(num))
