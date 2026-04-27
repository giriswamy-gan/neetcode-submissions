-- Write your query below
select u.name, 
SUM(case when r.distance is null then 0 else r.distance end) as travelled_distance
from users u left join rides r
on u.id = r.user_id
group by u.id
order by travelled_distance desc, u.name;