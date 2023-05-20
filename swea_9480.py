# 알파벳 공부
# 가능한 조합 모두 구하기
def dfs(pick, start, flag):
    global arr, answer
    temp = 0
    if flag:
        answer += 1
    else:
        for p in pick:
            temp |= p
        if temp == (2 ** 26) - 1:
            answer += 1
            flag = True
    for i in range(start, len(arr)):
        pick.append(arr[i])
        dfs(pick, i+1, flag)
        pick.pop()
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    answer = 0
    arr = []
    strs=[]
    for _ in range(N):
        _input = input()
        strs.append(_input)
    for str in strs:
        temp =0
        for s in str:
            if s>='a' and s<='z':
                temp = temp | (2**(ord(s.lower())-ord('a')))
        arr.append(temp)
    dfs([], 0, False)
    print('#{} {}'.format(test_case, answer))
