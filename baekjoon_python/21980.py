"""

비슷한 번호판

이미 확인 한 문자열을 리스트에 넣고 가지치기

"""

import sys
from string import ascii_lowercase as lower

T = int(sys.stdin.readline())

for _ in range(T):
    sys.stdin.readline()
    words = sys.stdin.readline().split()
    tree = list()

    for a in range(len(words) - 1):
        if False not in [a not in t for t in tree]:  # a가 tree에 없으면 a가 포함된 리스트를 tree에 추가
            tree.append([a])
            for b in range(a + 1, len(words)):
                if False not in [b not in t for t in tree]:
                    if len([w for w in words[a] if w in lower]) == len([w for w in words[b] if w in lower]):
                        if sorted(words[a].upper()) == sorted(words[b].upper()):
                            [t.append(b) for t in tree if a in t]

    print(sum([len(pair) * (len(pair) - 1) // 2 for pair in tree]))
