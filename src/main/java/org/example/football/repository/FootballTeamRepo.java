package org.example.football.repository;

import org.example.football.model.footballTeam.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballTeamRepo extends JpaRepository<FootballTeam, Long> {
}
