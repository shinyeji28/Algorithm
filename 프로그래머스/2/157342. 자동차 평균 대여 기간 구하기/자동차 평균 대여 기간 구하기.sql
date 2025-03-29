select CAR_ID, round(avg(datediff(END_DATE, START_DATE) + 1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by CAR_ID
having AVERAGE_DURATION >= 7 
order by 2 desc, CAR_ID desc;