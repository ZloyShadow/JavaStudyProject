DELETE FROM votes;
DELETE FROM menu_items;
DELETE FROM restaurants;
DELETE FROM Meales;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, role) VALUES
  ('administrator','ADMIN'),
  ('customer1','USER'),
  ('customer2','USER'),
  ('customer3','USER');

INSERT INTO Meales (description, price) VALUES
  ('Sandwitch', 100),
  ('Pasta', 200),
  ('FrenchFries', 50),
  ('ChickenNuggets', 70),
  ('Hinkal', 150),
  ('Meat', 210),
  ('Burger', 90),
  ('Cha-cha', 120),
  ('Vodka', 1000),
  ('Ketchup', 10);

INSERT INTO restaurants (name) VALUES
  ('McDonalds'),
  ('Acha-chacha'),
  ('VodkaPlace'),
  ('KFC'),
  ('Teremok');

INSERT INTO menu_items (Meal_id, restaurant_id, added) VALUES
  (100005, 100015, '2022-01-01'),
  (100006, 100015, '2022-01-01'),
  (100005, 100017, '2022-01-01'),
  (100008, 100017, '2022-01-01'),
  (100005, 100015, '2022-01-02'),
  (100006, 100015, '2022-01-02'),
  (100007, 100017, '2022-01-02'),
  (100008, 100017, '2022-01-02');

INSERT INTO votes (user_id, restaurant_id, taken) VALUES
  (100002, 100017, '2022-01-01 01:01:01'),
  (100003, 100016, '2022-01-01 02:02:02'),
  (100002, 100017, '2022-01-02 01:01:01'),
  (100003, 100018, '2022-01-02 02:02:01'),
  (100002, 100017, '2022-01-03 01:01:01'),
  (100003, 100017, '2022-01-03 02:02:01');