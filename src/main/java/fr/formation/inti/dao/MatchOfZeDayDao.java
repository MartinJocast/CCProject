package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.StatsPlayers;

public interface MatchOfZeDayDao extends JpaRepository<MatchOfZeDay, Integer> {

	public Set<MatchOfZeDay> findByMatch1(Integer matchDay);

	public Set<MatchOfZeDay> findByStatsPlayers(Set<StatsPlayers> statsPlayerses);
	
	public Set<MatchOfZeDay> findByResultsUsers(Set<ResultsUsers> resultsUserses);
	
	public void deleteById(Integer idMatchOfTheDay);

}
