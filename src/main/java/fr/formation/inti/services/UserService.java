package fr.formation.inti.services;

import java.util.Set;

import fr.formation.inti.entities.Users;

public interface UserService {

	public Set<Users> findAll();
	
	public Users findById(Integer idUser);
	
	public Users findByEmail(String email);
	
	public Set<Users> findByPseudo(String pseudo);

	public void save(Users user);

	public void update(Users user);

	public void delete(Users user);

	public void deleteById(Integer idUser);

}
