select M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
from MEMBER_PROFILE M JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
where M.member_id in (    
    select member_id
    from REST_REVIEW
    group by MEMBER_ID
    HAVING COUNT(*) = (
        -- 최대 리뷰 수
        select max(cnt) as max_value
        from (
            SELECT m.member_id, count(*) as cnt
            from MEMBER_PROFILE m join REST_REVIEW r on m.member_id = r.member_id
            group by r.member_id
        ) as review_cnt
    )
)
order by r.review_date, r.review_text;