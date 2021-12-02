"""
걷기
"""
X, Y, W, S = map(int, input().split())
# minT = 10000000000000

# for s in range(max(X, Y) + 1):
#     w = X + Y - 2 * s
#     minT = min(minT, s * S + w * W)


if 2 * W > S:
    s = max(X, Y)
    w = 0
    if X % 2 ^ Y % 2:
        s -= 1
        w = 1
    print(S * s + W * w)
elif 2 * W <= S:
    w = X + Y
    print(W * w)


# print(minT)
