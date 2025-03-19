package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;
import org.dgg.mockito.repositories.ExamRepository;
import org.dgg.mockito.repositories.ExamRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamServiceImplTest {

    @Test
    void findExamByName() {
        ExamRepository examRepository = new ExamRepositoryImpl();
        ExamService examService = new ExamServiceImpl(examRepository);
        Exam exam = examService.findExamByName("Mockito");
        assertNotNull(exam);
        assertEquals("Mockito", exam.getName());
        assertEquals(4L, exam.getId());
    }
}