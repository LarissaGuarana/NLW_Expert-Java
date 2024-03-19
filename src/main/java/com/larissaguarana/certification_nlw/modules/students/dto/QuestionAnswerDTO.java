package com.larissaguarana.certification_nlw.modules.students.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

UUID
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {

  private String questionID;
  private String alternativeID;
  private boolean isCorrect;
  
}
