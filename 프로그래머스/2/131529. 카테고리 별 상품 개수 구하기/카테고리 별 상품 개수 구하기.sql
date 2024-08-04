SELECT substring(PRODUCT_CODE,1,2) as CATEGORY ,count(substring(PRODUCT_CODE,1,2) ) as PRODUCTS
from PRODUCT
group by substring(PRODUCT_CODE,1,2) 
order by CATEGORY ;
