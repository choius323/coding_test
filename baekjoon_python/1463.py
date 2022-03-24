"""

1463번 - 1로 만들기
https://www.acmicpc.net/problem/1463

동적 계획법(Dynamic Programming, DP) 활용

"""

n = int(input())
answer = [10 ** 6] * (n + 1)
answer[0] = 0
answer[1] = 0

i = 1
while i <= n:
    if i % 3 == 0:
        answer[i] = answer[i // 3] + 1
    if i % 2 == 0:
        answer[i] = min(answer[i], answer[i // 2] + 1)
    answer[i] = min(answer[i], answer[i - 1] + 1)
    i += 1

# print(answer)
print(answer[n])
