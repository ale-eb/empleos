package com.pantera.empleos.service.impl;

import com.pantera.empleos.domain.Vacant;
import com.pantera.empleos.repository.VacantRepository;
import com.pantera.empleos.service.VacantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacantServiceImpl implements VacantService {

  private final VacantRepository vacantRepository;

  @Override
  public Vacant findById(Long id) {
    return vacantRepository.findById(id).get();
  }
}
