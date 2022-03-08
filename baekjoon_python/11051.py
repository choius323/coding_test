"""
math.comb -> 이항정리, 조합
"""

import math as m

print(m.comb(*map(int, input().split())) % 10007)
