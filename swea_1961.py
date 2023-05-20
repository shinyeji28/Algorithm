# 숫자 배열 회전
def rotation(arr):
    global N
    i_c = 0
    r90=[]
    for _ in range(N):
        r90.append([0 for _ in range(N)])
    for i in range(N):
        i_c -=1
        for j in range(N):
            r90[j][i_c]=arr[i][j]
    return r90
T = int(input())
for test_case in range(1, T + 1):
    N=int(input())
    arr=[];r90=[];r180=[];r270=[]
    for _ in range(N):
        arr.append(input().split())
        r90.append([0 for _ in range(N)])
        r180.append([0 for _ in range(N)])
        r270.append([0 for _ in range(N)])

    r90 = rotation(arr)
    r180 = rotation(r90)
    r270 = rotation(r180)
    print('#{}'.format(test_case))
    for i in range(N):
        print(''.join(r90[i]),''.join(r180[i]),''.join(r270[i]))
