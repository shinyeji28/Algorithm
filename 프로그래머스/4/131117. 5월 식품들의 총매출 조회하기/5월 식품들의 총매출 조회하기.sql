SELECT p.product_id as PRODUCT_ID, PRODUCT_NAME, sum(p.price * o.amount) as TOTAL_SALES
from FOOD_PRODUCT p inner join FOOD_ORDER o on p.product_id = o.product_id
where year(o.PRODUCE_DATE) = 2022 and month(o.PRODUCE_DATE) = 5
group by p.product_id
order by TOTAL_SALES desc, PRODUCT_ID;