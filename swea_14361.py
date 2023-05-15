# 숫자가 같은 배수
# 순열

T = int(input())
result =[]
prev = []
def dfs(numbers):
    if len(numbers)==0:
        result.append(int(''.join(prev)))
        return
    for n in numbers:
        next = numbers[:]
        next.remove(n)
        prev.append(n)
        dfs(next)
        prev.pop()
for test_case in range(1, T + 1):
    result =[]
    prev = []
    numbers = list(input())
    num = int(''.join(numbers))
    flag = False
    dfs(numbers)
    for r in result:
        if r>num and (r/num)%1==0:
            flag=True
            break
    if flag:
        print('#{} possible'.format(test_case))
    else:
        print('#{} impossible'.format(test_case))

