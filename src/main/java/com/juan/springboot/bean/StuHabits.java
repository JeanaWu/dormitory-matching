package com.juan.springboot.bean;

public class StuHabits {
    private Integer id;
    private Integer slpTime;
    private Integer gupTime;
    private Integer slpNoisy;
    private Integer slpHabits;
    private Integer clean;
    private Integer games;
    private Integer atmos;
    private Integer characters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlpTime() {
        return slpTime;
    }

    public void setSlpTime(Integer slpTime) {
        this.slpTime = slpTime;
    }

    public Integer getGupTime() {
        return gupTime;
    }

    public void setGupTime(Integer gupTime) {
        this.gupTime = gupTime;
    }

    public Integer getSlpNoisy() {
        return slpNoisy;
    }

    public void setSlpNoisy(Integer slpNoisy) {
        this.slpNoisy = slpNoisy;
    }

    public Integer getSlpHabits() {
        return slpHabits;
    }

    public void setSlpHabits(Integer slpHabits) {
        this.slpHabits = slpHabits;
    }

    public Integer getClean() {
        return clean;
    }

    public void setClean(Integer clean) {
        this.clean = clean;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getAtmos() {
        return atmos;
    }

    public void setAtmos(Integer atmos) {
        this.atmos = atmos;
    }

    public Integer getCharacters() {
        return characters;
    }

    public void setCharacters(Integer characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "StuHabits{" +
                "id=" + id +
                ", slpTime=" + slpTime +
                ", gupTime=" + gupTime +
                ", slpNoisy=" + slpNoisy +
                ", slpHabits=" + slpHabits +
                ", clean=" + clean +
                ", games=" + games +
                ", atmos=" + atmos +
                ", characters=" + characters +
                '}';
    }
}
