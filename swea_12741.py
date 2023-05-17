# 두 전구
# 출력 시간 줄이기
T = int(input())
diff = [0 for _ in range(T)]
for test_case in range(0, T):
    A,B,C,D = map(int,input().split())
    if (A<=C and C<=B) or (A<=D and D<=B):
        if A<=C and C<=B:
            if B<=D:
                diff[test_case]=(B-C)
            elif B>D:
                diff[test_case]=(D-C)
        elif A<=D and D<=B:
            if A<=C:
                diff[test_case]=(D-C)
            elif A>C:
                diff[test_case]=(D-A)
    elif C<=A and B<=D:
        diff[test_case] = B-A
for i,d in enumerate(diff):
    print('#{} {}'.format(i+1,d))