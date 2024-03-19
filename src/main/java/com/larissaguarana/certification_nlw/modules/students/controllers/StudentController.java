package com.larissaguarana.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larissaguarana.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.larissaguarana.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.larissaguarana.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.larissaguarana.certification_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.larissaguarana.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @Autowired
  private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

  @PostMapping("/verifyIfHasCertification")
  public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) { 
    
    var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
    if (result) {
      return "User already did the test";
    }
    return "User can do the test";
  }

  @PostMapping("/certification/answer")
  public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {
            var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    
    
  
}
