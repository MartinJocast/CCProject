package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.MatchOfZeDayDao;
import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.StatsPlayers;

@Service
public class MatchOfZeDayServiceImpl implements MatchOfZeDayService {

	@Autowired
	MatchOfZeDayDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<MatchOfZeDay> findAll() {
		return (Set<MatchOfZeDay>) dao.findAll();
	}
	
	@Override
	public MatchOfZeDay findById(Integer idMatchOfTheDay) {
		return dao.findById(idMatchOfTheDay).get();
	}

	@Override
	public Set<MatchOfZeDay> findByMatch1(Integer matchDay) {
		return dao.findByMatch1(matchDay);
	}

	@Override
	public Set<MatchOfZeDay> findByStatsPlayers(Set<StatsPlayers> statsPlayerses) {
		return dao.findByStatsPlayers(statsPlayerses);
	}

	@Override
	public Set<MatchOfZeDay> findByResultsUsers(Set<ResultsUsers> resultsUserses) {
		return dao.findByResultsUsers(resultsUserses);
	}

	@Override
	public void save(MatchOfZeDay matchOfZeDay) {
		dao.save(matchOfZeDay);
	}

	@Override
	public void update(MatchOfZeDay matchOfZeDay) {
		MatchOfZeDay matchOfZeDayUpdate = dao.findById(matchOfZeDay.getIdMatchOfTheDay()).get();
		matchOfZeDayUpdate.setMatchDay(matchOfZeDay.getMatchDay());
		matchOfZeDayUpdate.setResultsUserses(matchOfZeDay.getResultsUserses());
		matchOfZeDayUpdate.setStatsPlayerses(matchOfZeDay.getStatsPlayerses());
		dao.save(matchOfZeDayUpdate);
	}
	
	@Override
	public void delete(MatchOfZeDay matchOfZeDay) {
		dao.delete(matchOfZeDay);
	}
	
	@Override
	public void deleteById(Integer idMatchOfZeDay) {
		dao.deleteById(idMatchOfZeDay);
	}
	
}
