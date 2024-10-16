-- HR_GRADE  상하반기 평가점수 합
-- HR_DEPARTMENT, HR_EMPLOYEES join -> 평가점수 join 

select g.SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION,e.EMAIL
from HR_EMPLOYEES e  
    join (select EMP_NO, sum(SCORE) as score
            from HR_GRADE
            group by EMP_NO, YEAR
            having YEAR = 2022 and sum(score) 
            order by score desc
            limit 1) as g on e.EMP_NO = g.EMP_NO
