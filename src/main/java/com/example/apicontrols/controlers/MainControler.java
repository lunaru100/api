package com.example.apicontrols.controlers;

import com.example.apicontrols.models.Train;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/firstController")
public class MainControler {
    List<Train> trainList = new ArrayList<>();

    @GetMapping("")
    String displayPageNotFound(){
        return "<h1>Page not found 404!!!<h1>";
    }
    @GetMapping("/int")
    int showInteger(){
        return 111;
    }

    @GetMapping("/addtrain")
    boolean addTrain(){
        Train train = new Train(1,"Warszawa",100);
        trainList.add(train);
        return true;
    }
    @GetMapping("/showtrain")
    List<Train> showTrain(){
        return trainList;
    }

}
