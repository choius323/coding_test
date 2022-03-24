"""

1181번 - 단어 정렬
https://www.acmicpc.net/problem/1181

파이썬의 정렬 기능과 람다 함수를 사용하면 편하다

"""


import sys

word = []
for _ in range(int(sys.stdin.readline())):
    word += [sys.stdin.readline()[:-1]]

print("\n".join(sorted(list(set(word)), key=lambda x: len(x))))
#print("\n".join(sorted(list(set(word)), key=lambda x: (len(x), x)))
