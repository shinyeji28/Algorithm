# p.347
# 문제 : 전체 수 n을 입력받아 k개의 조합을 리턴
# 순열과 비슷하지만 자기자신과 앞 요소를 모두 배제하여 dfs로 넘겨야 함으로 start위치를 파라미터로 줌
def solution(n,k):
    answer=[]
    elements = []
    def dfs(elements,start,k):
        if k==0:
            answer.append(elements[:])
            return
        for i in range(start,n+1):
            elements.append(i)
            dfs(elements,i+1,k-1)
            elements.pop()
    dfs(elements,1,k)
    return answer
print(solution(4,2))

# itertools를 사용하여 조합
import itertools 
def solution2(n,k):
    return list(map(list,itertools.combinations(range(1,n+1),k)))
print(solution2(4,2))