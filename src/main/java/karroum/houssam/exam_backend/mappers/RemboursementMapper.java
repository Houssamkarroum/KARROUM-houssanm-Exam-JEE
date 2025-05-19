package karroum.houssam.exam_backend.mappers;

import karroum.houssam.exam_backend.dtos.RemboursementDTO;
import karroum.houssam.exam_backend.entities.Credit;
import karroum.houssam.exam_backend.entities.Remboursement;
import org.springframework.stereotype.Component;

@Component
public class RemboursementMapper {

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        if (remboursement == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        dto.setCreditId(remboursement.getCredit() != null ? remboursement.getCredit().getId() : null);
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto, Credit credit) {
        if (dto == null) return null;
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        remboursement.setCredit(credit);
        return remboursement;
    }
}
