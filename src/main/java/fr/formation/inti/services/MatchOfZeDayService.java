package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.StatsPlayers;

public interface MatchOfZeDayService {

	public Set<MatchOfZeDay> findAll();
	
	public MatchOfZeDay findById(Integer idMatchOfTheDay);
	
	public Set<MatchOfZeDay> findByMatch1(Integer matchDay);

	public Set<MatchOfZeDay> findByStatsPlayers(Set<StatsPlayers> statsPlayerses);
	
	public Set<MatchOfZeDay> findByResultsUsers(Set<ResultsUsers> resultsUserses);

	public void save(MatchOfZeDay matchOfZeDay);

	public void update(MatchOfZeDay matchOfZeDay);

	public void delete(MatchOfZeDay matchOfZeDay);
	
	public void deleteById(Integer idMatchOfTheDay);
}
