package com.multiway.cam.domain.repository;

import com.multiway.cam.domain.model.Cam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CamRepository extends JpaRepository<Cam, Integer> {

    List<Cam> findByAtivo(String ativo);
    List<Cam> findByAtivoContaining(String ativo);

}
