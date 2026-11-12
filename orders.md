# SQL Code Challenge: Find Customers with Multiple Completed Orders

You have two tables:

customers
---------
id
name
email

orders
------
id
customer_id
order_date
total_amount
status

Requirement:

Find all customers who have placed at least 2 completed orders.

Return:
| Column Name                            | Description                                                 |
|----------------------------------------|-------------------------------------------------------------|
| Customer ID                            | The ID of the customer                                      |
| Customer name                          | The name of the customer                                    |
| Number of completed orders             | The number of completed orders placed by the customer       |
| Total amount spent on completed orders | The total amount the customer has spent on completed orders |

Sort the results by total amount spent, from highest to lowest.


SQL Query:

Mi solución-
```sql

	SELECT c.id as customer_id, c.name as customer_name, count(*) as completed_orders, sum(total_amount) as total_amount_comp_ord  
		FROM customers c 
			INNER JOIN orders o ON c.id = o.customer_id
		WHERE o.status = "COMPLETED"

		HAVING completed_orders > 1
		GROUP BY C.id, c.name 
		ORDER BY total_amount_comp_ord DESC
```

Solución correcta-
```sql
	SELECT
		c.id AS customer_id,
		c.name AS customer_name,
		COUNT(*) AS completed_orders,
		SUM(o.total_amount) AS total_amount_comp_ord
	FROM customers AS c
		INNER JOIN orders AS o ON c.id = o.customer_id
	WHERE o.status = 'COMPLETED'
	GROUP BY c.id, c.name
	HAVING COUNT(*) >= 2
	ORDER BY total_amount_comp_ord DESC;
```