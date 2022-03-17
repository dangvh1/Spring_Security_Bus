package com.example.Spring_Security_Bus.security;

import com.example.Spring_Security_Bus.entity.Users;
import com.example.Spring_Security_Bus.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findUsersByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(users);
    }
}
