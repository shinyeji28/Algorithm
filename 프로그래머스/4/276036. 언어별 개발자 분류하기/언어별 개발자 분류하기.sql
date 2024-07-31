with temp as(
    select (select code from SKILLCODES where NAME = 'Python') as pycode,
            (select code from SKILLCODES where NAME = 'C#') as ccode,
            (select sum(code) from SKILLCODES where CATEGORY = 'Front End') as fecode
)

select case when pycode & d.SKILL_CODE <> 0 and fecode & d.SKILL_CODE <> 0 then 'A'
            when ccode & d.SKILL_CODE <> 0 then 'B'
            when fecode & d.SKILL_CODE <> 0 then 'C' end as GRADE
            , d.ID, d.EMAIL
from DEVELOPERS d, temp
where (d.SKILL_CODE & ( ccode + fecode)) <>0
order by GRADE, d.ID;