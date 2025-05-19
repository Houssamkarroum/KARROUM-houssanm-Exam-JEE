package karroum.houssam.exam_backend.dtos;

import lombok.Data;

@Data
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}
