# 몬스터 사냥
T = int(input())
for test_case in range(1, T + 1):
    D,L,N = map(int,input().split())
    total = 0
    for n in range(0,N):
        total += D*(1+(n*L)/100)
    print('#{} {}'.format(test_case,int(total)))