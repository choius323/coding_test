"""
걷기

1. 일자 우선
2. 대각선 우선
3. 대각선+일자 평범하게
"""
X, Y, W, S = map(int, input().split())

if 2 * W <= S:
    s = 0
    w = X + Y
elif S < W:
    s = max(X, Y) - (X + Y) % 2
    w = (X + Y) % 2
elif W <= S < 2 * W:
    s = min(X, Y)
    w = max(X, Y) - s
print(S * s + W * w)
