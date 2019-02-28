package services;

import models.Role;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public User addUser(User user) {


        User userFromDb = userRepo.findByUsername(user.getUsername());


        return userFromDb;
    }

    public void updateUserName(User usreFromDb, String username, Map<String, String> form) {



            usreFromDb.setUsername(username);

            Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

            usreFromDb.getRoles().clear();
            for (String key: form.keySet()
            ) {
                if (roles.contains(key)){
                    usreFromDb.getRoles().add(Role.valueOf(key));
                }

            }

            userRepo.save(usreFromDb);



    }
}
