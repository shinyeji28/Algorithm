# 수 색칠하기
# 미해결
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,K = map(int,input().split())
    A = list(map(int,input().split()))
    F = list(map(int,input().split()))
    max = 0
    while K>=0:
        max = A[0]*F[0]
        idx = 0
        for i in range(N):
            mul = A[i]*F[i]
            if mul>0:
                if max == mul:
                    if (A[idx]-1)*F[idx]>(A[i]-1)*F[i]:
                        idx = i
                elif max < mul:
                    max = mul
                    idx = i
        A[idx]-=1
        K-=1
    print('#{} {}'.format(test_case,max))