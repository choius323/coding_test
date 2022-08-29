"""

14723번 - 이산수학 과제
https://www.acmicpc.net/problem/14723

n보다 크거나 같은 수를 찾을 때까지 분모를 1씩 증가시키며 값을 찾는다.(그림의 오른쪽으로 이동)
값을 찾으면 n과 그 값의 차이만큼 분자에 더하고 분모에서 빼준 값을 출력한다.

"""

a = 1
b = 1
N = int(input())
dx = 2
num = 1

while num < N:
    num += dx
    dx += 1
    b += 1

# while num > N:
#     num -= 1
#     a += 1
#     b -= 1
# print(a, b)

d = num - N
print(a + d, b - d)

"""

"""
