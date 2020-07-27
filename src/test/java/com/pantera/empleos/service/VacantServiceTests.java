package com.pantera.empleos.service;

import com.pantera.empleos.BaseTest;
import com.pantera.empleos.domain.Vacant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class VacantServiceTests extends BaseTest {

  @Autowired
  private VacantService vacantService;

  @Autowired
  private EntityManager entityManager;

  @Test
  void findById_withExistingId_returnVacant() {
    Long id = 0L;
    createAndInsertTestVacant();

    Vacant vacant = vacantService.findById(id);

    assertThat(vacant).isNotNull();
    assertThat(vacant.getId()).isEqualTo(0L);
    assertThat(vacant.getName()).isEqualTo("Ingeniero Civil");
    assertThat(vacant.getDescription()).isEqualTo("Solicitamos ing civil para construir puente peatonal");
  }

  /*
  @Test
  void findById_withNotExistingId_throw() {
    Long id = 1L;

  }*/

  private void createAndInsertTestVacant() {
    Vacant vacant = new Vacant();
    vacant.setName("Ingeniero Civil");
    vacant.setDescription("Solicitamos ing civil para construir puente peatonal");
    vacant.setSalary(9000);
    vacant.setDate(LocalDate.now());

    entityManager.persist(vacant);
    entityManager.flush();
    entityManager.detach(vacant);
  }
}
