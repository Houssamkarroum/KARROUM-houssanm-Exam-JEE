package karroum.houssam.exam_backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_credit")
public abstract class Credit {
    @Id @GeneratedValue
    private Long id;
    private Date dateDemande;
    private String statut;
    private Date dateAcceptation;
    private double montant;
    private int duree;
    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}