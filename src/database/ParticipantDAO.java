package database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Participant;

@Stateless
public class ParticipantDAO {

	@PersistenceContext(name = "participantPU")
	private EntityManager em;

	public void addParticipant(Participant newParticipant) {
		em.persist(newParticipant);

	}
																	
	public synchronized List<Participant> getParticipants() {
		return em.createNativeQuery("SELECT firstname, lastname, phonenumber, sex FROM oblig4.participant", Participant.class).getResultList();
	}

}
