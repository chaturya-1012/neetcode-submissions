-- Write your query below
select name,coalesce(sum(distance),0) travelled_distance from users left outer join rides on users.id=user_id 
group by user_id,name
order by travelled_distance desc,name asc;