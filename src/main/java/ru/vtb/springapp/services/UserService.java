package ru.vtb.springapp.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vtb.springapp.domain.User;
import ru.vtb.springapp.repos.UserRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public void save(User user) {
        userRepo.save(user);
    }

    public User getById(Long id) {
        return userRepo.getById(id);
    }

    public List<User> getAll() {
        return userRepo.getAll();
    }
}
