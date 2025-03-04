package org.example.football.service;

import org.example.football.model.match.dto.MatchGetDTO;
import org.example.football.model.match.dto.MatchPostDTO;

import java.util.List;

public interface MatchService {
    MatchGetDTO createMatch(MatchPostDTO dto);
    List<MatchGetDTO> getAllMatches();
    MatchGetDTO getMatchById(Long id);
    MatchGetDTO updateMatch(Long id, MatchPostDTO dto);
    void deleteMatch(Long id);
    MatchGetDTO setMatchScore(Long matchId, String score);
}
