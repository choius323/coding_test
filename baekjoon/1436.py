"""
영화감독 숌
"""
N = int(input())
i = 665
c = 0
while True:
    if str(i).count("666") > 0:
        c += 1

    if c == N:
        print(i)
        break
    i += 1
