package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Teams;

public interface TeamService {

	
public Set<Teams> findAll();
	
    public Teams findById(Integer idTeam);

	public Teams findByUsersIdUser(Integer usersIdUser);
		
	public Set<Teams> findByName(String name);

	public void save(Teams team);

	public void update(Teams team);

	public void delete(Teams team);
	
	public void deleteByUsersIdUser(Integer usersIdUser);
	

}
