package com.example.lotteryStatsService;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String numbers;

    @Column(name = "date_played")
    private LocalDate datePlayed;

    private boolean valid;

    @Column(name = "ticket_id")
    private long ticketId;

    @Column(name = "draw_id")
    private long drawId;
}
