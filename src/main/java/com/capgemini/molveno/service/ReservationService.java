package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Reservation;
import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.model.TimeSlot;
import com.capgemini.molveno.repository.ReservationRepository;
import com.capgemini.molveno.repository.TableRepository;
import com.capgemini.molveno.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private TableRepository tableRepository;

    public int create(Reservation reservation){
        Reservation created = repository.save(reservation);
        return created.getId();
    }

    public Iterable<Reservation> all() {
        return repository.findAll();
    }

    public Reservation read(final int id) {
        Optional<Reservation> reservation = repository.findById(id);
        if(reservation.isPresent()) {
            return reservation.get();
        }
        return null;
    }

    public List<TimeSlot> availableTimeSlots(LocalDate reservationDate, int numberOfPersons) {
        List<TimeSlot> timeSlots = timeSlotRepository.getTimeSlotList();
        LocalTime startTime;
        LocalTime endTime;

        // Retrieve all reservations on the reservation date
        List<Reservation> reservations = repository.findAllByDate(reservationDate);
        System.out.println("# reserveringen gevonden: " + reservations.size());

        List<Table> allTables = new ArrayList<>();
        for (Table table : tableRepository.findAll()) {
            allTables.add(table);
        }

        // Loop over all time slots and determine the availability per time slot
        for (TimeSlot timeSlot : timeSlots) {
            startTime = LocalTime.of(timeSlot.getStartTime().getHours(), timeSlot.getEndTime().getMinutes());
            endTime = LocalTime.of(timeSlot.getEndTime().getHours(), timeSlot.getEndTime().getMinutes());
            List<Table> availableTables = availableTablesAtTimeSlot(startTime, endTime, reservations, allTables);
            System.out.println("Start: " + startTime + " End: " + endTime + " Capacity: " + countCapacity(availableTables));
            if (countCapacity(availableTables) < numberOfPersons) {
                timeSlot.setAvailable(false);
            }
            else {
                timeSlot.setTables(determineTables(availableTables, numberOfPersons));
            }
        }
        return timeSlots;
    }

    private List<Table> availableTablesAtTimeSlot(LocalTime startTimeSlot, LocalTime endTimeSlot, List<Reservation> reservationsAtDate, List<Table> tables) {
        List<Table> reservedTables = new ArrayList<>();
        List<Table> availableTables = new ArrayList<>();
        for (Reservation reservation : reservationsAtDate) {
            if ((reservation.getStartTime().isAfter(startTimeSlot) && reservation.getStartTime().isBefore(endTimeSlot)) ||
                    (reservation.getStartTime().equals(startTimeSlot) && reservation.getEndTime().equals(endTimeSlot)) ||
                    (reservation.getEndTime().isAfter(startTimeSlot) && reservation.getEndTime().isBefore(endTimeSlot))) {
                for (Table table : reservation.getTables()) {
                    reservedTables.add(table);
                }
            }
        }
        for (Table table : tables) {
            if (!reservedTables.contains(table)) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }

    private int countCapacity(List<Table> tableList) {
        int capacity = 0;
        for (Table table : tableList) {
            capacity += table.getNumberOfPersons();
        }
        return capacity;
    }

    private List<Table> determineTables(List<Table> tables, int numberOfPersons) {
        int peopleToBeSeated = numberOfPersons;
        List<Table> returnList = new ArrayList<>();
        for (Table table : tables) {
            returnList.add(table);
            peopleToBeSeated -= table.getNumberOfPersons();
            if (peopleToBeSeated <= 0) {
                break;
            }
        }
        return returnList;
    }

    public Reservation update(Reservation reservation) { return repository.save(reservation); }

    public void delete(final int id) { repository.deleteById(id); }

}
