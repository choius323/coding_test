"""

평행사변형

기울기가 같으면 -1 출력
3개 점의 거리의 합이 최대 거리의 2배이면 같은 선에 있지만, 소수점을 계산하면서 제대로 결과가 나오지 않음
평행사변형은 총 3개 만들 수 있고 둘레는 각 점 사이의 거리 2개를 더한 값과 같음

"""


import sys


def calcDistance(dot1, dot2) -> float:
    return pow(pow(dot1[0] - dot2[0], 2) + pow(dot1[1] - dot2[1], 2), 1 / 2)


xa, ya, xb, yb, zx, zy = map(int, sys.stdin.readline().split())
dot = [[xa, ya], [xb, yb], [zx, zy]]

dist = [calcDistance(dot[0], dot[1]), calcDistance(dot[1], dot[2]), calcDistance(dot[0], dot[2])]
sumDist = [dist[0] + dist[2], dist[0] + dist[1], dist[1] + dist[2]]
perimeter = [sumDist[0] + sumDist[1], sumDist[0] + sumDist[2], sumDist[1] + sumDist[2]]  # 둘레의 반
if dot[0][1] - dot[1][1] == dot[1][1] - dot[2][1] == 0:
    print(-1.0)
elif dot[0][1] - dot[1][1] == 0 or dot[1][1] - dot[2][1] == 0:
    print(f"%.15f" % ((max(perimeter) - min(perimeter)) * 2))
elif (dot[0][0] - dot[1][0]) / (dot[0][1] - dot[1][1]) == (dot[1][0] - dot[2][0]) / (dot[1][1] - dot[2][1]):
    print(-1.0)
else:
    print(f"%.15f" % ((max(perimeter) - min(perimeter)) * 2))
