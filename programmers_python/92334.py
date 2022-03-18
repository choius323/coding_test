"""

92334
2022 KAKAO BLIND RECRUITMENT - 신고 결과 받기

dict가 list보다 확실히 빠르다

"""


def solution(id_list, report, k):
    report = [string.split() for string in report]
    reported = {i: [] for i in id_list}
    for a, b in report:
        if a not in reported[b]:
            reported[b].append(a)
    # print(reported)

    for dic in reported.keys():
        if len(reported.get(dic)) < k:
            reported[dic] = []

    answer = [0] * len(id_list)
    for v in reported.values():
        for i in v:
            answer[id_list.index(i)] += 1
    return answer


print(solution(["muzi", "frodo", "apeach", "neo"],
               ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "apeach muzi"], 2))
