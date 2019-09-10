package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.LeagueDao;
import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.ResultsUsers;

@Service
public class LeagueServiceImpl implements LeagueService {

	@Autowired
	LeagueDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Leagues> findAll() {
		return (Set<Leagues>) dao.findAll();
	}
	
	@Override
	public Leagues findById(Integer idLeague) {
		return dao.findById(idLeague).get();
	}

	@Override
	public Set<Leagues> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Set<Leagues> findByResultsUserses(Set<ResultsUsers> resultsUserses) {
		return dao.findByResultsUserses(resultsUserses);
	}

	@Override
	public void save(Leagues league) {
		dao.save(league);
	}

	@Override
	public void update(Leagues league) {
		Leagues leagueUpdate = dao.findById(league.getIdLeague()).get();
		leagueUpdate.setName(league.getName());
		leagueUpdate.setRanking(league.getRanking());
		leagueUpdate.setLeaguesHaveUserses(league.getLeaguesHaveUserses());
		leagueUpdate.setResultsUserses(league.getResultsUserses());
		dao.save(leagueUpdate);			
	}

	@Override
	public void delete(Leagues league) {
		dao.delete(league);
	}
	
	@Override
	public void deleteById(Integer idLeague) {
		dao.deleteById(idLeague);
	}

}
