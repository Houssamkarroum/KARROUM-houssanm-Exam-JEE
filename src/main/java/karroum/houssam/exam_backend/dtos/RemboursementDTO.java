package karroum.houssam.exam_backend.dtos;

import karroum.houssam.exam_backend.enums.TypeRemboursement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private TypeRemboursement type;
    private Long creditId;
}
