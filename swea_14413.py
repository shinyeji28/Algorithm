#dfs 런타임 에러 50 X 50 재귀 limit 벗어남
# T = int(input())
# def dfs(i,j,prev):
#     global board,M,N, ispossible
#     if i<0 or j<0 or i>=M or j>=N:
#         return 0
#     if check[i][j] == 0:
#         return 0
#     check[i][j] = 0
#     cur = board[i][j]
#     if cur==prev:
#         ispossible = False
#         return 1
#     elif cur=='?':
#         cur = change[prev]
#
#     re = dfs(i+1,j,cur)
#     if not re:
#         re = dfs(i-1,j,cur)
#     if not re:
#         re = dfs(i,j+1,cur)
#     if not re:
#         dfs(i,j-1,cur)
#
# for test_case in range(1, T + 1):
#     M,N = map(int,input().split())
#     ispossible = True
#     change = {'#':'.','.':'#'}
#     check = [[1 for _ in range(N)] for _ in range(M)]
#     board = []
#     for _ in range(M):
#         board.append(list(input()))
#     flag = False
#     for i in range(M):
#         for j in range(N):
#             if board[i][j]!='?':
#                 dfs(i,j,change[board[i][j]])
#                 flag = True
#                 break
#         if flag:
#             break
#     if ispossible:
#         print('#{} possible'.format(test_case))
#     else:
#         print('#{} impossible'.format(test_case))

# 체크 배열 #짝-.홀 or .홀-#짝
T = int(input())
for test_case in range(1, T + 1):
    M,N=map(int,input().split())
    arr = [list(input()) for _ in range(M)]
    check = [0,0,0,0]
    for i in range(M):
        for j in range(N):
            if arr[i][j]=='#':
                if (i+j)%2==0:
                    check[0]+=1
                else:
                    check[1]+=1
            elif arr[i][j]=='.':
                if (i+j)%2==0:
                    check[2]+=1
                else:
                    check[3]+=1
    if (check[0] and check[1]) or (check[0] and check[2]) or (check[1] and check[3]) or (check[2] and check[3]):
        print('#{} impossible'.format(test_case))
    else:
        print('#{} possible'.format(test_case))


# bfs - 런타임 에러
# import collections
# def bfs(i,j,prev):
#     global arr,M,N
#     visited = [[0 for _ in range(N)] for _ in range(M)]
#     que = collections.deque()
#     que.append([i,j,prev])
#     while que:
#         cur = que.popleft()
#         if visited[cur[0]][cur[1]]==0:
#             visited[cur[0]][cur[1]]=1
#             if cur[2]==arr[cur[0]][cur[1]] and arr[cur[0]][cur[1]]!='?':
#                 return 0
#             else:
#                 if arr[cur[0]][cur[1]]=='?':
#                     prev = '.' if cur[2]=='#' else '#'
#                 else:
#                     prev = arr[cur[0]][cur[1]]
#                 if cur[0]>0:
#                     que.append([cur[0]-i,cur[1],prev])
#                 if cur[0]<M-1:
#                     que.append([cur[0]+i,cur[1],prev])
#                 if cur[1]>0:
#                     que.append([cur[0],cur[1]-1,prev])
#                 if cur[1]<N-1:
#                     que.append([cur[0],cur[1]+1,prev])
#     return 1
# 
# 
# 
# 
# T = int(input())
# for test_case in range(1, T + 1):
#     M,N=map(int,input().split())
#     arr = [list(input()) for _ in range(M)]
#     flag = False
#     re = 0
#     for i in range(M):
#         for j in range(N):
#             if arr[i][j]=='#':
#                 re = bfs(i,j,'.')
#                 flag=True
#                 break
#             elif arr[i][j]=='.':
#                 re = bfs(i,j,'#')
#                 flag=True
#                 break
#         if flag:
#             break
#     if not flag or re == 1:
#         print('#{} possible'.format(test_case))
#     else:
#         print('#{} impossible'.format(test_case))
