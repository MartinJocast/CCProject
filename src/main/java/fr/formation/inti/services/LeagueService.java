package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.ResultsUsers;

public interface LeagueService {

	public Set<Leagues> findAll();
	
	public Leagues findById(Integer idLeague);
	
	public Set<Leagues> findByName(String name);

	public Set<Leagues> findByUsers(Set<ResultsUsers> resultsUserses);

	public void save(Leagues league);

	public void update(Leagues league);

	public void delete(Leagues league);
	
	public void deleteById(Integer idLeague);
}
