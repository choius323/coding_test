"""

1074번 - Z

재귀 함수에서 조건은 항상 계산을 잘 하자
r + (r - l) / 2

행과 열도 문제에서 제시해준 방향에 맞게 잘 설정하자

"""


def dfs(l, r, b, t, startNum):  # left, right, top, bottom
    if r - l == 1:
        return int(startNum)
    else:
        add = ((r - l) / 2) ** 2
        if col < (r + l) / 2 and row < (b + t) / 2:  # lt
            return dfs(l, (r + l) / 2, (b + t) / 2, t, startNum + add * 0)
        elif col >= (r + l) / 2 and row < (b + t) / 2:  # rt
            return dfs((r + l) / 2, r, (b + t) / 2, t, startNum + add * 1)
        elif col < (r + l) / 2 and row >= (b + t) / 2:  # lb
            return dfs(l, (r + l) / 2, b, (b + t) / 2, startNum + add * 2)
        elif col >= (r + l) / 2 and row >= (b + t) / 2:  # rb
            return dfs((r + l) / 2, r, b, (b + t) / 2, startNum + add * 3)


N, row, col = map(int, input().split())
print(dfs(0, 2 ** N, 2 ** N, 0, 0))
