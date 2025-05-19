package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.RemboursementDTO;

import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    List<RemboursementDTO> listRemboursementsByCredit(Long creditId);
}
