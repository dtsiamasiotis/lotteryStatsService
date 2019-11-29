package com.example.lotteryStatsService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.time.LocalDate;

@RestController
@RequestMapping(path="/stats",produces = "application/json")
public class LotteryStatsController {

    private TicketRepository ticketRepository;

    public LotteryStatsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/numberOfTicketsByDate/{date}")
    public int numberOfTicketsByDate(@PathVariable("date") @DateTimeFormat(pattern="ddMMyyyy") LocalDate minlimit)
    {
        LocalDate maxlimit = minlimit.plusDays(1);
        return ticketRepository.findTicketsByValidIsTrueAndDatePlayedBetween(minlimit,maxlimit).size();
    }

    @GetMapping("/numberOfTicketsInADraw/{drawId}")
    public int numberOfTicketsInADraw(@PathVariable("drawId") Long drawId)
    {
        return ticketRepository.findTicketsByDrawIdAndValidIsTrue(drawId).size();
    }
}
