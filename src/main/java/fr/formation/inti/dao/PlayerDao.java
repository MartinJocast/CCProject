package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Players;

public interface PlayerDao extends JpaRepository<Players, Integer> {

	public Set<Players> findByClub(String club);

	public Set<Players> findByLastName(String lastName);
	
	public Set<Players> findByFirstName(String fistName);

	public Set<Players> findByPositionCode(String positionCode);
	
	public Set<Players> findByCountryCode(String countryCode);
	
	public Set<Players> findByValue(int value);
	
	public void deleteById(Integer idPlayer);

}
