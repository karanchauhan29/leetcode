WITH product_count AS (
    SELECT COUNT(*) as total FROM Product
)
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT total FROM product_count);