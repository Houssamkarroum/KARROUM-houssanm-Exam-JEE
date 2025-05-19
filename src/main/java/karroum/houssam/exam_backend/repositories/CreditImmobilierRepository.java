// CreditImmobilierRepository.java
package karroum.houssam.exam_backend.repositories;

import karroum.houssam.exam_backend.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
}
