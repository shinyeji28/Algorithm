select e2.ID, e2.GENOTYPE,	e1.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA e1 join ECOLI_DATA e2 on e1.id = e2.PARENT_ID
where e2.PARENT_ID is not null and e1.GENOTYPE & e2.GENOTYPE = e1.GENOTYPE
order by id;