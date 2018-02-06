package com.mycompany.temperatures.service;

import com.mycompany.temperatures.repository.ObservationRepository;
import com.mycompany.temperatures.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;
    @Autowired
    private PointRepository pointRepository;


}
