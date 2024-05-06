package com.lolcl.be.service;

import org.springframework.http.ResponseEntity;

import com.lolcl.be.model.AccountDto;
import com.lolcl.be.model.MatchDto;
import com.lolcl.be.model.SummonerDTO;
import com.lolcl.be.model.User;

public interface RiotService 
{
    ResponseEntity<AccountDto> accountInfo(String playername) throws Exception; 
    ResponseEntity<SummonerDTO> summonerInfo(String playername, String region) throws Exception; 
    ResponseEntity<MatchDto> matchInfo(String continent, String matchid) throws Exception; 
    User userInfo(String playername, String region) throws Exception; 
}