package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.LeaguesHaveUsers;
import fr.formation.inti.entities.ResultsUsers;
import fr.formation.inti.entities.Users;

public interface LeaguesHaveUsersService {

	public Set<LeaguesHaveUsers> findAll();
	
	public LeaguesHaveUsers findById(Integer idLeaguesHaveUsers);
	
	public Set<LeaguesHaveUsers> findByLeagues(Leagues leagues);

	public Set<LeaguesHaveUsers> findByUsers(Users users);

	public void save(LeaguesHaveUsers leaguesHaveUsers);

	public void update(LeaguesHaveUsers leaguesHaveUsers);

	public void delete(LeaguesHaveUsers leaguesHaveUsers);
	
	public void deleteById(Integer idLeaguesHaveUsers);

}
