package com.example.lotteryStatsService;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

    //@Query(value = "select count(*) from tickets where date_played>:minlimit and date_played<:maxlimit",nativeQuery = true)
    List<Ticket> findTicketsByValidIsTrueAndDatePlayedBetween(LocalDate minlimit,LocalDate maxlimit);

    List<Ticket> findTicketsByDrawIdAndValidIsTrue(Long drawId);

}
