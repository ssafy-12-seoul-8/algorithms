import sys


def binary_search(target, start, end):
    while start <= end:
        mid = (end + start) // 2
        if n_list[mid] == target:
            return 1
        if n_list[mid] > target:
            end = mid - 1
            continue
        if n_list[mid] < target:
            start = mid + 1
            continue
    return 0


n = int(sys.stdin.readline())
n_list = sorted(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
ans = []
for i in map(int, sys.stdin.readline().split()):
    ans.append(binary_search(i, 0, n - 1))
print(*ans)
