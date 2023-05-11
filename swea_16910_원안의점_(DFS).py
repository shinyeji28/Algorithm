T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
map =[]
def dfs(x,y,n2):
    if (x**2+y**2)>n2 or map[x][y]==0:
        return
    map[x][y]=0
    dfs(x+1,y,n2)
    dfs(x,y+1,n2)
for test_case in range(1, T + 1):
    n = int(input())
    map = [[1 for j in range(n+1)] for i in range(n+1)]
    answer=0
    dfs(0,0,n**2)
    for i in map:
        for j in i:
            if j==0:
                answer+=1
    print('#',end='')
    print(test_case,(answer-1)*2+1+((answer-1)-n*2)*2)