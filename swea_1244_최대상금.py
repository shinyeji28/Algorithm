# 1. dfs를 사용해서 완전 탐색
# 2. max값을 미리 찾은 후 dfs에서 모두 사용한 횟수 레벨에서 현재 값과 비교하며 같으면 탈출 - 시간 줄이기
# 3. max값과 같은 값을 찾지 못하면 저장된 값 중 큰 값을 출력

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def dfs(numbers,L):
    global num, result, maxNum,isFind,same
    n = int(''.join(numbers))
    if isFind:
        return
    if maxNum == n:
        if L%2==1 and not same:
            numbers[-2], numbers[-1] = numbers[-1], numbers[-2]
            result = int(''.join(numbers))
        else:
            result = maxNum
        isFind = True
        return

    if L == 0:
        if result < n:
            result = n
        return

    for i in range(len(numbers)-1):
        for j in range(i+1,len(numbers)):
            if numbers[i]<numbers[j]:
                numbers[i], numbers[j] = numbers[j], numbers[i]
                dfs(numbers,L-1)
                numbers[i], numbers[j] = numbers[j], numbers[i]

for test_case in range(1, T + 1):
    result = 0
    isFind = False
    num, L = input().split()
    _sorted = sorted(num,reverse=True)
    maxNum = int(''.join(_sorted))
    same = False
    for i in range(len(_sorted)-1):
        for j in range(i+1,len(_sorted)):
            if _sorted[i]==_sorted[j]:
                same =True
                break
        if same:
            break
    dfs(list(num),int(L))
    print('#{} {}'.format(test_case,result))