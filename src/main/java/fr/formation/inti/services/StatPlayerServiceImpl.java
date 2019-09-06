package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.StatsPlayersDao;
import fr.formation.inti.entities.StatsPlayers;


@Service
public class StatPlayerServiceImpl implements StatPlayerService{

	
	@Autowired
	StatsPlayersDao dao;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<StatsPlayers> findAll() {
		return (Set<StatsPlayers>) dao.findAll();
	}

	@Override
	public StatsPlayers findById(Integer idStatsPlayers) {
		return dao.findById(idStatsPlayers).get();
	}

	@Override
	public Set<StatsPlayers> findByGoal(Integer goal) {
		return dao.findByGoal(goal);
	}

	@Override
	public Set<StatsPlayers> findByRate(Integer rate) {
		return dao.findByRate(rate);
	}

	@Override
	public void save(StatsPlayers statPlayer) {
		dao.save(statPlayer);
	}

	@Override
	public void update(StatsPlayers statPlayer) {
		StatsPlayers statPlayerUpdate = dao.findById(statPlayer.getIdStatsPlayers()).get();
		statPlayerUpdate.setMatchOfZeDay(statPlayer.getMatchOfZeDay());
		statPlayerUpdate.setPlayers(statPlayer.getPlayers());
		statPlayerUpdate.setRates(statPlayer.getRates());
		statPlayerUpdate.setGoals(statPlayer.getGoals());
		dao.save(statPlayerUpdate);
	}

	@Override
	public void delete(StatsPlayers statplayer) {
		dao.delete(statplayer);
		}
	
	@Override
	public void deleteById(Integer idStatsPlayers) {
		dao.deleteById(idStatsPlayers);
	
		
}
}
