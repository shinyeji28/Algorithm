# 교환학생
import math
T = int(input())
for test_case in range(1, T + 1):
    answer = []
    goal = int(input())
    week = list(input().split())
    for start in range(7):
        first = 0
        cnt=0
        compare =0
        result = -1
        if week[start]=='1':
            for i in range(7):
                if week[i]=='1':
                    cnt+=1
                    if start<=i and result==-1:
                        result = 7 - i
                    if start <= i:
                        first+=1
            compare = first
            circle = (goal-first)//cnt
            if (goal-first)%cnt>0:
                result += circle * 7
                compare += circle*cnt
            else:
                result += (circle-1)*7
                compare += ((circle-1)*cnt)
            if goal!=compare:
                for j in range(7):
                    if week[j]=='1':
                        compare+=1
                    if goal == compare:
                        result += j+1
                        break
            answer.append(result)
    print('#{} {}'.format(test_case,min(answer)))
