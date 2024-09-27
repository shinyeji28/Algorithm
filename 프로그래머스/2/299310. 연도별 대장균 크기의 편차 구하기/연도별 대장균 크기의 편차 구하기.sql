WITH YearlyMaxSize AS (
    -- 각 연도별 가장 큰 대장균 크기를 구하는 서브쿼리
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR, 
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM 
        ECOLI_DATA
    GROUP BY 
        YEAR(DIFFERENTIATION_DATE)
)
-- 메인 쿼리: 각 대장균의 편차를 구하고 정렬
SELECT 
    YEAR(D.DIFFERENTIATION_DATE) AS YEAR,
    (Y.MAX_SIZE - D.SIZE_OF_COLONY) AS YEAR_DEV,
    D.ID
FROM 
    ECOLI_DATA D
JOIN 
    YearlyMaxSize Y
ON 
    YEAR(D.DIFFERENTIATION_DATE) = Y.YEAR
ORDER BY 
    YEAR, 
    YEAR_DEV;
