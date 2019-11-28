package com.example.lotteryStatsService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

    @Query(value = "select count(*) from tickets where date_played>:minlimit and date_played<:maxlimit",nativeQuery = true)
    int findCountOfTicketsByDate(LocalDate minlimit,LocalDate maxlimit);
}
