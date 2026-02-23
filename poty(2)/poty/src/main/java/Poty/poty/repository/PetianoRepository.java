package Poty.poty.repository;

import org.springframework.stereotype.Repository;
import Poty.poty.model.*; // importação que resolve JpaRepo

@Repository
public interface PetianoRepository extends JpaRepository<Petiano, Long>{
    
}
