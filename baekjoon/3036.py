"""
gcd는 최대공약수
"""

from math import gcd

N = int(input())
rings = list(map(int, input().split()))

for ring in rings[1:]:
    g = gcd(rings[0], ring)
    print("%d/%d" % (rings[0] / g, ring / g))
