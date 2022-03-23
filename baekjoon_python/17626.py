"""

17626번 - Four Squares

단순한 방법으로 2개, 3개의 제곱수로 만들 수 있는지 확인하는 방법이다.
3개까지 확인했을 때는 최대 4개이므로 더 이상 연산 할 필요가 없다.
시간초과가 발생할 것 같았지만 생각보다 속도가 빨라서 충분했다.

"""


n = int(input())
answer = 0
if int(n ** 0.5) == n ** 0.5:
    answer = 1
else:
    a = int(n ** 0.5)
    b = a
    while a > 0 and answer == 0:
        b = a
        while b > 0:
            if int(a ** 2 + b ** 2) == n:
                # print(a, b)
                answer = 2
                break
            b -= 1
        a -= 1

    a = int(n ** 0.5)
    c = b = a
    while a > 0 and answer == 0:
        b = a
        while b > 0 and answer == 0:
            c = b
            while c > 0:
                if int(a ** 2 + b ** 2 + c ** 2) == n:
                    # print(a, b, c)
                    answer = 3
                    break
                c -= 1
            b -= 1
        a -= 1
if answer == 0:
    answer = 4
print(answer)
