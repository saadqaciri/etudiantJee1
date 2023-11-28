package com.example.etudiant.web;

import com.example.etudiant.dto.EtudiantRequestDTO;
import com.example.etudiant.entities.Etudiant;
import com.example.etudiant.repositories.EtudiantRepository;
import com.example.etudiant.service.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EtudiantRestController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantServiceInterface etudiantServiceInterface;

    @GetMapping("/etudiants")
    public List<Etudiant> etudiantList(){ return etudiantRepository.findAll(); }
    @GetMapping("/etudiants/{id}")
    public Etudiant etudiantById(@PathVariable ("id") Integer id){
        return etudiantRepository.findById(id).get();
    }
    @PutMapping("/etudiants/{id}")
    public void save(@PathVariable("id") Integer id, @RequestBody EtudiantRequestDTO etudiantRequestDTO){
        etudiantServiceInterface.update(id, etudiantRequestDTO);
    }
    @PostMapping("/etudiants")
    public void save(@RequestBody EtudiantRequestDTO etudiantRequestDTO){
        etudiantServiceInterface.add(etudiantRequestDTO);
    }
    @DeleteMapping("/etudiants/{id}")
    public void supprimer(@PathVariable("id") Integer id){
        etudiantServiceInterface.supprimer(id);
    }
}
