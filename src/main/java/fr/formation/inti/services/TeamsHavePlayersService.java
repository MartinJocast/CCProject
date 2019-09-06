package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Teams;
import fr.formation.inti.entities.TeamsHavePlayers;

public interface TeamsHavePlayersService {

	public Set<TeamsHavePlayers> findAll();
	
	public TeamsHavePlayers findById(Integer idTeamsHavePlayers);
	
	public Set<TeamsHavePlayers> findByTeam(Teams teams);

	public void save(TeamsHavePlayers teamsHavePlayers);

	public void update(TeamsHavePlayers teamsHavePlayers);

	public void delete(TeamsHavePlayers teamsHavePlayers);
	
	public void deleteById(Integer idTeamsHavePlayers);
}
