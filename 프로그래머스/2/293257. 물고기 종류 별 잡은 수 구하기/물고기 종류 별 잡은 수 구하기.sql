select count(*) as FISH_COUNT, n.FISH_NAME
from FISH_NAME_INFO n join FISH_INFO i on n.FISH_TYPE=i.FISH_TYPE
group by n.FISH_NAME
order by 1 desc;