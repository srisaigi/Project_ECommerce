-- =======================================
-- USERS TABLE INITIAL DATA
-- =======================================
INSERT INTO user (id, username, email, password, role)
VALUES
(1, 'admin', 'admin@shop.com', '$2a$10$abc123hashedpasswordxyz', 'ADMIN'),
(2, 'john_doe', 'john@example.com', '$2a$10$abc123hashedpasswordxyz', 'CUSTOMER');

-- =======================================
-- PRODUCTS TABLE INITIAL DATA
-- =======================================
INSERT INTO product (id, name, description, price, stock, category, image_url)
VALUES
(1, 'Smartphone', 'Latest 5G Android smartphone', 699.99, 15, 'Electronics', 'https://example.com/images/phone.jpg'),
(2, 'Laptop', 'High-performance laptop for work and gaming', 1199.00, 10, 'Computers', 'https://example.com/images/laptop.jpg'),
(3, 'Headphones', 'Noise-cancelling wireless headphones', 199.00, 25, 'Accessories', 'https://example.com/images/headphones.jpg'),
(4, 'Smart Watch', 'Fitness and sleep tracking smartwatch', 249.50, 30, 'Wearables', 'https://example.com/images/watch.jpg');

-- =======================================
-- ORDERS TABLE INITIAL DATA
-- =======================================
INSERT INTO orders (id, user_id, total_price, status)
VALUES
(1, 2, 898.99, 'PENDING'),
(2, 2, 249.50, 'DELIVERED');
