package com.majorProject.HonestExam.Repository;

import com.majorProject.HonestExam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User getByEmail(String email);
    User getByEmailAndPassword(String email,String password);

}
