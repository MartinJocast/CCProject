package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Clubs;

public interface ClubService {
	
	public Set<Clubs> findAll();
	
	public Clubs findById (Integer idClub);
	
	public Clubs findByName (String name);

	public Clubs findByClubCode (String clubcode);

	public void save (Clubs club);
	
	public void update (Clubs club);
	
	public void delete (Clubs club);
	
	public void deleteById (Integer idClub);

}
