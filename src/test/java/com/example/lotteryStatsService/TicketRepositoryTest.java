package com.example.lotteryStatsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketRepositoryTest {
    @Mock
    private TicketRepository ticketRepository;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindCountOfTicketsByDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateplayed = format.parse("2019-11-21");
        int count = ticketRepository.findCountOfTicketsByDate(dateplayed);
        System.out.println(count);
    }
}
