package com.multiway.cam.domain.service;

import com.multiway.cam.domain.model.Cam;
import com.multiway.cam.domain.repository.CamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Service
public class CrudCamService {

    private CamRepository camRepository;

    @Transactional
    public Cam saveCam(Cam cam){
        return camRepository.save(cam);
    }

    @Transactional
    public ResponseEntity<Void> deleteCam(int camId){
        if (!camRepository.existsById(camId)){
            return ResponseEntity.notFound().build();
        }
        camRepository.deleteById(camId);
        return ResponseEntity.noContent().build();
    }

}
