package karroum.houssam.exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("Personnel")
@Data @NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {
    private String motif;
}