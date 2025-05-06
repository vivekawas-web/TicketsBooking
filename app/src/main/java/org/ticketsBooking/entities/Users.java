package org.ticketsBooking.entities;

import java.util.List;

public class Users {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Tickets> ticketsBocked;
    private String userId;

    public Users(String name, String password, String hashedPassword, List<Tickets> ticketsBocked, String userId) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketsBocked = ticketsBocked;
        this.userId = userId;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Tickets> getTicketsBocked() {
        return ticketsBocked;
    }

    public String getUserId() {
        return userId;
    }

    public void printTickets() {
        for (int i = 0; i < ticketsBocked.size(); i++) {
            System.out.println(ticketsBocked.get(i).getTicketsInfo());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public void setTicketsBocked(List<Tickets> ticketsBocked){
        this.ticketsBocked=ticketsBocked;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
}
