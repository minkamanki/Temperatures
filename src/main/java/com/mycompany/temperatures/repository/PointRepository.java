package com.mycompany.temperatures.repository;

import com.mycompany.temperatures.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository  extends JpaRepository<Point, Long> {
    
}
