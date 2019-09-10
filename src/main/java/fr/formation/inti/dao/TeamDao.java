package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Teams;

public interface TeamDao extends JpaRepository<Teams, Integer> {

	public Teams findByUsersIdUser(Integer usersIdUser);
		
	public Set<Teams> findByName(String name);

	
	public void deleteByUsersIdUser(Integer usersIdUser);

	
}
