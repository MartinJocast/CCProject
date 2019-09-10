package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.ResultsUsers;

public interface LeagueDao extends JpaRepository<Leagues, Integer> {

	public Set<Leagues> findByName(String name);

	public Set<Leagues> findByResultsUserses(Set<ResultsUsers> resultsUserses);
	
	public void deleteById(Integer idLeague);

}
