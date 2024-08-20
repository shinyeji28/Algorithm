
with RECURSIVE generate as(
    select ID, 1 as gernerateNum
    from ECOLI_DATA 
    where PARENT_ID is null
    
    union all
    
    select e.id, g.gernerateNum+1
    from ECOLI_DATA e join generate g on e.PARENT_ID = g.id
)


select count(*) as COUNT, gernerateNum AS GENERATION
FROM generate g 
where g.id not in (select e.parent_id from ECOLI_DATA e where parent_id is not null)
group by gernerateNum
order by gernerateNum;

