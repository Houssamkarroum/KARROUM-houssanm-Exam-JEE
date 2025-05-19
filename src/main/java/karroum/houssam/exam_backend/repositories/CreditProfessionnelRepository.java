// CreditProfessionnelRepository.java
package karroum.houssam.exam_backend.repositories;

import karroum.houssam.exam_backend.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
}
