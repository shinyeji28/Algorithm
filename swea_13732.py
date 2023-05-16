# 정사각형 판정
import math
def dfs(i, j,cnt_arr):
    global N,cnt
    if i<0 or j<0 or j>=N or i>=N or cnt_arr[i][j]=='.':
        return
    cnt_arr[i][j]='.'
    cnt+=1
    dfs(i+1,j,cnt_arr)
    dfs(i-1,j,cnt_arr)
    dfs(i,j-1,cnt_arr)
    dfs(i,j+1,cnt_arr)

def compare(i,j,n,arr):
    global N
    for _i in range(N):
        for _j in range(N):
            if _i >=i and _i<i+n and _j >=j and _j<j+n:
                if arr[_i][_j]=='.':
                    return False
            else:
                if arr[_i][_j]=='#':
                    return False

    return True

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    cnt_arr = [a[:] for a in arr]
    cnt = 0
    flag = True
    for i in range(N):
        for j in range(N):
            if arr[i][j] == '#':
                cnt = 0
                dfs(i,j,cnt_arr)
                find_N = math.sqrt(cnt)
                flag = False
                break
        if not flag:
            break
    if find_N % 1 == 0:
        flag = compare(i, j, int(find_N), arr)
    else:
        flag = False

    if flag:
        print('#{} yes'.format(test_case))
    else:
        print('#{} no'.format(test_case))