"""

2525번 - 오븐 시계
https://www.acmicpc.net/problem/2525

몫과 나머지를 잘 이용하면 된다.

"""

a, b = map(int, input().split())
b += int(input())
print((a + b // 60) % 24, b % 60)
