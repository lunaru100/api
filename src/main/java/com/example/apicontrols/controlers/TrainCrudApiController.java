package com.example.apicontrols.controlers;

import com.example.apicontrols.models.Train;
import com.example.apicontrols.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//crud - create read update delete
@RestController
@RequestMapping("api/train")
public class TrainCrudApiController {
    TrainRepository tr;
    ArrayList<Train> trains = new ArrayList<>();

    public TrainCrudApiController(TrainRepository tr) {
        this.tr = tr;
        trains.add(new Train(1,"Warszawa",100));
        trains.add(new Train(2,"Krakow",150));
    }

    @GetMapping("")
    List<Train> giveMeTrains(){
        return tr.getTrains();
    }

    @GetMapping("/{id}")
    ResponseEntity giveMeTrainById(@PathVariable int id){
        Train train = tr.getTrainById(id);
        if(train != null){
            return ResponseEntity.ok().body(train);
        }
        return ResponseEntity.badRequest().body("no such train");
    }

    /*@GetMapping("/addTrain/{number}/{destination}/{price}")
    boolean addTrainBadSolution(@PathVariable int number,@PathVariable String destination,@PathVariable int price){
        trains.add(new Train(number,destination,price));
        return true;
    }*/

    @PostMapping("")
    String addTrain(@RequestBody ArrayList<Train> newTrains){
        for(Train newTrain : newTrains){
            trains.add(newTrain);
        }
        return "udalo sie dodac " + trains.size();
    }

    @DeleteMapping("/{id}")
    String removeTrain(@PathVariable int id){
        if(id < trains.size()){
            trains.remove(id);
            return "train removed";
        }
        else return "removing failed";
    }

    @PutMapping("/{id}")
    String updateTrain(@PathVariable int id,@RequestBody Train train){
        return "todo update train";
    }

    @PutMapping("/create")
    String createTable(){
        tr.createTable();
        return "created table";
    }
}
