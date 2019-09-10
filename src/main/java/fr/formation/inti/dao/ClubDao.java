package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Clubs;

public interface ClubDao extends JpaRepository <Clubs, Integer>{

	public Clubs findByName (String name);
	
	public Clubs findByClubCode (String clubcode);

	
	public void deleteById(Integer idClub);
}
