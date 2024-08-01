select eg.EMP_NO, eg.EMP_NAME, 
    case when eg.score_avg >= 96 then 'S'
         when eg.score_avg >= 90 then 'A'
         when eg.score_avg >= 80 then 'B'
         else 'C'
    end as GRADE,
    case when eg.score_avg >= 96 then SAL * 0.2
         when eg.score_avg >= 90 then SAL * 0.15
         when eg.score_avg >= 80 then SAL * 0.1
         else SAL * 0
    end as BONUS
from (select e.EMP_NO, e.EMP_NAME, avg(g.SCORE) as score_avg, SAL
    from HR_EMPLOYEES e left join HR_GRADE g on e.EMP_NO = g.EMP_NO
    group by e.EMP_NO) as eg
