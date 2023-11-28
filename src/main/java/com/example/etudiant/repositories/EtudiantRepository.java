package com.example.etudiant.repositories;

import com.example.etudiant.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    void deleteById(Integer id);
}
