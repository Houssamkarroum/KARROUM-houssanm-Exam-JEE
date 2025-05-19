package karroum.houssam.exam_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import karroum.houssam.exam_backend.enums.TypeRemboursement;
import lombok.*;

import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private double montant;
    private TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}