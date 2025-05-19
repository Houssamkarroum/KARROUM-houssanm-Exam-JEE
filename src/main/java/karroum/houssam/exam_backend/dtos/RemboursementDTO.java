package karroum.houssam.exam_backend.dtos;

import karroum.houssam.exam_backend.enums.TypeRemboursement;

import java.time.LocalDate;

public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private Double montant;
    private TypeRemboursement type;
    private Long creditId;
}
