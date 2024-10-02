with parent_count as (
    select parent_id, count(*) as CHILD_COUNT 
    from ECOLI_DATA 
    where PARENT_ID is not null
    group by parent_id
)

select ID, case when c.child_count is null then 0 else c.child_count end as CHILD_COUNT 
from ECOLI_DATA d left join parent_count c on d.id = c.parent_id;
