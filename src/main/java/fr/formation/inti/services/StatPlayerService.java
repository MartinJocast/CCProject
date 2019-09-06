package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.StatsPlayers;


public interface StatPlayerService {
	public Set<StatsPlayers> findAll();

	public StatsPlayers findById(Integer idStatsPlayers);

	public Set<StatsPlayers> findByGoal(Integer goal);

	public Set<StatsPlayers> findByRate(Integer rate);
	
	public void save(StatsPlayers statplayer);

	public void update(StatsPlayers statplayer);
	
	public void deleteById(Integer idStatsPlayers);
	
	public void delete(StatsPlayers statplayer);

}
