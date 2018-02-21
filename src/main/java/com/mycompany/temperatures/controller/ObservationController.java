package com.mycompany.temperatures.controller;

import com.mycompany.temperatures.domain.Point;
import com.mycompany.temperatures.service.ObservationService;
import com.mycompany.temperatures.service.PointService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.PostConstruct;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("*")
public class ObservationController {

    @Autowired
    private ObservationService observationService;
    @Autowired
    private PointService pointService;
    
    @PostConstruct
    public void construct() {
        if (pointService.isEmpty()) {
            pointService.add("Tokio", 35.6584421, 139.7328635);
            pointService.add("Helsinki", 60.1697530, 24.9490830);
            pointService.add("New York", 40.7406905, -73.9938438);
            pointService.add("Amsterdam", 60.1697530, 24.9490830);
            pointService.add("Dubai", 25.092535, 55.1562243);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("points", pointService.list());
        model.addAttribute("observations", observationService.list());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    public String add(@RequestParam double temperature, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time, @RequestParam Long pointId) throws IOException { // 
        observationService.add(temperature, time, pointId); //
        return "redirect:/";
    }

    @RequestMapping(value = "/{pointId}", method = RequestMethod.GET)
    public String findObsevationsToOnePoint(Model model, @PathVariable Long pointId) {
        model.addAttribute("point", pointService.findById(pointId));
        model.addAttribute("points", pointService.list());
        return "index";
    }

}
