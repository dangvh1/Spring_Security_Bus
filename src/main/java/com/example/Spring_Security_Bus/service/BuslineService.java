package com.example.Spring_Security_Bus.service;

import com.example.Spring_Security_Bus.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Spring_Security_Bus.entity.Busline;
import com.example.Spring_Security_Bus.repository.BuslineIml;


import java.util.List;
import java.util.Optional;

@Service
public class BuslineService  {
    @Autowired
    BuslineIml buslineIml;

    public List<Busline> getListBusline() {
        return buslineIml.findAll();
    }

    public Busline insertBusline(Busline busline) {
        return buslineIml.save(busline);
    }
    public Busline removeBusline(int id){
        Optional<Busline> optional = buslineIml.findById(id);
        if(optional.isPresent()){
            Busline busline = optional.get();
            buslineIml.delete(busline);
            return  busline;
        }else {
            return null;
        }
    }

    public Busline updateBusline(Busline busline) {
        return buslineIml.save(busline);
    }

    public Busline getById(int id){
        return buslineIml.findOneById(id);
    }

}
