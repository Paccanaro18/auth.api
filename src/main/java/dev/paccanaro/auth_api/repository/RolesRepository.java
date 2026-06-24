package dev.paccanaro.auth_api.repository;

import dev.paccanaro.auth_api.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
}
