"""

게임

n을 바꾸며 최대한 근접한 값을 탐색
직접 계산하는 것도 가능

"""

import sys

X, Y = map(int, sys.stdin.readline().split())

if 100 * Y // X >= 99:  # 승률이 99%거나 100%이면 바뀌지 않음
    print(-1)
else:
    Z = 100 * Y // X
    n = X // 100  # 게임 수
    delta = n // 2  # n이 변하는 크기
    isDeltaPlus = True  # 이전 delta의 부호
    minN = X + 1  # 같은 n이 또 나오면 결과 출력
    while True:
        if Z + 1 <= 100 * (Y + n) // (X + n):
            if minN == n:
                print(n)
                break
            else:
                isDeltaPlus = True
                if Z + 1 <= 100 * (Y + n) // (X + n):
                    minN = min(minN, n)
                # if isDeltaPlus is False:
                delta = int(delta // 1.5) if delta > 2 else 1
                n = n - delta
        else:
            isDeltaPlus = False
            # if isDeltaPlus is True:
            delta = delta - 1 if delta > 1 else delta + 1
            n = n + delta
