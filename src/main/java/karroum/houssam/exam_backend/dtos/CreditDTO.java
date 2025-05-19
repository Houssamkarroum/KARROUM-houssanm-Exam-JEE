package karroum.houssam.exam_backend.dtos;

import karroum.houssam.exam_backend.enums.StatutCredit;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcceptation;
    private Double montant;
    private int dureeRemboursement;
    private Double tauxInteret;
    private Long clientId;
}
