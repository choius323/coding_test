"""

1764번 - 듣보잡
https://www.acmicpc.net/problem/1764

listen과 seen을 미리 정렬 후 앞에서 뒤로 비교한다.
dict에 in을 사용하면 시간복잡도가 O(1)이므로 listen과 seen을 dict로 만들어서 사용해도 된다.

"""

from sys import stdin

n, m = map(int, stdin.readline().split())

listen = []
for a in range(n):
    name = stdin.readline().split("\n")[0]
    listen.append(name)
listen.sort()
# print(listen)

seen = []
for a in range(n):
    name = stdin.readline().split("\n")[0]
    seen.append(name)
seen.sort()
# print(seen)

index = 0
answer = []
for s in seen:
    # print("s : %s " %s)
    while index < n:
        # print("index : %d" % index)
        if s == listen[index]:
            answer.append(s)
            index += 1
            break
        elif s < listen[index]:
            # print("listen[index] : %s" % listen[index])
            break
        else:
            index += 1
print(str(len(answer)) + "\n" + "\n".join(answer))
