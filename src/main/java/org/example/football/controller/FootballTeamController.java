package org.example.football.controller;

import lombok.RequiredArgsConstructor;
import org.example.football.model.footballTeam.dto.FootballTeamGetDTO;
import org.example.football.model.footballTeam.dto.FootballTeamPostDTO;
import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.service.FootballTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
public class FootballTeamController {
    private final FootballTeamService footballTeamService;

    @PostMapping("/create")
    public ResponseEntity<FootballTeamGetDTO> createFootballTeam(@RequestBody FootballTeamPostDTO footballTeamPostDTO) {
        FootballTeamGetDTO footballTeamGetDTO = footballTeamService.createFootballTeam(footballTeamPostDTO);
        return new ResponseEntity<>(footballTeamGetDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballTeamGetDTO> getFootballTeamById(@PathVariable long id) {
            FootballTeamGetDTO footballTeamGetDTO = footballTeamService.getFootballTeam(id);
            return new ResponseEntity<>(footballTeamGetDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FootballTeamGetDTO>> getAllFootballTeams() {
        List<FootballTeamGetDTO> listFootballTeamGetDTO = footballTeamService.getAllFootballTeams();
        return new ResponseEntity<>(listFootballTeamGetDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<FootballTeamGetDTO> updateFootballTeam(@PathVariable long id, @RequestBody FootballTeamPostDTO footballTeamPostDTO) {
        FootballTeamGetDTO footballTeamGetDTO = footballTeamService.updateFootballTeam(id, footballTeamPostDTO);
        return new ResponseEntity<>(footballTeamGetDTO, HttpStatus.OK);
    }

    @PostMapping("/del/{id}")
    public ResponseEntity<String> deleteFootballTeam(@PathVariable long id) {
        footballTeamService.deleteFootballTeam(id);
        return ResponseEntity.ok("Football team with ID " + id + " has been successfully deleted.");
    }
    @PostMapping("/transfer/{playerId}/{newTeamId}")
    public ResponseEntity<PlayerGetDTO> transferPlayer(@PathVariable long playerId, @PathVariable long newTeamId) {
        PlayerGetDTO playerGetDTO = footballTeamService.transferPlayer(playerId, newTeamId);
        return new ResponseEntity<>(playerGetDTO, HttpStatus.OK);
    }

}
