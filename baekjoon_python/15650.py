"""

15650번 - N과 M (2)

seq.append(addNumber)를 하면 정상적으로 작동 하지 않음
하나의 객체가 여러번 호출되면서 오류가 생기는 거 같음

"""


import sys


def makeSequence(seq=[], addNumber=0):
    if addNumber != 0:
        seq = seq + [addNumber]
    if len(seq) == M:
        answer.append(seq)
    elif len(seq) < M:
        for i in range(addNumber + 1, N + 1):
            makeSequence(seq, i)


N, M = map(int, sys.stdin.readline().split())
answer = list()
makeSequence()

print("\n".join([" ".join(map(str, lst)) for lst in answer]))
