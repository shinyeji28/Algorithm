# 오목 판정
def cnt(i,j,d_i,d_j,isFirst):
    global c,N,board
    if isFirst and c<5:
        c = 0
    if i<0 or j<0 or j>=N or i>=N or board[i][j]=='.' or c>=5:
        return
    c+=1
    cnt(i+d_i,j+d_j,d_i,d_j,False)

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    c = 0
    flag = False
    board = [list(input()) for _ in range(N)]
    for i in range(N):
        for j in range(N):
            c = 0
            if board[i][j] == 'o':
                cnt(i,j,1,0,True)
                cnt(i,j,0,1,True)
                cnt(i, j,-1,0,True)
                cnt(i, j, 0,-1,True)
                cnt(i, j,1,1,True)
                cnt(i, j,-1,-1,True)
                cnt(i, j,-1,1,True)
                cnt(i, j,1,-1,True)
                if c >= 5:
                    flag = True
                    break
        if flag:
            break
    if c == 5:
        print('#{} YES'.format(test_case))
    else:
        print('#{} NO'.format(test_case))
