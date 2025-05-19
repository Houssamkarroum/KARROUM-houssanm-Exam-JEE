package karroum.houssam.exam_backend.web;

import karroum.houssam.exam_backend.dtos.RemboursementDTO;
import karroum.houssam.exam_backend.services.RemboursementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
public class RemboursementRestController {

    private final RemboursementService remboursementService;

    public RemboursementRestController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }

    @PostMapping
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return remboursementService.saveRemboursement(remboursementDTO);
    }

    @GetMapping("/byCredit/{creditId}")
    public List<RemboursementDTO> listRemboursementsByCredit(@PathVariable Long creditId) {
        return remboursementService.listRemboursementsByCredit(creditId);
    }
}
