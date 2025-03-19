package org.dgg.mockito.repositories;

import org.dgg.mockito.models.Exam;

import java.util.Arrays;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository {
    @Override
    public List<Exam> findAll() {
        return Arrays.asList(
                new Exam(1L, "Java"),
                new Exam(2L, "Spring"),
                new Exam(3L, "Hibernate"),
                new Exam(4L, "Mockito"),
                new Exam(5L, "JUnit")
        );
    }
}
