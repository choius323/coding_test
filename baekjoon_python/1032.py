"""
명령 프롬프트
"""
N = int(input())
strList = list()
[strList.append(input()) for _ in range(N)]
answer = strList[0]
for a in range(len(strList[0])):
    for b in range(1, len(strList)):
        if answer[a] != strList[b][a]:
            answer = answer[:a] + "?" + answer[a + 1 :]
            break
print(answer)
