# 통역사 성경이
# 미해결 - 런타임에러
T = int(input())
answer =[]
strs=[]
for test_case in range(1, T + 1):
    N = int(input())
    strs.append(input().split())
for row in strs:
    names={}
    end = False
    result = []
    for s in row:
        if s[-1] == '.' or s[-1] == '?' or s[-1] == '!':
            end = True
            s = s[:-1]
        if s:
            if s[0]>='A' and s[0]<='Z':
                if len(s)>1:

                    for i in range(1,len(s)):
                        if s[i]<'a' or s[i]>'z':
                            break
                    else:
                        if s not in names:
                            names[s]=1
                        else:
                            names[s]+=1
                else:
                    if s not in names:
                        names[s] = 1
                    else:
                        names[s] += 1
        if end:
            result.append(len(names))
            end=False
            names={}
    answer.append(result)

for t,a in enumerate(answer):
    print('#{}'.format(t+1),end='')
    for i in a:
        print(' {}'.format(i),end='')
    if t !=len(answer)-1:
        print()
