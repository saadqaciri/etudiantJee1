package com.example.etudiant.mapper;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.dto.EtudiantResponseDTO;
import com.example.etudiant.entities.Etudiant;

public interface EtudiantInterfaceMap {
    public Etudiant etudiantRequestDTO2Etudiant(EtudiantRequestDTO etudiantRequestDTO);
    public EtudiantResponseDTO etudiantResponseDTO2Etudiant(Etudiant etudiant);
}

