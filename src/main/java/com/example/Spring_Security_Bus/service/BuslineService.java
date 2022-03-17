package com.example.Spring_Security_Bus.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Spring_Security_Bus.entity.Busline;
import com.example.Spring_Security_Bus.repository.BuslineIml;


import java.util.List;


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
    public void removeBusline(int id){
        buslineIml.deleteById(id);
    }

    public Busline updateBusline(Busline busline) {
        return buslineIml.save(busline);
    }

    public Busline getById(int id){
        return buslineIml.findOneById(id);
    }

}
