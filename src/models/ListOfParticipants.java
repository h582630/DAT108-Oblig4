package models;

import java.util.ArrayList;
import java.util.List;


public class ListOfParticipants {
	
	ArrayList<Participant> participants;
	
	public ListOfParticipants() {
		participants = new ArrayList<Participant>(); 
	}
	
	public List<Participant> getListOfParticipants() {
		return participants; 
	}
	
	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	} 
}
