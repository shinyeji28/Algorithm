def solution(numbers, target):
    answer = 0
    def dfs(L,t):
        nonlocal answer
        if L==len(numbers):
            if t==target:
               answer+=1 
            return
        dfs(L+1,t+numbers[L]*(-1))
        dfs(L+1,t+numbers[L])
    dfs(0,0)    
    return answer