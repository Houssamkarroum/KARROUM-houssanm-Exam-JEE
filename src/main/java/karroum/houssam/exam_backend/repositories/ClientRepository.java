// ClientRepository.java
package karroum.houssam.exam_backend.repositories;

import karroum.houssam.exam_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
