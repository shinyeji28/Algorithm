select round(avg(t.len),2) as AVERAGE_LENGTH
from (    
    select case when length is null then 10
                else length end as len
    from FISH_INFO
    ) as t;

