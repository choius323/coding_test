"""

42840번
완전탐색 모의고사 문제

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

enumerate 사용 하는 방법도 있음

"""


def solution(answers):
    tester = [0, 0, 0]
    for i in range(len(answers)):
        tester[0] += 1 if answers[i] == i % 5 + 1 else 0
        tester[1] += 1 if (i % 2 == 0 and answers[i] == 2) or \
                          (i % 2 == 1 and answers[i] == [1, 3, 4, 5][i // 2 % 4]) else 0
        tester[2] += 1 if (answers[i] == [3, 1, 2, 4, 5][i // 2 % 5]) else 0
        print(tester)

    return sorted([i + 1 for i in range(len(tester)) if tester[i] == max(tester)])


print(solution([1, 3, 2, 4, 2]))
