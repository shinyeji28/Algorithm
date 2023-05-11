import math
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    find = int(input())
    factor = []
    _sqrt = int(math.sqrt(find))
    for i in range(1,_sqrt+1):
        if(find%i==0):
            factor.append(find//i + i -2)
    print('#',end='')
    print(test_case,min(factor))
