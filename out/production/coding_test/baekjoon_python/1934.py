"""
*은 가변 인자 전달에 사용
"""

import math

for _ in range(int(input())):
    print(math.lcm(*map(int, input().split())))
