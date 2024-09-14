# -- 종류 트럭의 대여 기록에서 대여 기록 별 대여 금액

# -- CAR_RENTAL_COMPANY_CAR car 의 CAR_TYPE = 트럭 : 종류 트럭 
# -- CAR_RENTAL_COMPANY_RENTAL_HISTORY join car  
# -- CAR_RENTAL_COMPANY_RENTAL_HISTORY의  case start_date, end_date : (기간 할인) 대여 금액 (FEE)

# with truck_history as(
#     select car.daily_fee, car.car_type, history.history_id, history.start_date, history.end_date, datediff(history.end_date , history.start_date) + 1 as rental_duration
#     from CAR_RENTAL_COMPANY_CAR car join CAR_RENTAL_COMPANY_RENTAL_HISTORY history on car.car_id = history.car_id
#     where car.car_type like '트럭'
# ),
# duration_type_to_number as (
#     select plan_id, car_type, discount_rate, case duration_type when '7일 이상' then 7
#                                     when '30일 이상' then 30
#                                     when '90일 이상' then 90
#                                 end as duration
#     from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
# ),

# fee_calculation as(
#     select th.history_id, case when th.rental_duration < 7 then th.daily_fee
#                                 when th.rental_duration >= 90 then th.daily_fee * (1 - plan.discount_rate/100)
#                                 when th.rental_duration >= 30 then th.daily_fee * (1 - plan.discount_rate/100)
#                                 when th.rental_duration >= 7 then th.daily_fee * (1 - plan.discount_rate/100)
#                             end as fee
#     from duration_type_to_number plan right join truck_history th 
#     on th.rental_duration >= plan.duration
# )

# select history_id, CAST(fee as signed) as FEE
# from fee_calculation
# order by FEE DESC, history_id DESC; 

WITH truck_history AS (
    SELECT 
        car.daily_fee, 
        history.history_id, 
        (DATEDIFF(history.end_date, history.start_date) + 1) AS rental_duration
    FROM CAR_RENTAL_COMPANY_CAR car 
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY history ON car.car_id = history.car_id
    WHERE car.car_type = '트럭'
),
duration_type_to_number AS (
    SELECT 
        plan_id, 
        car_type, 
        discount_rate, 
        CASE duration_type 
            WHEN '7일 이상' THEN 7
            WHEN '30일 이상' THEN 30
            WHEN '90일 이상' THEN 90
        END AS duration
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
),
fee_calculation AS (
    SELECT 
        th.history_id, 
        CASE 
            WHEN th.rental_duration < 7 THEN th.daily_fee * th.rental_duration
            WHEN th.rental_duration >= 90 THEN th.daily_fee * th.rental_duration * (1 - COALESCE(MAX(plan.discount_rate), 0) / 100)
            WHEN th.rental_duration >= 30 THEN th.daily_fee * th.rental_duration * (1 - COALESCE(MAX(plan.discount_rate), 0) / 100)
            WHEN th.rental_duration >= 7 THEN th.daily_fee * th.rental_duration * (1 - COALESCE(MAX(plan.discount_rate), 0) / 100)
        END AS fee
    FROM truck_history th
    LEFT JOIN duration_type_to_number plan 
    ON th.rental_duration >= plan.duration AND plan.car_type = '트럭'
    GROUP BY th.history_id, th.daily_fee, th.rental_duration
)
SELECT 
    history_id, 
    CAST(fee AS SIGNED) AS FEE
FROM fee_calculation
ORDER BY FEE DESC, history_id DESC;
