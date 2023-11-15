package com.codelab.spaceTube.Controller;

import com.codelab.spaceTube.services.SpaceTubeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SpaceTubeController {

    private final SpaceTubeServiceImpl spaceTube=new SpaceTubeServiceImpl();

    @GetMapping("/tube")
    public ResponseEntity<?> getNasaDetails() {
        try {
            if (spaceTube == null) {

                return ResponseEntity.badRequest().body("No DATA Found!");

            } else {


                return new ResponseEntity<>(spaceTube.retrieveNasaData(), HttpStatus.OK);
            }

        } catch (Exception e) {

            log.info("==>" + e.getLocalizedMessage());

            return ResponseEntity.badRequest().body("Error occurred, unable to FETCH data.");
        }
    }
}
