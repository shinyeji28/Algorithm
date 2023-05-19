# 다트 게임
import math
T = int(input())
total = [0 for _ in range(T)]
for test_case in range(T):
    N = int(input())
    for _ in range(N):
        x, y = map(int,input().split())
        x = math.fabs(x)
        y = math.fabs(y)
        r = math.sqrt(x**2 + y**2)
        if r == 0:
            total[test_case] += 10
        elif r>200:
            continue
        else:
            total[test_case] += 11-math.ceil(r/20)
for i in range(T):
    print('#{} {}'.format(i+1,total[i]))
