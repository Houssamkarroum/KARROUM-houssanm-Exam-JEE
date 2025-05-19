package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.CreditDTO;
import karroum.houssam.exam_backend.entities.Client;
import karroum.houssam.exam_backend.entities.Credit;
import karroum.houssam.exam_backend.mappers.CreditMapper;
import karroum.houssam.exam_backend.repositories.ClientRepository;
import karroum.houssam.exam_backend.repositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(CreditRepository creditRepository, ClientRepository clientRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Credit credit = creditMapper.fromCreditDTO(creditDTO, client);
        credit.setClient(client);
        Credit saved = creditRepository.save(credit);
        return creditMapper.fromCredit(saved);
    }

    @Override
    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new RuntimeException("Credit not found"));
        return creditMapper.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll()
                .stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> listCreditsByClient(Long clientId) {
        return creditRepository.findByClientId(clientId)
                .stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }
}
