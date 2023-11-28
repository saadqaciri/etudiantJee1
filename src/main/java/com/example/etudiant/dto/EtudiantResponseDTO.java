package com.example.etudiant.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class EtudiantResponseDTO {
    private Integer id;
    private String prenom;
    private String nom;
    private String email;
}
