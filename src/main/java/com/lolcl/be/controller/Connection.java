package com.lolcl.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lolcl.be.model.AccountDto;
import com.lolcl.be.model.MatchDto;
import com.lolcl.be.model.User;
import com.lolcl.be.service.RiotService;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class Connection {

    @Value("${riot.apiKey}") 
    String envValue;

    @Autowired
    private RiotService riotService;

    @GetMapping("/v1/account/{region}/{playername}")
    public ResponseEntity<AccountDto> accountInfo(@PathVariable String playername, @PathVariable String region) throws Exception 
    {
        return riotService.accountInfo(playername);
    }

    @GetMapping("/lol/match/v5/matches/{region}/{matchid}")
    public ResponseEntity<MatchDto> matchDataInfo(@PathVariable String region, @PathVariable String matchid) throws Exception 
    {
        return riotService.matchInfo(region, matchid);
    }

    @GetMapping("/lol/user/{region}/{playername}")
    public User userInfo(String playername, String region) throws Exception 
    {
        return riotService.userInfo(playername, region);
    }



}