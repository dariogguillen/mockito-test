package org.dgg.mockito.repositories;

import java.util.List;

public interface QuestionRepository {
    List<String> findQuestionsByExamId(Long id);
}
