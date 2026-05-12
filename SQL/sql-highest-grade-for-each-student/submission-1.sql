-- Write your query below
with RankedScores as (
    select student_id, exam_id, score,
    row_number() over (
        partition by student_id
        order by score desc, exam_id asc
    ) as rn
    from exam_results
)
select student_id, exam_id, score
from RankedScores where rn = 1;