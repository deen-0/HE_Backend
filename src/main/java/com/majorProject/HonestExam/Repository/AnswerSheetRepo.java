package com.majorProject.HonestExam.Repository;


import com.majorProject.HonestExam.Model.AnswerSheet;
import com.majorProject.HonestExam.Model.AnswerSheetKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerSheetRepo extends JpaRepository<AnswerSheet, AnswerSheetKey> {
}
