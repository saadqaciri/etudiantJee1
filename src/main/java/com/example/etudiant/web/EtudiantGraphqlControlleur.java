package com.example.etudiant.web;

import java.util.List;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.entities.Etudiant;
import com.example.etudiant.repositories.EtudiantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EtudiantGraphqlControlleur {
    @Autowired
    EtudiantRepository etudiantRepository;

    @QueryMapping
    public List<Etudiant> listerEtudiants(){ return etudiantRepository.findAll();}
    @QueryMapping
    public Etudiant etudiantById(@Argument Integer id){ return etudiantRepository.findById(id).get();}
    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantRequestDTO etudiantDTO){
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        return etudiantRepository.save(etudiant);
    }
}
