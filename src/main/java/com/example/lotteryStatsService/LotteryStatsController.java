package com.example.lotteryStatsService;

import com.google.gson.Gson;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/stats",produces = "application/json")
public class LotteryStatsController {

    private TicketRepository ticketRepository;
    private WinnerRepository winnerRepository;

    public LotteryStatsController(TicketRepository ticketRepository,WinnerRepository winnerRepository) {
        this.ticketRepository = ticketRepository;
        this.winnerRepository = winnerRepository;
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

    @GetMapping("/winnersOfADraw/{drawId}")
    public String winnersOfADraw(@PathVariable("drawId") Long drawId)
    {
        List<Winner> winners = winnerRepository.findWinnersByDrawId(drawId);
        String json = new Gson().toJson(winners);
        return json;
    }
}
