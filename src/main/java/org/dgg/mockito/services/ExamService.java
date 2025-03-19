package org.dgg.mockito.services;

import org.dgg.mockito.models.Exam;

public interface ExamService {
    Exam findExamByName(String name);
}
