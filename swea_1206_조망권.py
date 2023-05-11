for times in range(1,10+1):
    T = int(input())
    # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    arats=[]
    aparts = list(map(int,input().split()))
    cnt = 0
    for i in range(2, T - 2):
        cur = aparts[i]
        thenLeft= min(cur - aparts[i-1],cur - aparts[i-2])
        thenRight = min(cur - aparts[i+1], cur - aparts[i+2])
        if thenLeft > 0 and thenRight > 0:
            cnt += min(thenLeft,thenRight)
    print('#',end='')
    print(times,cnt)


