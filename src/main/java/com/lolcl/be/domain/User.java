package com.lolcl.be.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String puuid;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;
   
    @Column(columnDefinition = "INT", nullable = false)   
    private int level;

    @Builder
    public User(int id, String puuid, String name, int level) {
        this.id = id;
        this.puuid = puuid;
        this.name = name;
        this.level = level;
    }

}
