package org.ticketsBooking.entities;

import java.util.Date;

public class Tickets {
    private String ticketsId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    public Tickets(String ticketsId, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.ticketsId = ticketsId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }
    public String getTicketsInfo(){
        return String.format("Tickets Id :- %s belongs to :- %s from :- %s to :- %s on %s", ticketsId,userId,source,destination,dateOfTravel);
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
