package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;
import org.dgg.mockito.repositories.ExamRepository;
import org.dgg.mockito.repositories.QuestionRepository;

import java.util.Optional;

public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamServiceImpl(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Exam> findExamByName(String name) {
        return examRepository
                .findAll()
                .stream()
                .filter(exam -> exam.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Exam> findExamQuestionsByName(String name) {
        return findExamByName(name);
    }
}
