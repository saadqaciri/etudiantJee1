package com.example.etudiant;

import com.example.etudiant.entities.Etudiant;
import com.example.etudiant.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository) {
		return args -> {
			List<Etudiant> etudiantList = List.of(
					Etudiant.builder()
							.prenom("Saad")
							.nom("Qaciri")
							.email("saadqaciri2013@gmail.com")
							.build(),
					Etudiant.builder()
							.prenom("Hicham")
							.nom("Errafik")
							.email("Herrafik1@gmail.com")
							.build(),
					Etudiant.builder()
							.prenom("Salim")
							.nom("Baamyer")
							.email("Baamyer.salim@gmail.com")
							.build()
			);
			etudiantRepository.saveAll(etudiantList);

			List<Etudiant> list = etudiantRepository.findAll();
			for (Etudiant etudiant:list) {
				System.out.println("***********************************");
				System.out.println(etudiant.getPrenom());
				System.out.println(etudiant.getNom());
				System.out.println(etudiant.getEmail());

			}
		};

	}
}