package com.example.pokemon_comments.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pokemon_comments")
public class PokemonComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pokemon_number")
    private int pokemonNumber;

    private String comment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 생성될 때 자동으로 시간 설정
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // 기본 생성자
    public PokemonComment() {}

    // 생성자
    public PokemonComment(int pokemonNumber, String comment) {
        this.pokemonNumber = pokemonNumber;
        this.comment = comment;
    }

    // Getter/Setter
    public Long getId() {
        return id;
    }

    public int getPokemonNumber() {
        return pokemonNumber;
    }

    public void setPokemonNumber(int pokemonNumber) {
        this.pokemonNumber = pokemonNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}