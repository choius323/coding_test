"""

1543번 - 문서 검색
https://www.acmicpc.net/problem/1543

파이썬의 count는 중복 체크 없이 개수를 세준다.
직접 구현하면 doc[i:i+n]이 find와 같은지 확인하면 된다.

"""

answer = 0
doc = input()
find = input()
n = len(find)
i = 0
while i < len(doc):
    if doc[i] == find[0] and i + n <= len(doc) and doc[i:i + n] == find:
        answer += 1
        i += n
    else:
        i += 1
print(answer)

# print(doc.count(find))

"""

"""
