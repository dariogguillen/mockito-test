package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;

import java.util.Optional;

public interface ExamService {
    Optional<Exam> findExamByName(String name);
}
