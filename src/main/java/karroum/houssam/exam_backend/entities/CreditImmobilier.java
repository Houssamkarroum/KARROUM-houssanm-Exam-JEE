package karroum.houssam.exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Immobilier")
public class CreditImmobilier extends Credit {
    private String typeBien;
}