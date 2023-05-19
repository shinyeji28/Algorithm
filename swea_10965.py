# 제곱수 만들기
# 실행 시간 절약을 위해
#     1. 에라토스테네스의 체로 소수를 구한 뒤
#     2. 저장된 소수를 돌려 소인수 구하기
#     3. 제곱수이면 1을 리턴
#     4. 각 소인수가 홀수번 제곱되면 제곱해서 딱 떨어지지 않기 때문에 해당 소수를 결과값에 곱하여 저장하기를 반복
prime = [2]
for n in range(3,int(10000000**0.5)):
    for p in prime:
        if n%p==0:
            break
    else:
        prime.append(n)
answer=[]
T = int(input())
for t in range(T):
    num = int(input())
    if num**0.5%1==0:
        answer.append(1)

    elif num in prime:
        answer.append(num)

    else:
        r = num
        result = 1
        for p in prime:
            if r%p==0:
                cnt=0
                while not r%p:
                    r=r//p
                    cnt+=1
                if cnt%2==1:
                   result *= p
            if r==1 or p>r:
                break
        if r>1:
            result*=r
        answer.append(result)
for i,a in enumerate(answer):
    print('#{} {}'.format(i+1,a))


