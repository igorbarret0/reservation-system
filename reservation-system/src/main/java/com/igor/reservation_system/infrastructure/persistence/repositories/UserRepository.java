package com.igor.reservation_system.infrastructure.persistence.repositories;

import com.igor.reservation_system.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserById(Long id);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

}
