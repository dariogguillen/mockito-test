package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;
import org.dgg.mockito.repositories.ExamRepository;

import java.util.Optional;

public class ExamServiceImpl implements ExamService {
    private ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Optional<Exam> findExamByName(String name) {
        return examRepository
                .findAll()
                .stream()
                .filter(exam -> exam.getName().equals(name))
                .findFirst();
    }
}
