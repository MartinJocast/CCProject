package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Players;

public interface PlayerService {

	public Set<Players> findAll();
	
	public Players findById(Integer idPlayer);
	
	public Set<Players> findByClub(String club);

	public Set<Players> findByLastName(String lastName);
	
	public Set<Players> findByFirstName(String fistName);

	public Set<Players> findByPositionCode(String positionCode);
	
	public Set<Players> findByCountryCode(String countryCode);
	
	public Set<Players> findByValue(int value);

	public void save(Players player);

	public void update(Players player);

	public void delete(Players player);
	
	public void deleteById(Integer idPlayer);
}
