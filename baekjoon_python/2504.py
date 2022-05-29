"""

2504번 - 괄호의 값
https://www.acmicpc.net/problem/2504

stack에 괄호와 값을 넣으며 개수, 이전 괄호 등을 확인하며 진행한다.
find 함수는 시작하는 괄호를 찾으며 그 전에 stack에 쌓인 값들을 계산하고 반환해준다.

똑같이 stack을 이용하지만 더 좋은 방법은 괄호를 읽을 때마다 더할 값을 변경하면서 진행하는 것이다.
stack에는 시작하는 괄호만 넣으며 직전 괄호가 원하는 괄호이고 개수가 맞는지 확인하면 된다.
이 방식으로 하면 시간 복잡도가 O(N)이고 코드 작성도 더 쉽다.
참고 링크: https://www.acmicpc.net/source/43603601

"""

from collections import deque

stack = deque()


def find(c):
    num = 1
    global isCorr
    while len(stack) > 0 and stack[-1] != c:
        if type(stack[-1]) != int:
            isCorr = False
            return 0
        num *= stack.pop()

    if len(stack) == 0:
        isCorr = False
        return 0
    elif stack.pop() == '(':
        num *= 2
    else:
        num *= 3

    while len(stack) > 0 and type(stack[-1]) is int:
        num += stack.pop()
    return num


isCorr = True
s = input()
for i in range(len(s)):
    if not isCorr:
        break
    if s[i] == '(' or s[i] == '[':
        stack.append(s[i])
    else:
        stack.append(find('(' if s[i] == ')' else '['))

if len(stack) == 1 and isCorr and type(stack[0]) == int:
    print(stack[0])
else:
    print(0)

"""
(())
"""
