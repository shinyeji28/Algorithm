SELECT ANIMAL_ID,NAME
from ANIMAL_INS 
where ANIMAL_TYPE = 'dog' and NAME like '%el%'
order by NAME;