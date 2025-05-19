package karroum.houssam.exam_backend;

import karroum.houssam.exam_backend.dtos.ClientDTO;
import karroum.houssam.exam_backend.dtos.CreditDTO;
import karroum.houssam.exam_backend.dtos.RemboursementDTO;
import karroum.houssam.exam_backend.enums.StatutCredit;
import karroum.houssam.exam_backend.enums.TypeRemboursement;
import karroum.houssam.exam_backend.services.ClientService;
import karroum.houssam.exam_backend.services.CreditService;
import karroum.houssam.exam_backend.services.RemboursementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import java.util.Date;
@SpringBootApplication
public class ExamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ClientService clientService,
                                   CreditService creditService,
                                   RemboursementService remboursementService) {
        return args -> {
            Random random = new Random();

            // Types possibles
            List<String> statuts = List.of("EN_COURS", "ACCEPTE", "REJETE");
            List<String> typesRemb = List.of("MENSUALITE", "ANTICIPE");

            // Création de clients
            Stream.of("Houssam", "Yassine", "Salma", "Mohamed", "Amina").forEach(name -> {
                ClientDTO clientDTO = new ClientDTO();
                clientDTO.setNom(name);
                clientDTO.setEmail(name.toLowerCase() + "@gmail.com");
                clientService.saveClient(clientDTO);
            });

            // Création de crédits + remboursements
            clientService.getAllClients().forEach(client -> {
                int numCredits = 1 + random.nextInt(2); // 1 ou 2 crédits
                for (int i = 0; i < numCredits; i++) {
                    CreditDTO creditDTO = new CreditDTO();
                    creditDTO.setDateDemande(Date.from(Instant.now()));
                    creditDTO.setStatut(StatutCredit.valueOf(statuts.get(random.nextInt(statuts.size()))));
                    creditDTO.setDateAcceptation(Date.from(Instant.now()));
                    creditDTO.setMontant(50.20+random.nextInt(5000));
                    creditDTO.setDureeRemboursement(6 + random.nextInt(24)); // 6 à 30 mois
                    creditDTO.setTauxInteret(2.0 + random.nextDouble() * 4.0); // 2.0% à 6.0%
                    creditDTO.setClientId(client.getId());

                    CreditDTO savedCredit = creditService.saveCredit(creditDTO);

                    // Créer des remboursements aléatoires
                    int nbRembs = 1 + random.nextInt(4); // entre 1 et 4 remboursements
                    for (int j = 0; j < nbRembs; j++) {
                        RemboursementDTO remboursementDTO = new RemboursementDTO();
                        remboursementDTO.setDate(Date.from(Instant.now()));
                        remboursementDTO.setMontant(creditDTO.getMontant() / creditDTO.getDureeRemboursement());
                        remboursementDTO.setType(TypeRemboursement.valueOf(typesRemb.get(random.nextInt(typesRemb.size()))));
                        remboursementDTO.setCreditId(savedCredit.getId());
                        remboursementService.saveRemboursement(remboursementDTO);
                    }
                }
            });

            System.out.println("✅ Données initialisées aléatoirement avec succès.");
        };
    }
}
