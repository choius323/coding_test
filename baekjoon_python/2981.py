"""
못 풀었음
규칙 못 찾음
"""

numbers = list()
answer = list()
for _ in range(int(input())):
    numbers.append(int(input()))

numbers.sort()

for i in range(2, numbers[0] + 1):
    div = numbers[0] % i
    for number in numbers[1:]:
        if div != number % i:
            div = -1
            break
    if div >= 0:
        answer.append(i)

for a in answer:
    print(a, end=" ")
