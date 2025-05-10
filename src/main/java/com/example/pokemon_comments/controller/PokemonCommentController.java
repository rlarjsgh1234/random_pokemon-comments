package com.example.pokemon_comments.controller;

import com.example.pokemon_comments.model.PokemonComment;
import com.example.pokemon_comments.repository.PokemonCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*") // 프론트엔드와 연동 시 CORS 문제 방지
public class PokemonCommentController {


    @Autowired
    private PokemonCommentRepository commentRepository;

    // 댓글 저장 (POST)
    @PostMapping
    public PokemonComment createComment(@RequestBody PokemonComment comment) {
        return commentRepository.save(comment);
    }

    // 포켓몬 번호로 댓글 조회 (GET)
    @GetMapping("/{pokemonNumber}")
    public List<PokemonComment> getCommentsByPokemonNumber(@PathVariable int pokemonNumber) {
        return commentRepository.findByPokemonNumber(pokemonNumber);
    }
}