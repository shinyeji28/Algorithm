select month(start_date) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in
    (select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date >= '2022-08-01' and start_date <='2022-10-31'
    group by CAR_ID
    having count(*) >= 5)
    and start_date >= '2022-08-01' and start_date <='2022-10-31'
group by month(start_date), car_id
having count(*) > 0
order by 1,2 desc;