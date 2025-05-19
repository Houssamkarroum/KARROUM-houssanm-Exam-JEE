package karroum.houssam.exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Professionnel")
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
