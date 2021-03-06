package com.mycompany.temperatures.service;

import com.mycompany.temperatures.domain.Observation;
import com.mycompany.temperatures.domain.Point;
import com.mycompany.temperatures.repository.ObservationRepository;
import com.mycompany.temperatures.repository.PointRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;
    @Autowired
    private PointRepository pointRepository;

    @Transactional
    public void add(double temperature, LocalDateTime time, Long pointId) {
        Observation observation = new Observation();
        observation.setTemperature(temperature);
        observation.setTime(time);

        Point point = pointRepository.getOne(pointId);
        observation.setPoint(point);

        point.getObservations().add(observation);

        pointRepository.save(point);
        observationRepository.save(observation);
    }

    public List<Observation> list() {        
        return observationRepository.findAll(PageRequest.of(0, 5, Sort.Direction.DESC, "time")).getContent();
    }

}
