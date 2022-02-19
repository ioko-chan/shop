package com.solomennikova.shop.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByNumber(String number);
    Boolean existsByNumber(String number);
}
