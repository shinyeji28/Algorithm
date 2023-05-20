# 신뢰

T = int(input())
for test_case in range(1, T + 1):
    arr=[]
    arr = input().split()
    btn = []
    B =[]
    O=[]
    for i in range(1,int(arr[0])*2,2):
        btn.append(arr[i])
        if arr[i]=='B':
            B.append(int(arr[i+1]))
        elif arr[i]=='O':
            O.append(int(arr[i+1]))
    i=0
    b=1;o=1
    b_idx=0;o_idx=0
    cnt=0
    while i<len(btn):
        if btn[i]=='B':
            if b==B[b_idx]:
                i+=1
                b_idx+=1
                cnt+=1
                if len(O)!=0 and o_idx<len(O):
                    o= o+1 if O[o_idx]>o else o-1 if O[o_idx]<o else o
            else:
                able = abs(B[b_idx]-b)
                cnt+=able
                b=B[b_idx]
                if len(O)!=0 and o_idx<len(O):
                    o = O[o_idx] if abs(O[o_idx]-o)<=able else o+(-1)*able if O[o_idx]-o<0 else o+able
        elif btn[i]=='O':
            if o==O[o_idx]:
                i+=1
                o_idx+=1
                cnt+=1

                if len(B)!=0 and b_idx<len(B):
                    b= b+1 if B[b_idx]>b else b-1 if B[b_idx]<b else b

            else:
                able = abs(O[o_idx]-o)
                cnt+=able

                o=O[o_idx]
                if len(B)!=0 and b_idx<len(B):
                    b = B[b_idx] if abs(B[b_idx]-b)<=able else b+(-1)*able if B[b_idx]-b<0 else b+able

    print('#{} {}'.format(test_case,cnt))