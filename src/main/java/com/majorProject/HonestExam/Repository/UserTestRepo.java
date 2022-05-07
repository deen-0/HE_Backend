package com.majorProject.HonestExam.Repository;

import com.majorProject.HonestExam.Model.MyKey;
import com.majorProject.HonestExam.Model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTestRepo extends JpaRepository<UserTest, MyKey> {

    List<UserTest> findByTestId(long testId);

}
