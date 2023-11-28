package com.example.etudiant.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class EtudiantRequestDTO {
    private String prenom;
    private String nom;
    private String email;

}
