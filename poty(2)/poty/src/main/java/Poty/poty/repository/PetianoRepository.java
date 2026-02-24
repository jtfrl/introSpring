package Poty.poty.repository;

import org.springframework.stereotype.Repository;
import Poty.poty.model.*; // importação que resolve JpaRepo
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetianoRepository extends JpaRepository<Petiano, Long>{
    
}
