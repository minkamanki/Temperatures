package com.mycompany.temperatures.service;

import com.mycompany.temperatures.domain.Point;
import com.mycompany.temperatures.repository.PointRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    @Transactional
    public void add(String name, double latitude, double longitude){
        Point point = new Point();
        point.setName(name);
        point.setLatitude(latitude);
        point.setLongitude(longitude);        
        
        pointRepository.save(point);
    }
    
        public List<Point> list() {
        List<Point> points = pointRepository.findAll();
        return points;
    }
}
 