with allCounts as(
    select distinct count(*) as cnt
    from USER_INFO
    where year(joined) = '2021'
)

select year(o.SALES_DATE) as YEAR , month(o.SALES_DATE) as MONTH, count(distinct u.user_id) as PURCHASED_USERS ,round(count(distinct u.user_id)/a.cnt,1) as PUCHASED_RATIO
from USER_INFO u join ONLINE_SALE o on u.user_id = o.user_id, allCounts a
where year(u.joined) = '2021'
group by year(o.SALES_DATE) , month(o.SALES_DATE)
order by 1,2;