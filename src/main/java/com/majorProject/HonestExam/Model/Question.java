package com.majorProject.HonestExam.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private Long test_id;

    @ManyToOne
    @JoinColumn(name = "test_id",referencedColumnName = "id",insertable = false,updatable = false)
    @JsonBackReference
    Test test;
}
