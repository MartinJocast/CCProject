package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.TeamDao;
import fr.formation.inti.entities.Teams;

@Service
public class TeamServiceImpl implements TeamService {


	@Autowired
	TeamDao dao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Teams> findAll() {
		return (Set<Teams>) dao.findAll();
	}

	@Override
	public Teams findById(Integer idTeam) {
		return dao.findById(idTeam).get();
	}
 
	@Override
	public Teams findByUsersIdUser(Integer usersIdUser) {
		return dao.findByUsersIdUser(usersIdUser);
	}

	@Override
	public Set<Teams> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public void save(Teams team) {
		dao.save(team);

	}

	@Override
	public void update(Teams team) {
		Teams teamUpdate = dao.findById(team.getIdTeams()).get();
		
		teamUpdate.setUsersIdUser(team.getUsersIdUser());
		teamUpdate.setPlayersIdPlayer(team.getPlayersIdPlayer());
		teamUpdate.setName(team.getName());
		dao.save(teamUpdate);
	}

	@Override
	public void delete(Teams team) {
		dao.delete(team);		

	}

	@Override
	public void deleteById(Integer idTeam) {
		dao.deleteById(idTeam);	 	

	}

}
