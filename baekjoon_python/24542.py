"""

튜터-튜티 관계의 수

미해결 문제

"""


import sys


def send(memberList: list, sendCount: int, relation: list) -> int:
    if len(relation) <= 0:
        return sendCount
    else:
        if minSend > sendCount:
            while relation[0][0] in memberList or relation[0][1] in memberList:
                memberList = [n for n in memberList if n not in relation[0]]
                relation = relation[1:]
                if len(relation) <= 0:
                    break
            return send(memberList, sendCount + 1, relation)
        else:
            return sendCount


relationList = list()
minSend = 1000000006
count = 1
temp = sys.stdin.readline()
N = int(temp.split()[0])
M = int(temp.split()[1])

for i in range(M):
    temp = sys.stdin.readline()
    relationList.append(list(map(int, temp.split())))

for i in range(1, N + 1):
    member = [n for n in range(1, N + 1) if n not in [i]]
    temp = int(send(member, 1, relationList.copy()))
    if minSend == temp:
        count += 1
    elif minSend > temp:
        count = 1
        minSend = temp

print(count)
