package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.StatsPlayers;

public interface StatsPlayersDao extends JpaRepository<StatsPlayers, Integer >{

	public Set<StatsPlayers> findByGoals(Integer goal);

	public Set<StatsPlayers> findByRates(Integer rate);

	public void deleteById(Integer idStatsPlayers);

	
}