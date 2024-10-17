select case when floor(PRICE / 10000) = 0 then 0 else floor(PRICE / 10000) * 10000 end as PRICE_GROUP, count(PRICE) as PRODUCTS
from PRODUCT
group by floor(PRICE / 10000)
order by 1;
