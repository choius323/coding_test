n, user1, user2 = map(int, input().split())
count = 0
while user1 != user2:
    user1 = int((user1 + 1) / 2)
    user2 = int((user2 + 1) / 2)
    count += 1
print(count)
