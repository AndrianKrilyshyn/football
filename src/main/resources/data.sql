INSERT INTO football_team (id, name, budget, commission_percentage) VALUES (1, 'Team A', 500000, 5.0);
INSERT INTO football_team (id, name, budget, commission_percentage) VALUES (2, 'Team B', 300000, 3.5);
INSERT INTO football_team (id, name, budget, commission_percentage) VALUES (3, 'Team C', 450000, 4.2);

INSERT INTO player (id, name, age, experience_months, team_id) VALUES (1, 'Player 1', 25, 36, 1);
INSERT INTO player (id, name, age, experience_months, team_id) VALUES (2, 'Player 2', 28, 48, 1);
INSERT INTO player (id, name, age, experience_months, team_id) VALUES (3, 'Player 3', 23, 24, 2);
INSERT INTO player (id, name, age, experience_months, team_id) VALUES (4, 'Player 4', 27, 50, 3);

INSERT INTO football_match (id, home_team_id, away_team_id, location, match_date, score)
VALUES (1, 1, 2, 'Stadium A', '2025-03-10 18:00:00', 'N/A');

INSERT INTO football_match (id, home_team_id, away_team_id, location, match_date, score)
VALUES (2, 2, 3, 'Stadium B', '2025-03-15 20:30:00', 'N/A');

INSERT INTO football_match (id, home_team_id, away_team_id, location, match_date, score)
VALUES (3, 1, 3, 'Stadium C', '2025-03-20 17:00:00', 'N/A');