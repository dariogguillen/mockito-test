package org.dgg.mockito.repositories;

import org.dgg.mockito.models.Exam;

import java.util.List;

public interface ExamRepository {
    List<Exam> findAll();
}
