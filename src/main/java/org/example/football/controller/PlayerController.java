package org.example.football.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.model.player.dto.PlayerPostDTO;
import org.example.football.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/create/{teamId}")
    public ResponseEntity<PlayerGetDTO> createPlayer(@RequestBody @Valid PlayerPostDTO playerPostDTO, @PathVariable long teamId) {
        PlayerGetDTO playerGetDTO = playerService.createPlayer(playerPostDTO, teamId);
        return new ResponseEntity<>(playerGetDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayerGetDTO> getPlayer(@PathVariable long id) {
        PlayerGetDTO playerGetDTO = playerService.getPlayer(id);
        return new ResponseEntity<>(playerGetDTO, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PlayerGetDTO>> getAllPlayers() {
        List<PlayerGetDTO> playerGetDTOList = playerService.getAllPlayers();
        return new ResponseEntity<>(playerGetDTOList, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayerGetDTO> updatePlayer(@PathVariable long id, @RequestBody @Valid PlayerPostDTO playerPostDTO) {
        PlayerGetDTO playerGetDTO = playerService.updatePlayer(id, playerPostDTO);
        return new ResponseEntity<>(playerGetDTO, HttpStatus.OK);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Player with ID " + id + " has been successfully deleted.");
    }

}
