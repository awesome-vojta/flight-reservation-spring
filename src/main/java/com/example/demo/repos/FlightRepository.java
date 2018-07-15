package com.example.demo.repos;

import com.example.demo.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

//    @Query("from Flight where departureCity =:departureCity" +
//            " and arrivalCity =:arrivalCity" +
//            " and dateOfDeparture =:dateOfDeparture")
    @Query("select f from Flight f where f.departureCity = :#{#from}")
    List<Flight> findFlights(@Param("departureCity") String from,
                             @Param("arrivalCity") String to,
                             @Param("dateOfDeparture") Date departureDate);

//    List<Flight>findFLightsByArrivalCity(String arrival_city);


//    List<Flight> findByDepartureCityaAndArrivalCityAndAndDateOfDeparture(String DepartureCity,
//                                                                         String ArrivalCity,
//                                                                         Date DateOfDeparture);

}
