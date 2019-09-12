package fr.formation.inti.services;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.UserDao;
import fr.formation.inti.entities.Users;
 
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDao dao;
 
    @SuppressWarnings("null")
	@Override
    public UserDetails loadUserByUsername(String email) {
        Users user = this.dao.findByEmail(email);
 
        if (user == null) {
            return null;
        }
 
        // [ROLE_USER, ROLE_ADMIN,..]
        String roleName = user.getRole();
 
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleName != null) {
                // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
            grantList.add(authority);
        } 
        return new User(user.getEmail(), user.getPassword(), grantList);
    }
}