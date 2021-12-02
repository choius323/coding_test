"""
방 번호
"""
N = input()
count = [N.count(str(i)) for i in range(10)]
count[6] = (count[6] + count.pop(9) + 1) // 2
print(max(count))
