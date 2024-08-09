
WITH CP AS(
    SELECT *
    from CART_PRODUCTS 
    group by CART_ID, name
    having name in ('Milk', 'Yogurt')
    ORDER BY CART_ID
)

SELECT CART_ID
FROM CP
GROUP BY CART_ID
HAVING COUNT(CART_ID) >= 2
ORDER BY CART_ID;
