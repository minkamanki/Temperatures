package com.mycompany.temperatures.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Point extends AbstractPersistable<Long>{
    public String name;
    public double longitude;
    public double latitude;
    @OneToMany(mappedBy = "point")
    public List<Observation> observations;
}
