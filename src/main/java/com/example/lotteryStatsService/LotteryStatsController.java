package com.example.lotteryStatsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path="/stats",produces = "application/json")
public class LotteryStatsController {

    private TicketRepository ticketRepository;

    public LotteryStatsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/test/{date}")
    public String testGet(@PathVariable("date") Date d)
    {
        return String.valueOf(ticketRepository.findCountOfTicketsByDate(d));
    }
}
