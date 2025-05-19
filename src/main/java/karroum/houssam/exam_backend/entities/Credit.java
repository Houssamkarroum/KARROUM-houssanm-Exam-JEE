package karroum.houssam.exam_backend.entities;

import jakarta.persistence.*;
import karroum.houssam.exam_backend.enums.StatutCredit;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_credit")
@Data @NoArgsConstructor
@AllArgsConstructor
public abstract class Credit {
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcceptation;
    private double montant;
    private int duree;
    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}