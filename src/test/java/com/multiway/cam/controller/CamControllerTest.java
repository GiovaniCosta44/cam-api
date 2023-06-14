package com.multiway.cam.controller;


import com.multiway.cam.api.controller.CamController;
import com.multiway.cam.domain.model.Cam;
import com.multiway.cam.domain.repository.CamRepository;
import com.multiway.cam.domain.service.CrudCamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CamControllerTest {

    @InjectMocks
    private CamController camController;

    @Mock
    private CrudCamService crudCamService;

    @Mock
    private CamRepository camRepository;
    

    @Test
    public void deveRetornarSucessoQuandoBuscarCam(){
        int camId = 1;
        given(camRepository.findById(camId)).willReturn(Optional.of(mock(Cam.class)));
        ResponseEntity<Cam> response = camController.findCam(camId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
