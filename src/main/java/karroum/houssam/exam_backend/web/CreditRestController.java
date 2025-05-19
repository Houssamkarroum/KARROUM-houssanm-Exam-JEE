package karroum.houssam.exam_backend.web;

import karroum.houssam.exam_backend.dtos.CreditDTO;
import karroum.houssam.exam_backend.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/credits")
public class CreditRestController {

    private final CreditService creditService;

    public CreditRestController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public CreditDTO saveCredit(@RequestBody CreditDTO creditDTO) {
        return creditService.saveCredit(creditDTO);
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
        return creditService.getCredit(id);
    }

    @GetMapping
    public List<CreditDTO> listCredits() {
        return creditService.listCredits();
    }

    @GetMapping("/byClient/{clientId}")
    public List<CreditDTO> listCreditsByClient(@PathVariable Long clientId) {
        return creditService.listCreditsByClient(clientId);
    }
}
