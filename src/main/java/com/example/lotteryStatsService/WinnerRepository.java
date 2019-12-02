package com.example.lotteryStatsService;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WinnerRepository extends CrudRepository<Winner,Long> {
    List<Winner> findWinnersByDrawId(Long drawId);
}
