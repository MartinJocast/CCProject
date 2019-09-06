package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.Players;
import fr.formation.inti.entities.Teams;
import fr.formation.inti.entities.TeamsHavePlayers;
import fr.formation.inti.entities.Users;

public interface TeamsHavePlayersDao extends JpaRepository<TeamsHavePlayers, Integer> {

	public Set<TeamsHavePlayers> findByTeam(Teams teams);
	
	public void deleteById(Integer idTeamsHavePlayers);

}
