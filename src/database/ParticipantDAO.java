package database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Participant;

@Stateless
public class ParticipantDAO {

	@PersistenceContext(name = "participantPU")
	private EntityManager em;

	public void addParticipant(Participant newParticipant) {
		em.persist(newParticipant);

	}
																	
	@SuppressWarnings("unchecked")
	public synchronized List<Participant> getParticipants() {
		return em.createNativeQuery("SELECT firstname, lastname, phonenumber, sex FROM oblig4.participant"
				+ " ORDER BY firstname, lastname", Participant.class).getResultList();
	}
	

	public synchronized Participant getPassword(String username){
		@SuppressWarnings("unchecked")
		TypedQuery<Participant> query = (TypedQuery<Participant>) em.createNativeQuery("SELECT p.phonenumber, p.password_hash, p.password_salt FROM oblig4.participant p"
		 + " WHERE p.phonenumber =" + username, Participant.class);
		
		Participant participant = query.getSingleResult(); 
		
		return participant;

		
	}
	@SuppressWarnings("unchecked")
	public synchronized List<String> getUsername(){
		return em.createNativeQuery("SELECT phonenumber FROM oblig4.participant", Participant.class).getResultList(); 
	}

}
