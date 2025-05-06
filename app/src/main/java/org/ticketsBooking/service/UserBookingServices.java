package org.ticketsBooking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketsBooking.entities.Train;
import org.ticketsBooking.entities.Users;
import org.ticketsBooking.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserBookingServices {
    private Users user; // data structure already made so we will use this
    private List<Users> userList;
    private static final String USERS_PATH="app/src/main/java/org/ticketsBooking/localdb/Users.json";
    private  ObjectMapper objectMapper=new ObjectMapper();
    public UserBookingServices(Users user1) throws JsonProcessingException {
        this.user=user1; // here all my user will be init
        loadUsers();
    }
    public UserBookingServices() throws JsonProcessingException{
       loadUsers();
    }
    public List<Users> loadUsers() throws JsonProcessingException{
        File file=new File(USERS_PATH);
        return objectMapper.readValue(user.toString(),new TypeReference<List<Users>>(){});
    }
    public Boolean loginUser(){
        Optional<Users> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(Users user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
    public void fetchBookings(){
        Optional<Users> userFetched = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        userFetched.ifPresent(Users::printTickets);
    }
    public Boolean cancelBooking(String ticketId){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ticket id to cancel");
        ticketId = s.next();

        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }

        String finalTicketId1 = ticketId;  //Because strings are immutable
        boolean removed = user.getTicketsBocked().removeIf(ticket -> ticket.getTicketsId().equals(finalTicketId1));

        String finalTicketId = ticketId;
        user.getTicketsBocked().removeIf(Ticket -> Ticket.getTicketsId().equals(finalTicketId));
        if (removed) {
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return Boolean.TRUE;
        }else{
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }
    }
    public List<Train> getTrains(String source, String destination){
        try{
            TrainServices trainService = new TrainServices();
            return trainService.searchTrains(source, destination);
        }catch(IOException ex){
            return new ArrayList<>();
        }
    }


}
