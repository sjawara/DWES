/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ioc.daw.user;

import java.sql.Timestamp;

/**
 *
 * @author alumne_2n
 */
public class User {

private int userId;
private String username;
private String name;
private String email;
private int rank;
private Timestamp createdOn;
private boolean active;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(int userId, String username, String name, String email, int rank, Timestamp createdOn, boolean active) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.email = email;
        this.rank = rank;
        this.createdOn = createdOn;
        this.active = active;
    }



}

