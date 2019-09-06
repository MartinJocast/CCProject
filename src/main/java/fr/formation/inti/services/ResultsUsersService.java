package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;

public interface ResultsUsersService {

	public Set<ResultsUsers> findAll();
	
	public ResultsUsers findById(Integer idResultsUsers);
	
	public Set<ResultsUsers> findByMatch1(Integer match1);
	
	public Set<ResultsUsers> findByMatch2(Integer match2);

	public Set<ResultsUsers> findByLeague(Leagues leagues);
	
	public Set<ResultsUsers> findByMatchOfZeDay(MatchOfZeDay matchOfZeDay);

	public void save(ResultsUsers resultsUsers);

	public void update(ResultsUsers resultsUsers);

	public void delete(ResultsUsers resultsUsers);
	
	public void deleteById(Integer idResultsUsers);
}
