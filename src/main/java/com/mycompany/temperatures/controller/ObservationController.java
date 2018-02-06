package com.mycompany.temperatures.controller;

import com.mycompany.temperatures.domain.Point;
import com.mycompany.temperatures.service.ObservationService;
import com.mycompany.temperatures.service.PointService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.PostConstruct;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ObservationController {

    @Autowired
    private ObservationService observationService;
    @Autowired
    private PointService pointService;

    @PostConstruct
    public void construct() {
        pointService.add("Tokio", 35.6584421, 139.7328635);
        pointService.add("Helsinki", 60.1697530, 24.9490830);
        pointService.add("New York", 40.7406905, -73.9938438);
        pointService.add("Amsterdam", 60.1697530, 24.9490830);
        pointService.add("Dubai", 25.092535, 55.1562243);

    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("points", pointService.list());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam double temperature, @RequestParam LocalDate date, @RequestParam LocalTime time, @RequestParam Long pointId) throws IOException { // 
        observationService.add(temperature, date, time, pointId); //
        return "redirect:/articles";
    }
}
