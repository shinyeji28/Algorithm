# p.341
# 문제: 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴
    # 해결 과정
    # 1. 배열을 순회하여 각 원소마다 DFS실행
    # 2. next 변수에 뽑은 원소를 제외한 배열을 저장해 DFS파라미터로 보냄
    # 3. prev 변수에 뽑은 원소를 스택으로 저장
    # 4. 종료 조건 : 파라미터가 없으면 리턴
    # 5. DFS보내고 prev를 pop
    # 주의! 참조가 되지 않고 값 자체를 복사하기 위해 [:]를 사용!!
# 추가 노트 !! 순열 개수 = nPr = n!/(n-r)!
def solution(array):
    answer = []
    prev = []
    def dfs(elements):
        if len(elements)==0:
            answer.append(prev[:])
        for e in elements:
            next = elements[:]       # next: 뽑은 요소를 제외한 배열을 다음 레벨에 전달
            next.remove(e)

            prev.append(e)           # prev: 뽑은 요소를 저장
            dfs(next)
            prev.pop()
    dfs(array)
    return answer
print(solution([1,2,3]))

# itertools 모듈을 사용한 순열
import itertools
def solution2(array):
    return list(map(list,itertools.permutations(array)))  # 함수의 결과가 튜플을 반환하기 때문에 map을 사용하여 요소를 list로 변화시키자
print(solution2([1,2,3]))
