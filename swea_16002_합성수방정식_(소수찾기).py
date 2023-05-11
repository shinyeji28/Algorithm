import math
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def isPrime(n):
    _sqrt = int(math.sqrt(n))
    for i in range(2,_sqrt+1):
        if n%i==0:
            return False
    return True
for test_case in range(1, T + 1):
    diff = int(input())
    for i in range(2,10**9+1):
        if not isPrime(i):
            if not isPrime(i+diff):
                print('#',end='')
                print(test_case,i+diff, i)
                break

# T = int(input())
# # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# prime = []
# def isPrime(n):
#     for p in prime:
#         if n%p==0:
#             return False
#     return True
# for test_case in range(1, T + 1):
#     excepted = []
#     diff = int(input())
#     prime =[]
#     for i in range(2,100**9+1):
#         if len(prime)!=0:
#             if len(excepted)!=0 and excepted[0] == i:
#                 continue
#             if not isPrime(i): #합성수
#                 if not isPrime(i+diff):
#                     print('#',end='')
#                     print(test_case,i+diff,i)
#                     break
#                 else:
#                     prime.append(i)
#                 excepted.append(i+diff)
#             else:
#                 prime.append(i) #소수
#         else:
#             prime.append(i)