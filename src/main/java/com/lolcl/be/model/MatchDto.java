package com.lolcl.be.model;

import java.util.List;

import lombok.Builder;

@Builder
public record MatchDto(
    MetadataDto metadata,
    InfoDto info
) 
{
    public record MetadataDto(
        String dataVersion,
        String matchId,
        List<String> participants
    ) {}
    public record InfoDto(
        long gameCreation,
        long gameDuration,
        long gameEndTimestamp,
        String gameMode,
        String gameName,
        long gameStartTimestamp,
        String gameType,
        String gameVersion,
        int mapId,
        List<ParticipantDto> participants,
        List<TeamDto> teams
    ) 
    {
        public record ParticipantDto(
            long kills,
            long assists,
            long deaths,
            long baronKills,
            long dragonKills,
            long championId,
            long champLevel,
            long champExperience,
            long damageDealtToBuildings,
            long damageDealtToObjectives,
            long damageDealtToTurrets,
            long damageSelfMitigated,
            long goldEarned,
            long goldSpent,
            long item0,
            long item1,
            long item2,
            long item3,
            long item4,
            long item5,
            long item6,
            Perks perks
        ) 
        {
            public record Perks(
                List<Styles> styles
            ) 
            {
                public record Styles(
                    String description,
                    List<Selections> selections,
                    long style
                )
                {
                    public record Selections(
                        long perk,
                        long var1,
                        long var2,
                        long var3
                    ) {}
                }
            }
        }
        public record TeamDto(
            List<BanDto> bans,
            ObjectivesDto Objectives,
            int teamid,
            boolean win
        )
        {
            public record BanDto(
                int championId,
                int pickTurn
            ){}
            public record ObjectivesDto(
                ObjectiveDto baron,
                ObjectiveDto champion,
                ObjectiveDto dragon,
                ObjectiveDto inhibitor,
                ObjectiveDto riftHerald,
                ObjectiveDto tower
            )
            {
                public record ObjectiveDto(
                    boolean first,
                    int kills
                ) {}
            }
        }
    }   
}

