package com.example.Spring_Security_Bus.service;

import com.example.Spring_Security_Bus.DTO.RoleDTO;
import com.example.Spring_Security_Bus.DTO.UsersDTO;
import com.example.Spring_Security_Bus.entity.Role;
import com.example.Spring_Security_Bus.entity.UserRole;
import com.example.Spring_Security_Bus.entity.Users;
import com.example.Spring_Security_Bus.repository.RoleRepository;
import com.example.Spring_Security_Bus.repository.UserRoleRepository;
import com.example.Spring_Security_Bus.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceSystem {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    public UsersDTO create(UsersDTO usersDTO){
        Users users = new Users();
        BeanUtils.copyProperties(usersDTO, users);
        usersRepository.save(users);
        usersDTO.setId(users.getId());

        List<RoleDTO> roleDTOS = usersDTO.getRoles();

        List<UserRole> userRoles = roleDTOS.stream().map(e -> {
            UserRole userRole = new UserRole();

            Optional<Role> optional = roleRepository.findById(e.getId());
            if(optional.isPresent()){
                userRole.setRole(optional.get());
            }
            userRole.setUser(users);
            return userRole;
        }).collect(Collectors.toList());
        userRoleRepository.saveAll(userRoles);
        return usersDTO;
    }
}
