package com.juan.springboot.bean;

public class Room {
    private int id;
    private int room;
    private int weight;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room=" + room +
                ", weight=" + weight +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
