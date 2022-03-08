"""
스캐너
"""
r, c, zr, zc = map(int, input().split())
for _ in range(r):
    data = input()
    for _ in range(zr):
        for d in data:
            print(d * zc, end="")
        print()
