package com.innowise.service;

import com.innowise.dto.AuthRequest;
import com.innowise.dto.AuthResponse;
import com.innowise.dto.RegisterRequest;
import com.innowise.dto.RegisterResponse;
import com.innowise.model.RoleEntity;
import com.innowise.model.UserEntity;
import com.innowise.repository.UserRepository;
import com.innowise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public RegisterResponse register(RegisterRequest registerRequest) {
        // Проверка существования пользователя
        if (userRepository.existsByUserName(registerRequest.getUserName())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByUserEmail(registerRequest.getUserEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Создание сущности пользователя
        UserEntity user = new UserEntity();
        user.setUserName(registerRequest.getUserName());
        user.setUserPassword(registerRequest.getUserPassword());
        user.setUserEmail(registerRequest.getUserEmail());

        // Добавление дефолтной роли - ВАЖНО: используем RoleEntity, а не RoleRepository
        RoleEntity userRole = roleRepository.findByName("ROLE_USER")  // roleRepository.findByName возвращает RoleEntity
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.getUserRoles().add(userRole);  // userRole должен быть типа RoleEntity

        // Сохранение в БД
        UserEntity savedUser = userRepository.save(user);

        // Преобразование в Response
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(savedUser.getId());
        registerResponse.setUserName(savedUser.getUserName());
        registerResponse.setUserEmail(savedUser.getUserEmail());

        // Преобразование ролей в String
        Set<String> roleNames = savedUser.getUserRoles().stream()
                .map(RoleEntity::getName)
                .collect(Collectors.toSet());
        registerResponse.setUserRoles(roleNames);

        return registerResponse;
    }

//    public AuthResponse auth(AuthRequest authRequest) {
//        // Поиск пользователя в БД
//        UserEntity user = userRepository.findByUserName(authRequest.getUserName())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Проверка пароля (TODO: добавить шифрование)
//        if (!user.getUserPassword().equals(authRequest.getUserPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        // Создание ответа
//        AuthResponse authResponse = new AuthResponse();
//        authResponse.setUserId(user.getId());
//        authResponse.setUserEmail(user.getUserEmail());
//        authResponse.setUserName(user.getUserName());
//
//        // Преобразование ролей - исправлено с Role на RoleEntity
//        Set<String> roleNames = user.getUserRoles().stream()
//                .map(RoleEntity::getName)  // ← RoleEntity вместо Role
//                .collect(Collectors.toSet());
//        authResponse.setUserRoles(roleNames);
//
//        return authResponse;
//    }

    // Дополнительные методы для управления ролями
    public void addRoleToUser(Long userId, String roleName) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RoleEntity role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getUserRoles().add(role);
        userRepository.save(user);
    }
}