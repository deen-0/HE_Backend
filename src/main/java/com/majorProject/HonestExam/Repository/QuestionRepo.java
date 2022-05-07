package com.majorProject.HonestExam.Repository;


import com.majorProject.HonestExam.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {

}
