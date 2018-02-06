package com.mycompany.temperatures.domain;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public LocalDate date;
    public LocalTime time;
    @ManyToOne
    public Point point;    
}

