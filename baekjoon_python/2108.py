"""

2108번 -
https://www.acmicpc.net/problem/2108

입력받은 데이터를 저장했다가 정렬한 후 사용했고 최빈값은 따로 리스트를 만들었다.
산술 평균은 파이썬의 특이한 반올림 계산 때문에 직접 구현했고 음수의 반올림 때문에 조금 헷갈렸다.
최빈값은 -4000~4000이 나온 횟수를 저장 할 리스트를 만들고 입력 받으면서 갱신한 뒤 같은 값이 있는지 확인하고 출력했다.
중앙값과 범위는 정렬된 리스트를 사용했다.

"""

import sys

i = sys.stdin.readline

s = 0
inputList = []
modeList = [0] * 8001
mode = 0
n = int(i())
for _ in range(n):
    num = int(i())
    inputList.append(num)
    modeList[num + 4000] += 1
    if modeList[mode] < modeList[num + 4000] or (modeList[mode] == modeList[num + 4000] and num + 4000 < mode):
        mode = num + 4000
    s += num
inputList.sort()
avg = s * 10 / n / 10
print(int(avg) + (0 if abs(avg) % 1 < 0.5 else 1 if avg >= 0 else -1))
print(inputList[n // 2])
for m in range(mode + 1, inputList[-1] + 4001):
    if modeList[mode] == modeList[m]:
        mode = m
        break
print(mode - 4000)
print(inputList[-1] - inputList[0])


"""
5
-1
-2
-3
-1
-2
"""