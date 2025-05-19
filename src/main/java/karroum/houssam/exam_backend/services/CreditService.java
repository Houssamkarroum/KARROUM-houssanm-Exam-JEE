package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.CreditDTO;

import java.util.List;

public interface CreditService {
    CreditDTO saveCredit(CreditDTO creditDTO);
    CreditDTO getCredit(Long id);
    List<CreditDTO> listCredits();
    List<CreditDTO> listCreditsByClient(Long clientId);
}
