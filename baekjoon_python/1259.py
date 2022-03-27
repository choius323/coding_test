"""

1259번 - 팰린드롬수
https://www.acmicpc.net/problem/1259

10과 같은 수는 010<->010과 같이 할 수 있어도 이번에는 예외로 한다.
단, 00과 같은 경우는 있는 것 같다.

"""

n = input()
while n[0] != "0":
    print("yes" if int(n) == int(n[::-1]) else "no")
    n = input()