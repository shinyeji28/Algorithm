select i.ID, n.FISH_NAME, i.LENGTH
from FISH_NAME_INFO n join FISH_INFO i on n.FISH_TYPE = i.FISH_TYPE
where i.LENGTH is not null and i.LENGTH = (select max(LENGTH)
                 from FISH_INFO  
                 where LENGTH is not null and i.FISH_TYPE = FISH_TYPE)
order by id;
