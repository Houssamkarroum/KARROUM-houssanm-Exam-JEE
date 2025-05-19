package karroum.houssam.exam_backend.dtos;


import karroum.houssam.exam_backend.enums.TypeBien;
import lombok.Data;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}
