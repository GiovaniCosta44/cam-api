package com.multiway.cam.api.controller;

import com.multiway.cam.domain.model.Cam;
import com.multiway.cam.domain.repository.CamRepository;
import com.multiway.cam.domain.service.CrudCamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cam")
@AllArgsConstructor
@RestController
public class CamController {

    private CrudCamService crudCamService;
    private CamRepository camRepository;

    @GetMapping
    public List<Cam> listall(){
        return camRepository.findAll();
    }

    @GetMapping("/{camId}")
    public ResponseEntity<Cam> findCam(@PathVariable int camId){
        return camRepository.findById(camId)
                .map(cam -> ResponseEntity.ok(cam))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cam add(@RequestBody Cam cam){
        return crudCamService.saveCam(cam);
    }

    @PutMapping("/{camId}")
    public ResponseEntity<Cam> editCam(@PathVariable int camId, @RequestBody Cam cam){
        if (!camRepository.existsById(camId)){
            return ResponseEntity.notFound().build();
        }
        cam.setId(camId);
        cam = crudCamService.saveCam(cam);

        return ResponseEntity.ok(cam);
    }

    @DeleteMapping("/{camId}")
    public void delete(@PathVariable int camId){
        crudCamService.deleteCam(camId);
    }
}
