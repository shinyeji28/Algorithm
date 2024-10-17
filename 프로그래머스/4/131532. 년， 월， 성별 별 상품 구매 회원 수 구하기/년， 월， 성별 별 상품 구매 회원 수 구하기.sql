select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, GENDER, count(distinct(u.USER_ID)) as USERS
from USER_INFO u join ONLINE_SALE o on u.USER_ID=o.USER_ID
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), GENDER
order by 1,2,3;