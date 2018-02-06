package com.mycompany.temperatures.repository;

import com.mycompany.temperatures.domain.Observation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ObservationRepository  extends JpaRepository<Observation, Long> {
    
}
