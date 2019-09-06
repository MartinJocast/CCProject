package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.ResultsUsersDao;
import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.MatchOfZeDay;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.StatsPlayers;

@Service
public class ResultsUsersServiceImpl implements ResultsUsersService {

	@Autowired
	ResultsUsersDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<ResultsUsers> findAll() {
		return (Set<ResultsUsers>) dao.findAll();
	}
	
	@Override
	public ResultsUsers findById(Integer idResultsUsers) {
		return dao.findById(idResultsUsers).get();
	}
	
	@Override
	public Set<ResultsUsers> findByMatch1(Integer match1) {
		return dao.findByMatch1(match1);
	}

	@Override
	public Set<ResultsUsers> findByMatch2(Integer match2) {
		return dao.findByMatch2(match2);
	}

	@Override
	public Set<ResultsUsers> findByLeague(Leagues leagues) {
		return dao.findByLeague(leagues);
	}

	@Override
	public Set<ResultsUsers> findByMatchOfZeDay(MatchOfZeDay matchOfZeDay) {
		return dao.findByMatchOfZeDay(matchOfZeDay);
	}

	@Override
	public void save(ResultsUsers resultsUsers) {
		dao.save(resultsUsers);
	}

	@Override
	public void update(ResultsUsers resultsUsers) {
		ResultsUsers resultsUsersUpdate = dao.findById(resultsUsers.getIdResultsUsers()).get();
		resultsUsersUpdate.setMatch1(resultsUsers.getMatch1());
		resultsUsersUpdate.setMatch2(resultsUsers.getMatch2());
		resultsUsersUpdate.setLeagues(resultsUsers.getLeagues());
		resultsUsersUpdate.setMatchOfZeDay(resultsUsers.getMatchOfZeDay());
		dao.save(resultsUsersUpdate);
	}
	
	@Override
	public void delete(ResultsUsers resultsUsers) {
		dao.delete(resultsUsers);
	}
	
	@Override
	public void deleteById(Integer idResultsUsers) {
		dao.deleteById(idResultsUsers);
	}

}
