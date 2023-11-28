package com.example.etudiant.mapper;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.dto.EtudiantResponseDTO;
import com.example.etudiant.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EtudiantInterfaceMapImpl implements EtudiantInterfaceMap {
    @Override
    public Etudiant etudiantRequestDTO2Etudiant(EtudiantRequestDTO etudiantRequestDTO){
        Etudiant etudiant = new Etudiant();

        etudiant.setPrenom(etudiantRequestDTO.getPrenom());
        etudiant.setNom(etudiantRequestDTO.getNom());
        etudiant.setEmail(etudiantRequestDTO.getEmail());
        return etudiant;
    }

    @Override
    public EtudiantResponseDTO etudiantResponseDTO2Etudiant(Etudiant etudiant){
        EtudiantResponseDTO etudiantResponseDTO = new EtudiantResponseDTO();
        BeanUtils.copyProperties(etudiant, etudiantResponseDTO);
        return etudiantResponseDTO;
    }

}
