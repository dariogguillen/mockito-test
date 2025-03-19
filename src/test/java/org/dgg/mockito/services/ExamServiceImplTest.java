package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;
import org.dgg.mockito.repositories.ExamRepository;
import org.dgg.mockito.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamServiceImplTest {
    ExamRepository examRepository;
    ExamService examService;
    QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        examRepository = mock(ExamRepository.class);
        questionRepository = mock(QuestionRepository.class);
        examService = new ExamServiceImpl(examRepository, questionRepository);

        when(examRepository.findAll()).thenReturn(Arrays.asList(
                new Exam(1L, "Java"),
                new Exam(2L, "Spring"),
                new Exam(3L, "Hibernate"),
                new Exam(4L, "Mockito"),
                new Exam(5L, "JUnit")
        ));
    }

    @Test
    void findExamByName() {
        Optional<Exam> exam = examService.findExamByName("Mockito");
        assertTrue(exam.isPresent());
        assertEquals("Mockito", exam.orElseThrow().getName());
        assertEquals(4L, exam.get().getId());
    }

    @Test
    void findExamByName_notFound() {
        Optional<Exam> exam = examService.findExamByName("C++");
        assertTrue(exam.isEmpty());
    }

    @Test
    void findExamByName_emptyList() {
        examRepository = mock(ExamRepository.class);
        when(examRepository.findAll()).thenReturn(List.of());
        examService = new ExamServiceImpl(examRepository, questionRepository);
        Optional<Exam> exam = examService.findExamByName("Java");
        assertTrue(exam.isEmpty());
    }

    @Test
    void findExamQuestionsByName() {
        Optional<Exam> exam = examService.findExamQuestionsByName("Mockito");
        assertTrue(exam.isPresent());
        assertEquals("Mockito", exam.orElseThrow().getName());
        assertEquals(4L, exam.get().getId());
    }
}