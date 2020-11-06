package repository;


import java.util.ArrayList;

import models.ListOfParticipants;
import models.Participant;


public class ParticipantsRepo { // Ubrukelig når vi ikke lagrer lokalt?? 
	private static ListOfParticipants list = new ListOfParticipants(); 
	
	public static void addParticipant(String firstName, String secondName, String phoneNumber, String password, String sex) {
		var participants  = list.getListOfParticipants();
		Participant participant = new Participant(firstName, secondName, phoneNumber, password, sex);
		participants.add(participant); 
		
		list.setParticipants((ArrayList<Participant>) participants);
	}
	

}
