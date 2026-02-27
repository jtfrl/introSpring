package com.restaurante.restaurante.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurante.restaurante.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

    boolean existByUsername(String userName);
    
}
