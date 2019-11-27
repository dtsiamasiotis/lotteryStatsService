package com.example.lotteryStatsService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

    @Query("select count(t) from Ticket t where date_played>=:dateplayed and date_played<=:dateplayed+1")
    int findCountOfTicketsByDate(Date dateplayed);
}
