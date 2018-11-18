package com.nstanogias.knapsack.repository;

import com.nstanogias.knapsack.model.Role;
import com.nstanogias.knapsack.model.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by nickstanogias on 17/11/18.
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
