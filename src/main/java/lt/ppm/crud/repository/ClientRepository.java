package lt.ppm.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ppm.crud.model.ClientEntity;
 
@Repository
public interface ClientRepository
        extends JpaRepository<ClientEntity, Long> {
 
}
