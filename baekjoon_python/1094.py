"""

1094번

입력한 값을 2진법으로 바꾼 후 1의 개수도 정답

print(bin(int(input())).count('1'))

"""


x = int(input())
stick = [64]
while sum(stick) > x:
    stick = [stick[0] / 2] * 2 + stick[1:]
    if sum(stick[1:]) >= x:
        stick = stick[1:]
print(len(stick))