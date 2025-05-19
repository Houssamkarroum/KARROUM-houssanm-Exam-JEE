package karroum.houssam.exam_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Remboursement {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private double montant;
    private String type;

    @ManyToOne
    private Credit credit;
}