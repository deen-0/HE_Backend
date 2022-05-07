package com.majorProject.HonestExam.Repository;

import com.majorProject.HonestExam.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Test,Long> {
}
