package com.example.etudiant.service;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.dto.EtudiantResponseDTO;

import java.util.List;

public interface EtudiantServiceInterface {
    //POST
    public void add(EtudiantRequestDTO etudiantRequestDTO);
    //Get
    public List<EtudiantResponseDTO> listerEtudiants();
    //GetById
    public EtudiantResponseDTO etudiantById(Integer id);
    //put
    public void update(Integer id, EtudiantRequestDTO etudiantRequestDTO);
    //delete
    public void supprimer(Integer id);



}
