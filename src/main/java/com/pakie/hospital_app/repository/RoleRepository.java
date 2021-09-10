package com.pakie.hospital_app.repository;

import com.pakie.hospital_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
