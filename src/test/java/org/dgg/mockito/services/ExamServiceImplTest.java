package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;
import org.dgg.mockito.repositories.ExamRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamServiceImplTest {

    @Test
    void findExamByName() {
        ExamRepository examRepository = mock(ExamRepository.class);
        when(examRepository.findAll()).thenReturn(Arrays.asList(
                new Exam(1L, "Java"),
                new Exam(2L, "Spring"),
                new Exam(3L, "Hibernate"),
                new Exam(4L, "Mockito"),
                new Exam(5L, "JUnit")
        ));
        ExamService examService = new ExamServiceImpl(examRepository);
        Exam exam = examService.findExamByName("Mockito");
        assertNotNull(exam);
        assertEquals("Mockito", exam.getName());
        assertEquals(4L, exam.getId());
    }
}