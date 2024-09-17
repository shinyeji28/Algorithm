-- 7월 아이스크림 총 주문량
-- 상반기의 아이스크림 총 주문량
-- 더한 값이 큰 순서대로 상위 3개의 맛

SELECT fh.FLAVOR 
from (select sum(TOTAL_ORDER) as total, flavor from FIRST_HALF group by FLAVOR) as fh join (select sum(TOTAL_ORDER) as total, flavor from JULY group by FLAVOR) j on fh.FLAVOR = j.FLAVOR
order by (fh.total + j.total) desc
limit 3;

