package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Timeslot;
import com.capgemini.molveno.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeslotService {
    @Autowired
    private TimeslotRepository repository;

    public int create(Timeslot timeslot){
        Timeslot created = this.repository.save(timeslot);
        return created.getId();
    }

    public List<Timeslot> all(){
        Iterable<Timeslot> source = this.repository.findAll();
        List<Timeslot> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
        }

    public Timeslot read(final int id) {
        Optional<Timeslot> timeslot = this.repository.findById(id);
        if(timeslot.isPresent()) {
            return timeslot.get();
        }
        return null;
    }

    public Timeslot update(int id, Timeslot changedTimeslot){
        Optional<Timeslot> oldTimeslot = repository.findById(id);
        if(oldTimeslot.isPresent()) {
            if(changedTimeslot.getStartDateTime() != null){
                oldTimeslot.get().setStartDateTime(changedTimeslot.getStartDateTime());
            }if(changedTimeslot.getEndDateTime() != null){
                oldTimeslot.get().setEndDateTime(changedTimeslot.getEndDateTime());
            }
                   }
        return repository.save(oldTimeslot.get());
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }
}
