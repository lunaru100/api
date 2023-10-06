package com.example.apicontrols.repositories;

import com.example.apicontrols.models.Train;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainRepository {
    JdbcTemplate jt;
    public TrainRepository(JdbcTemplate jt){
        this.jt = jt;
    }
    public List<Train> getTrains(){
        return jt.query("select * from train", BeanPropertyRowMapper.newInstance(Train.class));
    }
    public Train getTrainById(int id){
        try{
            return jt.queryForObject("select * from train where id= " + id, BeanPropertyRowMapper.newInstance(Train.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }


    }
    public void addTrains(){

    }
    public void updateTrain(){

    }
    public void createTable(){
        jt.update("create table test (id int(4) not null, number int(4) default null, destination varchar(50) default null,ticketPrice int(5) default null)");
    }
}
