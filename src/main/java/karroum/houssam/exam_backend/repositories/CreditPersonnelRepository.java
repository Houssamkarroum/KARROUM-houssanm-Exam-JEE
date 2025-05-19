// CreditPersonnelRepository.java
package karroum.houssam.exam_backend.repositories;

import karroum.houssam.exam_backend.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {

}
