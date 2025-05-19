package karroum.houssam.exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Personnel")
public class CreditPersonnel extends Credit {
    private String motif;
}