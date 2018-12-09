package com.example.demo.repositories;

import com.example.demo.entities.BrowserStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface BrowserRepo extends CrudRepository<BrowserStats, Long>{
    @Query(value="SELECT browser, count(browser) as 'summa' FROM browserstats WHERE uri NOT LIKE '%static%' AND uri NOT LIKE '%favicon%' GROUP BY browser ORDER BY summa DESC limit 1", nativeQuery = true)
    Map<String, Integer> findTopBrowser();

    @Query(value="SELECT os, count(os) as 'ossumma' FROM browserstats WHERE uri NOT LIKE '%static%' AND uri NOT LIKE '%favicon%' GROUP BY os ORDER BY ossumma DESC limit 1", nativeQuery = true)
    Map<String, Integer> findTopos();

    @Query(value="SELECT uri, count(uri) as 'urisumma' FROM browserstats WHERE uri NOT LIKE '%static%' AND uri NOT LIKE '%favicon%' GROUP BY uri ORDER BY urisumma DESC limit 1", nativeQuery = true)
    Map<String, Integer> findTopUri();





}