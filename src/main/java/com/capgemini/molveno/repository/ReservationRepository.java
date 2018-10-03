package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Customer;
import com.capgemini.molveno.model.Reservation;
import com.capgemini.molveno.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

@Repository
public class ReservationRepository {
    private static int reservationId;
    private Map<Integer, Reservation> reservations = new HashMap<>();

    @Autowired
    private TableService tableService;

    @PostConstruct
    public void addSomeReservationsToGetStarted(){

        /// Create 4 Reservations, Tables and customers.
        for (int i = 1; i < 5; i++){
            Reservation reservation = new Reservation();
            this.save(reservation);
        }
        String customerName = "Customer";
        Customer customer = new Customer();
        customer.setName(customerName);

        for (int i = 1; i < 5; i++){
            customerName += " " + i ;
            this.reservations.get(i).setCustomer(customer);
            this.reservations.get(i).setNumberOfPersons(3);
            this.reservations.get(i).setNumberOfChildSeats(1);
            //this.reservations.get(i).setReservedTable(tableService.findByNumber(i));
            //TODO: IEK: Table api werkend krijgen
        }
     }
    public Reservation save(Reservation reservation){
        if(this.reservations.containsKey(reservation.getId())){
            this.reservations.put(reservation.getId(), reservation);
        } else{
            reservation.setId(++reservationId);
            this.reservations.put(reservation.getId(), reservation);
        }
        return reservation;
    }

    public Collection<Reservation> findAll() { return reservations.values(); }

    public Optional<Reservation> findById(int id) {
        Reservation found = this.reservations.get(id);
        return Optional.of(found);
    }

    public void deleteById(int id) { this.reservations.remove(id); }
}
