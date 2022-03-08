"""
부분집합의 개수 = 2^n
적어도 한 가지를 포함 하려면 각 원소에 1을 더해서 곱하고 1을 빼면 된다.

hat headgear
sunglasses eyewear
turban headgear

hat sunglasses X
turban X

3 * 2 - 1 = 5
"""

for _ in range(int(input())):
    wear = dict()
    for __ in range(int(input())):
        value, key = input().split()
        if key in wear:
            wear[key] += 1
        else:
            wear[key] = 1

    answer = 1
    for val in wear.values():
        answer *= val + 1
    print(answer - 1)
