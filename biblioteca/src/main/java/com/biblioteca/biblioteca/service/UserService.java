package com.biblioteca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.biblioteca.dto.UserDTO;
import com.model.User;
import com.model.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private UserDTO toDTO(User user){
        UserDTO dto=new UserDTO();
        dto.setId(user.getId());
        dto.setRole(user.getRole());
        dto.setUsername(user.getUsername());

        return dto;

    }

    private User toEntity(UserDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        user.setId(dto.getId());
        return user;
    }

    public UserDTO cadastraUserDTO(UserDTO userDTO){
        User user=toEntity(userDTO);
        User userSalvo=userRepository.save(user);
        return toDTO(userSalvo);
    }

    public List<UserDTO> listarUsuarios(){
        return userRepository.findAll()
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public UserDetails autenticarUsuarioPorUsername(String Username) throws UsernameNotFoundException{
        User user =userRepository.findByUsername(username);

        return User(user.getUsername());
    }
}


