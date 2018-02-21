package com.mycompany.temperatures.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Observation extends AbstractPersistable<Long>{
    public double temperature;
    public LocalDateTime time;
    @ManyToOne
    public Point point;    
}

