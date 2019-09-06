package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.PlayerDao;
import fr.formation.inti.entities.Players;
import fr.formation.inti.entities.Users;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Players> findAll() {
		return (Set<Players>) dao.findAll();
	}
	
	@Override
	public Players findById(Integer idPlayer) {
		return dao.findById(idPlayer).get();
	}

	@Override
	public Set<Players> findByClub(String club) {
		return dao.findByClub(club);
	}

	@Override
	public Set<Players> findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}

	@Override
	public Set<Players> findByFirstName(String fistName) {
		return dao.findByFirstName(fistName);
	}

	@Override
	public Set<Players> findByPositionCode(String positionCode) {
		return dao.findByPositionCode(positionCode);
	}

	@Override
	public Set<Players> findByCountryCode(String countryCode) {
		return dao.findByCountryCode(countryCode);
	}

	@Override
	public Set<Players> findByValue(int value) {
		return dao.findByValue(value);
	}

	@Override
	public void save(Players player) {
		dao.save(player);
	}

	@Override
	public void update(Players player) {
		Players playerUpdate = dao.findById(player.getIdPlayer()).get();
		playerUpdate.setLastName(player.getLastName());
		playerUpdate.setFirstName(player.getFirstName());
		playerUpdate.setClub(player.getClub());
		playerUpdate.setClubs(player.getClubs());
		playerUpdate.setPosition(player.getPosition());
		playerUpdate.setPositionCode(player.getPositionCode());
		playerUpdate.setValue(player.getValue());
		playerUpdate.setStatsPlayerses(player.getStatsPlayerses());
		playerUpdate.setTeamsHavePlayerses(player.getTeamsHavePlayerses());
		dao.save(playerUpdate);	
	}

	@Override
	public void delete(Players player) {
		dao.delete(player);		
	}
	
	@Override
	public void deleteById(Integer idPlayer) {
		dao.deleteById(idPlayer);
	}

}
