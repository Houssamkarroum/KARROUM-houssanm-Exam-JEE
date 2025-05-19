package karroum.houssam.exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("Immobilier")
@Data
@NoArgsConstructor @AllArgsConstructor
public class CreditImmobilier extends Credit {
    private String typeBien;
}