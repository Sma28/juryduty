package com.mps.juryduty.spring.backend;

import java.util.Set;
import java.util.Set;

public class Employee {

    private String rounds;
    private String sets;
    private String juryBoss;
    private Set<String> jury;
    private String contestant;

    public Employee(String rounds, String sets, String juryBoss, Set<String> jury, String contestant) {
        super();
        this.rounds = rounds;
        this.sets = sets;
        this.juryBoss = juryBoss;
        this.jury = jury;
        this.contestant = contestant;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getJuryBoss() {
        return juryBoss;
    }

    public void setJuryBoss(String juryBoss) {
        this.juryBoss = juryBoss;
    }

    public Set<String> getJury() {
        return jury;
    }

    public void setJury(Set<String> jury) {
        this.jury = jury;
    }

    public String getContestant() {
        return contestant;
    }

    public void setContestant(String contestant) {
        this.contestant = contestant;
    }
}
