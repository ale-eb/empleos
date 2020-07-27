package com.pantera.empleos.repository;

import com.pantera.empleos.domain.Vacant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantRepository extends JpaRepository<Vacant, Long> {
}
