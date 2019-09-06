package fr.formation.inti.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Users;

public interface UserDao extends JpaRepository<Users, Integer> {

	public Users findByEmail(String email);

	public Set<Users> findByPseudo(String pseudo);


	public void deleteById(Integer idUser);

	
}
