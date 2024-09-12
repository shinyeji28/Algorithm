with t as(
    select case 
                when length is null then 10 
                else length 
            end as length, ID, FISH_TYPE, TIME
    from FISH_INFO
)

select count(*) as FISH_COUNT, max(length) as MAX_LENGTH, FISH_TYPE
from t
group by FISH_TYPE
having avg(LENGTH) >= 33
order by fish_type



