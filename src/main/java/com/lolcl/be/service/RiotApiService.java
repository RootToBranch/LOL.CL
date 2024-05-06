package com.lolcl.be.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lolcl.be.model.AccountDto;
import com.lolcl.be.model.MatchDto;
import com.lolcl.be.model.SummonerDTO;
import com.lolcl.be.model.User;
import com.lolcl.be.service.connect.ConnectApiService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiotApiService implements RiotService 
{

    @Value("${riot.apiKey}") 
    private String restKey;

    @Autowired
    private final ConnectApiService connectApiService;

    MatchDto matchDto;
    AccountDto accountDto;
    SummonerDTO summonerDTO;

    @Override
    public ResponseEntity<AccountDto> accountInfo(String playername) throws UnsupportedEncodingException 
    {
        System.out.println(playername);
        playername = URLDecoder.decode(playername, "UTF-8");
        String[] playernameArr = playername.split("-");
        String url = MessageFormat.format("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/{0}/{1}",
                                    playernameArr[0], playernameArr[1]);
        ResponseEntity<AccountDto> connected = connectApiService.connect(url, accountDto);
        return connected;
    }
    
    @Override
    public ResponseEntity<SummonerDTO> summonerInfo(String puuid, String region) throws UnsupportedEncodingException 
    {
        puuid = URLDecoder.decode(puuid, "UTF-8");
        // region = kr, na1, ...
        String url = MessageFormat.format("https://{0}.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/{1}",
                                    region, puuid);
        ResponseEntity<SummonerDTO> connected = connectApiService.connect(url, summonerDTO);
        return connected;
    }


    @Override
    public ResponseEntity<MatchDto> matchInfo(String region, String matchid) 
    {
        String region_americas[] = {"na1", "br1", "la1", "la2"};
        String region_asia[] = {"jp1, kr"};
        String region_europe[] = {"eun1", "euw1", "tr1", "ru"};
        String region_sea[] = {"oc1", "ph2", "sg2", "th2", "tw2", "vn2"};
        // if(Arrays.asList(continents).contains(region)) break;
        
        boolean americas = Arrays.asList(region_americas).contains(region);
        boolean asia = Arrays.asList(region_asia).contains(region);
        boolean europe = Arrays.asList(region_europe).contains(region);
        // boolean sea = Arrays.asList(region_sea).contains(region);

        String select_region;

        if(americas) select_region = "americas";
        else if(asia) select_region = "asia";
        else if(europe) select_region = "europe";
        else select_region = "sea";

        String URL = MessageFormat.format("https://{0}.api.riotgames.com/lol/match/v5/matches/{1}", select_region, matchid);
        ResponseEntity<MatchDto> connected = connectApiService.connect(URL, matchDto);

        return connected;
    }


    // Unified User Info
    @Override
    public User userInfo(String playername, String region) throws UnsupportedEncodingException
    {
        AccountDto account = this.accountInfo(playername).getBody();
        SummonerDTO summoner = this.summonerInfo(account.puuid(), region).getBody();
        MatchDto match = this.matchInfo(playername, region).getBody();
        
        User user = new User(summoner.id(), summoner.accountId(), summoner.puuid(), account.gameName(), summoner.profileIconId(), summoner.revisionDate(), summoner.summonerLevel(), match);

        return user;
    }
}