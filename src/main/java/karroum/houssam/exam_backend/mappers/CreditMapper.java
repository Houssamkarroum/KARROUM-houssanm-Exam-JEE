package karroum.houssam.exam_backend.mappers;

import karroum.houssam.exam_backend.dtos.CreditDTO;
import karroum.houssam.exam_backend.dtos.CreditImmobilierDTO;
import karroum.houssam.exam_backend.dtos.CreditPersonnelDTO;
import karroum.houssam.exam_backend.dtos.CreditProfessionnelDTO;
import karroum.houssam.exam_backend.entities.Client;
import karroum.houssam.exam_backend.entities.Credit;
import karroum.houssam.exam_backend.entities.CreditImmobilier;
import karroum.houssam.exam_backend.entities.CreditPersonnel;
import karroum.houssam.exam_backend.entities.CreditProfessionnel;
import org.springframework.stereotype.Component;

@Component
public class CreditMapper {

    public CreditDTO fromCredit(Credit credit) {
        if (credit == null) return null;
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient() != null ? credit.getClient().getId() : null);
        return dto;
    }

    public Credit fromCreditDTO(CreditDTO dto, Client client) {
        if (dto == null) return null;

        // Create the appropriate concrete Credit instance based on the DTO type
        Credit credit;
        if (dto instanceof CreditPersonnelDTO) {
            CreditPersonnel creditPersonnel = new CreditPersonnel();
            creditPersonnel.setMotif(((CreditPersonnelDTO) dto).getMotif());
            credit = creditPersonnel;
        } else if (dto instanceof CreditImmobilierDTO) {
            CreditImmobilier creditImmobilier = new CreditImmobilier();
            creditImmobilier.setTypeBien(((CreditImmobilierDTO) dto).getTypeBien().toString());
            credit = creditImmobilier;
        } else if (dto instanceof CreditProfessionnelDTO) {
            CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
            creditProfessionnel.setMotif(((CreditProfessionnelDTO) dto).getMotif());
            creditProfessionnel.setRaisonSociale(((CreditProfessionnelDTO) dto).getRaisonSociale());
            credit = creditProfessionnel;
        } else {
            // Default to CreditPersonnel if no specific type is provided
            credit = new CreditPersonnel();
        }

        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcceptation(dto.getDateAcceptation());
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setClient(client);
        return credit;
    }
}
