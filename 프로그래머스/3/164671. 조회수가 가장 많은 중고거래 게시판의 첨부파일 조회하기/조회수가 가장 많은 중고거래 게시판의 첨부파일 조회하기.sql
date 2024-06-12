-- 코드를 입력하세요

SELECT concat('/home/grep/src/',f.BOARD_ID,'/',f.FILE_ID,f.FILE_NAME,f.FILE_EXT) as FILE_PATH
from (select * from used_goods_board order by VIEWS desc
limit 1) as b inner join used_goods_file f on b.BOARD_ID=f.BOARD_ID
order by f.file_id desc;