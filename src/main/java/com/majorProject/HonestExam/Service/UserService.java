package com.majorProject.HonestExam.Service;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Model.Test;
import com.majorProject.HonestExam.Model.User;
import com.majorProject.HonestExam.Repository.TestRepo;
import com.majorProject.HonestExam.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TestRepo testRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }


    public int validateTestKey(long testId) {
        Test test=testRepo.findById(testId).orElse(null);
        if(test==null){return -1;}
        return  test.getAllQuestions().size();


    } //a seprate function for sending test info in jSON;

    public boolean validEmail(String email) {
        User user=userRepo.getByEmail(email);
        if(user==null)return false;
        else return true;
    }

    public User validUser(String email, String password) {

            return userRepo.getByEmailAndPassword(email,password);
    }
}
