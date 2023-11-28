package com.example.etudiant.service;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.dto.EtudiantResponseDTO;
import com.example.etudiant.entities.Etudiant;
import com.example.etudiant.mapper.EtudiantInterfaceMap;
import com.example.etudiant.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class EtudiantServiceInterfaceImpl implements  EtudiantServiceInterface {
    //POST
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EtudiantInterfaceMap etudiantInterfaceMap;
    @Override
    public void add(EtudiantRequestDTO etudiantRequestDTO) {
        Etudiant etudiant = new Etudiant();
        etudiant = etudiantInterfaceMap.etudiantRequestDTO2Etudiant(etudiantRequestDTO);
        etudiantRepository.save(etudiant);
    }
    //Get
    public List<EtudiantResponseDTO> listerEtudiants() {
        List<Etudiant> liste = new ArrayList<Etudiant>();
        liste = etudiantRepository.findAll();
        List<EtudiantResponseDTO> list = new ArrayList<EtudiantResponseDTO>();
        for (Etudiant etudiant:liste){
            EtudiantResponseDTO etudiantResponseDTO = new EtudiantResponseDTO();
            etudiantResponseDTO = etudiantInterfaceMap.etudiantResponseDTO2Etudiant(etudiant);
            list.add(etudiantResponseDTO);
        }
        return list;
    }
    //GetById
    public EtudiantResponseDTO etudiantById(Integer id){
        Etudiant etudiant = etudiantRepository.findById(id).get();

        EtudiantResponseDTO etudiantResponseDTO = new EtudiantResponseDTO();
        etudiantResponseDTO = etudiantInterfaceMap.etudiantResponseDTO2Etudiant(etudiant);
        return etudiantResponseDTO;

    }
    //put
    public void update(Integer id, EtudiantRequestDTO etudiantRequestDTO){
        Etudiant etudiant = etudiantRepository.findById(id).get();
        if(etudiantRequestDTO.getPrenom() != null) etudiant.setPrenom(etudiantRequestDTO.getPrenom());
        if(etudiantRequestDTO.getNom() != null) etudiant.setNom(etudiantRequestDTO.getNom());
        if(etudiantRequestDTO.getEmail() != null) etudiant.setEmail(etudiantRequestDTO.getEmail());

        etudiantRepository.save(etudiant);
    }
    //delete
    public void supprimer(Integer id){
        etudiantRepository.deleteById(id);
    }

}
