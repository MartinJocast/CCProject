package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.LeaguesHaveUsersDao;
import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.LeaguesHaveUsers;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.Users;

@Service
public class LeaguesHaveUsersServiceImpl implements LeaguesHaveUsersService {

	@Autowired
	LeaguesHaveUsersDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<LeaguesHaveUsers> findAll() {
		return (Set<LeaguesHaveUsers>) dao.findAll();
	}
	
	@Override
	public LeaguesHaveUsers findById(Integer idLeaguesHaveUsers) {
		return dao.findById(idLeaguesHaveUsers).get();
	}

	@Override
	public Set<LeaguesHaveUsers> findByLeague(Leagues leagues) {
		return dao.findByLeague(leagues);
	}

	@Override
	public Set<LeaguesHaveUsers> findByUsers(Users users) {
		return dao.findByUsers(users);
	}
	
	@Override
	public void save(LeaguesHaveUsers leaguesHaveUsers) {
		dao.save(leaguesHaveUsers);
	}

	@Override
	public void update(LeaguesHaveUsers leaguesHaveUsers) {
		LeaguesHaveUsers leaguesHaveUsersUpdate = dao.findById(leaguesHaveUsers.getIdLeaguesHaveUsers()).get();
		leaguesHaveUsersUpdate.setLeagues(leaguesHaveUsers.getLeagues());
		leaguesHaveUsersUpdate.setUsers(leaguesHaveUsers.getUsers());
		dao.save(leaguesHaveUsersUpdate);
	}

	@Override
	public void delete(LeaguesHaveUsers leaguesHaveUsers) {
		dao.delete(leaguesHaveUsers);
	}
	
	@Override
	public void deleteById(Integer idLeaguesHaveUsers) {
		dao.deleteById(idLeaguesHaveUsers);
	}
		
}
