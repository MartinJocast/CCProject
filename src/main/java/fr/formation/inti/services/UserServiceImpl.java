package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.UserDao;
import fr.formation.inti.entities.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Users> findAll() {
		return (Set<Users>) dao.findAll();
	}
	
	@Override
	public Users findById(Integer idUser) {
		return dao.findById(idUser).get();
	}
	
	@Override
	public Users findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public Set<Users> findByPseudo(String pseudo) {
		return dao.findByPseudo(pseudo);
	}

	@Override
	public void save(Users user) {
		dao.save(user);
	}

	@Override
	public void update(Users user) {
		Users userUpdate = dao.findById(user.getIdUser()).get();
		userUpdate.setEmail(user.getEmail());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setPseudo(user.getPseudo());
		userUpdate.setSecurityRequest(user.getSecurityRequest());
		dao.save(userUpdate);	
	}

	@Override
	public void delete(Users user) {
		dao.delete(user);		
	}

	@Override
	public void deleteById(Integer idUser) {
		dao.deleteById(idUser);	 	
	}

}
