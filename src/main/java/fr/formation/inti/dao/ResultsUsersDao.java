package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.StatsPlayers;

public interface ResultsUsersDao extends JpaRepository<ResultsUsers, Integer> {

	public Set<ResultsUsers> findByMatch1(Integer match1);
	
	public Set<ResultsUsers> findByMatch2(Integer match2);

	public Set<ResultsUsers> findByLeagues(Leagues leagues);
	
	public Set<ResultsUsers> findByMatchOfZeDay(MatchOfZeDay matchOfZeDay);
	
	public void deleteById(Integer idResultsUsers);

}
