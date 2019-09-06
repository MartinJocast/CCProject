package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.ClubDao;
import fr.formation.inti.entities.Clubs;

@Service
public class ClubServiceImpl implements ClubService {
	
@Autowired	
ClubDao dao;

@SuppressWarnings ("unchecked")
@Override
public Set<Clubs> findAll() {
	return (Set<Clubs>) dao.findAll();
}

@Override
public Clubs findById(Integer idClub) {
	return dao.findById(idClub).get();
}

@Override
public Clubs findByName(String name) {
	return dao.findByName(name);
}


@Override
public Clubs findByClubCode(String clubcode) {
	return dao.findByClubCode(clubcode);
}

@Override
public void save(Clubs club) {
	dao.save(club);
}

@Override
public void update(Clubs club) {
	Clubs clubUpdate = dao.findById(club.getIdClub()).get();
	clubUpdate.setName(club.getName());
	clubUpdate.setClubCode(club.getClubCode());
	clubUpdate.setCountryCode(club.getCountryCode());
	clubUpdate.setGroup(club.getGroup());
	clubUpdate.setRate(club.getRate());
	dao.save(clubUpdate);	
}

@Override
public void delete(Clubs club) {
	dao.delete(club);		

}

@Override
public void deleteById(Integer idClub) {
	dao.deleteById(idClub);	 	

}



}
