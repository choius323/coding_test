""""

1655번 - 가운데를 말해요

이분 탐색을 사용하며 정렬해 봤지만 시간 초과로 실패

우선순위 큐, heaq(최대힙)을 사용해서 성공

leftHeap에는 -를 붙여서 최대힙을 사용했을 때 첫번째 값이 중앙값이 되도록 한다.

"""

# import sys
#
# nums = list()
# for _ in range(int(sys.stdin.readline())):
#     num = int(sys.stdin.readline())
#     left = 0
#     right = len(nums) - 1
#     while left <= right:
#         pivot = (left + right) // 2
#         if num <= nums[pivot]:
#             right = pivot - 1
#         else:
#             left = pivot + 1
#     # print("%d %d %d" % (left, right, pivot))
#     nums = nums[:left] + [num] + nums[left:]
#     # print(nums)
#     print(nums[(len(nums) - 1) // 2])

# from bisect import bisect_left
# import sys
#
# nums = list()
# length = 0
# for _ in range(int(sys.stdin.readline())):
#     num = int(sys.stdin.readline())
#     left = bisect_left(nums, num)
#     # print("%d %d %d" % (left, right, pivot))
#     nums = nums[:left] + [num] + nums[left:]
#     length += 1
#     # print(nums)
#     print(nums[(length - 1) // 2])

import heapq
import sys

leftH = []
rightH = []
for _ in range(int(sys.stdin.readline())):
    num = int(sys.stdin.readline())

    if len(leftH) == len(rightH):
        heapq.heappush(leftH, -num)
    else:
        heapq.heappush(rightH, num)

    if len(leftH) > 0 and len(rightH) > 0 and rightH[0] < -leftH[0]:
        leftValue = heapq.heappop(leftH)
        rightValue = heapq.heappop(rightH)

        heapq.heappush(leftH, -rightValue)
        heapq.heappush(rightH, -leftValue)

    # print([leftH] + [rightH])
    print(-leftH[0])
