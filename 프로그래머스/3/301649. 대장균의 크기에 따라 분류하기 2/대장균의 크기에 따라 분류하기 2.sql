select t.ID, 
        case 
            when ranking <= (select count(*) from ECOLI_DATA) / 4 then  'CRITICAL'
            when ranking <= (select count(*) from ECOLI_DATA) / 4 * 2 then  'HIGH'
            when ranking <= (select count(*) from ECOLI_DATA) / 4 * 3 then  'MEDIUM'
            else 'LOW'
        end as 'COLONY_NAME'
from (
    select ID, rank() over (order by SIZE_OF_COLONY desc) as ranking
    from ECOLI_DATA
 ) as t
order by t.ID;