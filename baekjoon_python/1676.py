"""
5의 개수만큼 0의 개수 증가
"""

answer = 0
for a in range(5, int(input()) + 1, 5):
    if a % 125 == 0:
        answer += 3
    elif a % 25 == 0:
        answer += 2
    elif a % 5 == 0:
        answer += 1
print(answer)
