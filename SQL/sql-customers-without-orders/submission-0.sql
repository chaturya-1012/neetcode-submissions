-- Write your query below
select name from customers c left outer join orders o on 
c.id=o.customer_id where customer_id is null;