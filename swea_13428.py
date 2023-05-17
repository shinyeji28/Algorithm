# 숫자 조작
T = int(input())
result = []
prev = []
def dfs(prev,start,L):
    global numbers
    if L == 0 :
        num = numbers[:]
        num[prev[0]-1],num[prev[1]-1] = num[prev[1]-1],num[prev[0]-1]
        if len(str(int(''.join(num))))==len(str(int(''.join(numbers)))):
            result.append(int(''.join(num)))
        return
    for n in range(start,len(numbers)+1):
        prev.append(n)
        dfs(prev,start+1,L-1)
        prev.pop()
for test_case in range(1, T + 1):
    numbers = list(input())
    if int(''.join(numbers))<10:
        result = [int(''.join(numbers))]
    else :
        result = []
        prev = []
        dfs([],1,2)
    print('#{} {} {}'.format(test_case,min(result),max(result)))