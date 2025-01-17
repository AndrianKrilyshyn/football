-- Додавання команд
INSERT INTO football_team (name, budget, commission_percentage)
VALUES ('Team A', 1000000, 5);

INSERT INTO football_team (name, budget, commission_percentage)
VALUES ('Team B', 500000, 3);

-- Додавання гравців
INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 1', 25, 30, 1);

INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 2', 28, 36, 1);

INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 3', 23, 18, 1);

INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 4', 30, 48, 2);

INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 5', 26, 24, 2);

INSERT INTO player (name, age, experience_months, team_id)
VALUES ('Player 6', 22, 12, 2);
