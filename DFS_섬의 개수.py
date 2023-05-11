# 파알인 p.331
# 문제 : 1-육지, 0-바다 일 때 섬의 개수 구하기
    # 해결 과정
    # 1. 배열을 탐색하여 육지를 찾아 DFS 실행, DFS 실행 완료 후 카운트(섬을 찾았다)
    # 2. DFS 함수 - 4방향의 재귀함수 실행, 바다가 나올때까지  
def solution(islands):
    answer=0
    grid = islands
    def dfs(i,j):
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]!=1:
            return
        grid[i][j]=0
        dfs(i-1,j)
        dfs(i+1,j)
        dfs(i,j-1)
        dfs(i,j+1)
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j]==1:
                dfs(i,j)
                answer+=1
    return answer
print(solution([[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]))
print(solution([[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]))