package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.LeaguesHaveUsers;
import fr.formation.inti.entities.Users;

public interface LeaguesHaveUsersDao extends JpaRepository<LeaguesHaveUsers, Integer> {

	public Set<LeaguesHaveUsers> findByLeague(Leagues leagues);

	public Set<LeaguesHaveUsers> findByUsers(Users users);
	
	public void deleteById(Integer idLeaguesHaveUsers);

}
