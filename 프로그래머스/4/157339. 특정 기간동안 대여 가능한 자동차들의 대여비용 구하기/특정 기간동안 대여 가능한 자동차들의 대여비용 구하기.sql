# -- where 종류가 '세단' 또는 'SUV'  2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 30일간의 대여 금액이 50만원 이상 200만원 미만
# -- order by 대여 금액 desc, 차 종류 asc, 차ID desc
# with price as (
#     select distinct(c.CAR_ID), p.CAR_TYPE, round((c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE*0.01)) *30, 0) as FEE
#     from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p join CAR_RENTAL_COMPANY_CAR c on c.CAR_TYPE = p.CAR_TYPE
#     where p.CAR_TYPE in ('세단', 'SUV') and p.DURATION_TYPE = '30일 이상' and (c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE*0.01)) *30 >=500000 and (c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE*0.01)) *30  < 2000000
#  ) 

# SELECT distinct(p.CAR_ID),p.CAR_TYPE, p.FEE
# from price p 
# where car_id not in (
#         select h.car_id
#         from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
#         where h.END_DATE >= '2022-11-01' or h.END_DATE <= '2022-11-30'
#     ) 
# order by p.FEE DESC, p.CAR_TYPE, p.CAR_ID DESC;

WITH price AS (
    SELECT 
        c.CAR_ID, 
        p.CAR_TYPE, 
        ROUND((c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE * 0.01)) * 30, 0) AS FEE
    FROM 
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
    JOIN 
        CAR_RENTAL_COMPANY_CAR c ON c.CAR_TYPE = p.CAR_TYPE
    WHERE 
        p.CAR_TYPE IN ('세단', 'SUV') 
        AND p.DURATION_TYPE = '30일 이상' 
        AND ROUND((c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE * 0.01)) * 30) >= 500000 
        AND ROUND((c.DAILY_FEE - c.DAILY_FEE * (p.DISCOUNT_RATE * 0.01)) * 30) < 2000000
) 
SELECT 
    p.CAR_ID, 
    p.CAR_TYPE, 
    p.FEE
FROM 
    price p 
WHERE 
    p.CAR_ID NOT IN (
        SELECT 
            h.CAR_ID
        FROM 
            CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        WHERE 
            (h.START_DATE <= '2022-11-30' AND h.END_DATE >= '2022-11-01')
    ) 
ORDER BY 
    p.FEE DESC, 
    p.CAR_TYPE, 
    p.CAR_ID DESC;
