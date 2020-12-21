package com.omi.demo.repository;

import com.omi.demo.models.EnumRole;
import com.omi.demo.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(EnumRole name);
}
