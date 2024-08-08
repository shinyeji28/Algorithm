SELECT year(o.sales_date) as YEAR, month(o.sales_date) as MONTH, u.gender as GENDER, count(distinct(u.user_id)) as USERS
from USER_INFO u join ONLINE_SALE o on u.user_id = o.user_id
where u.gender is not null
group by year(o.sales_date), month(o.sales_date), u.gender
order by year(o.sales_date), month(o.sales_date), u.gender;
