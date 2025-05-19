package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.RemboursementDTO;
import karroum.houssam.exam_backend.entities.Credit;
import karroum.houssam.exam_backend.entities.Remboursement;
import karroum.houssam.exam_backend.mappers.RemboursementMapper;
import karroum.houssam.exam_backend.repositories.CreditRepository;
import karroum.houssam.exam_backend.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemboursementServiceImpl implements RemboursementService {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    public RemboursementServiceImpl(RemboursementRepository remboursementRepository,
                                    CreditRepository creditRepository,
                                    RemboursementMapper remboursementMapper) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        Remboursement remboursement = remboursementMapper.fromRemboursementDTO(remboursementDTO, credit);
        remboursement.setCredit(credit);
        Remboursement saved = remboursementRepository.save(remboursement);
        return remboursementMapper.fromRemboursement(saved);
    }

    @Override
    public List<RemboursementDTO> listRemboursementsByCredit(Long creditId) {
        return remboursementRepository.findByCreditId(creditId)
                .stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }
}
