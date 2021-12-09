"""
pow(a,b,c) -> (a**b)%c
pow(a,b)%c보다 빠름
"""

for _ in range(int(input())):
    a, b = map(int, input().split())
    result = pow(a, b, 10)
    print(result if result != 0 else 10)
