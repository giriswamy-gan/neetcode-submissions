-- Write your query below
select t.team_id, t.team_name,
coalesce(sum(case
when t.team_id = m.host_team and m.host_goals > m.guest_goals then 3
when t.team_id = m.guest_team and m.guest_goals > m.host_goals then 3
when m.host_goals = m.guest_goals then 1
else 0
end), 0) as num_points
from teams t
left join matches m on t.team_id = m.host_team or t.team_id = m.guest_team
group by t.team_id, t.team_name
order by num_points desc, team_id