package Poty.poty.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import Poty.poty.model.*; // importação que resolve JpaRepo
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetianoRepository extends JpaRepository<Petiano, Long>{
    public List<Petiano> findByCurso(String curso);
}
