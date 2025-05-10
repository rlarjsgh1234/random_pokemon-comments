package com.example.pokemon_comments.repository;

import com.example.pokemon_comments.model.PokemonComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PokemonCommentRepository extends JpaRepository<PokemonComment, Long> {

    // 도감 번호(pokemonNumber)로 댓글 목록을 가져오는 메소드
    List<PokemonComment> findByPokemonNumber(int pokemonNumber);
}