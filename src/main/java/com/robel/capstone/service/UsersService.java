package com.robel.capstone.service;


import com.robel.capstone.model.UsersModel;
import com.robel.capstone.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;


    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String firstName, String lastName, String email, String password) {
        if(firstName == null || lastName == null || email == null || password == null){
            return null;
        }else {
            if(usersRepository.findFirstByEmail(email).isPresent()){
               throw new RuntimeException("Email already exists");
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setFirstName(firstName);
            usersModel.setLastName(lastName);
            usersModel.setEmail(email);
            usersModel.setPassword(password);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticateUser(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password).orElse(null);
    }

}
