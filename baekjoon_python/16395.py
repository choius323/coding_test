"""

16395번 - 파스칼의 삼각형

이항계수를 활용

math에는 comb(combination)이 있음
여기서는 사용 하지 않았음

"""

from math import factorial as f

n, k = map(int, input().split())
print(f(n - 1) // (f(n - k) * f(k - 1)))
