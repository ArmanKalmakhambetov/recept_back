INSERT INTO user (login, username, password) VALUES
                                                 ('john_doe', 'John Doe', 'password123'),
                                                 ('jane_smith', 'Jane Smith', 'qwerty456');

INSERT INTO recept_tag (tag_name, is_global, userid) VALUES
                                                      ('Vegetarian', TRUE, 1),
                                                      ('Dessert', FALSE, 2),
                                                      ('Quick', TRUE, 1);

INSERT INTO recept (recept_name, recept_time, recept_portions, recept_description, recept_image, recept_link, userid) VALUES
    ('Pasta Carbonara', 30, 4, 'Classic Italian pasta dish.', 'carbonara.jpg', 'https://example.com/carbonara', 1),
    ('Chocolate Cake', 90, 8, 'Delicious chocolate cake.', 'choc_cake.jpg', 'https://example.com/chocolate_cake', 2);

INSERT INTO recept_ingredient (ing_name, ing_weight, ing_count, recept_id) VALUES
                                                                          ('Spaghetti', 500, NULL, 1),
                                                                          ('Eggs', NULL, 4, 1),
                                                                          ('Parmesan Cheese', 100, NULL, 1),
                                                                          ('Flour', 300, NULL, 2),
                                                                          ('Cocoa Powder', 50, NULL, 2),
                                                                          ('Sugar', 200, NULL, 2);

INSERT INTO recept_tags (recept_id, tag_id) VALUES
                                                (1, 1),
                                                (1, 3),
                                                (2, 2);

