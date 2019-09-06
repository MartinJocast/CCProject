package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.TeamsHavePlayersDao;
import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.LeaguesHaveUsers;
import fr.formation.inti.entities.Teams;
import fr.formation.inti.entities.TeamsHavePlayers;
import fr.formation.inti.entities.Users;

@Service
public class TeamsHavePlayersServiceImpl implements TeamsHavePlayersService {

	@Autowired
	TeamsHavePlayersDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<TeamsHavePlayers> findAll() {
		return (Set<TeamsHavePlayers>) dao.findAll();
	}
	
	@Override
	public TeamsHavePlayers findById(Integer idTeamsHavePlayers) {
		return dao.findById(idTeamsHavePlayers).get();
	}

	@Override
	public Set<TeamsHavePlayers> findByTeam(Teams teams) {
		return dao.findByTeam(teams);
	}

	@Override
	public void save(TeamsHavePlayers teamsHavePlayers) {
		dao.save(teamsHavePlayers);
	}

	@Override
	public void update(TeamsHavePlayers teamsHavePlayers) {
		TeamsHavePlayers teamsHavePlayersUpdate = dao.findById(teamsHavePlayers.getIdTeamsHavePlayers()).get();
		teamsHavePlayersUpdate.setPlayers(teamsHavePlayers.getPlayers());
		teamsHavePlayersUpdate.setTeams(teamsHavePlayers.getTeams());
		dao.save(teamsHavePlayersUpdate);
	}
	
	@Override
	public void delete(TeamsHavePlayers teamsHavePlayers) {
		dao.delete(teamsHavePlayers);
	}
	
	@Override
	public void deleteById(Integer idTeamsHavePlayers) {
		dao.deleteById(idTeamsHavePlayers);
	}
	
}
