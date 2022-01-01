package com.example.jsonsavedemo.contorller;

import com.example.jsonsavedemo.Repository.ParentRepo;
import com.example.jsonsavedemo.model.Bio;
import com.example.jsonsavedemo.model.Child;
import com.example.jsonsavedemo.model.Parent;
import com.example.jsonsavedemo.payload.ApiResponse;
import com.example.jsonsavedemo.payload.BioUpdate;
import com.example.jsonsavedemo.payload.ErrorResponse;
import com.example.jsonsavedemo.service.iParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class TamLevelController {

    @SuppressWarnings("unused")
//    private static final Logger LOG = LoggerFactory.getLogger(TamLevelController.class);


    @Autowired
    ParentRepo parentRepo;

    @Autowired
    private iParentService iParentServiceObs;

//    @GetMapping("/tam-levels")
//    public List<Parent> getAllTamLevel() {
//        return parentRepo.findAll();
//    }

    @GetMapping("/get-json")
    public List<Parent> getAllJson() {

        return parentRepo.findAll();
    }
    @GetMapping("/get-json-by-text")
    public List<Parent> getAllJsonByText() {

        return parentRepo.getAllBioByText("fail");
    }


    @PostMapping("/stp-json")
    ResponseEntity<?> createStpFurniture(@RequestBody @Valid Parent parentRequest) {
        Parent result = iParentServiceObs.saveParent(parentRequest);
        if (result != null) {
            return ResponseEntity.ok(new ApiResponse(true, "Furniture Saved Successfully", result));
        } else {
            return new ResponseEntity(new ErrorResponse("Furniture Already Exists ! Please try again..", null),
                    HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/stp-json-bio-update")
    public ResponseEntity<?> updateParentBio(@RequestBody BioUpdate bioUpdate) {
        Parent result = iParentServiceObs.updateBio(bioUpdate);
        if (result != null) {
            return ResponseEntity.ok(new ApiResponse(true, " Bio text and comment Updated Successfully", result));
        } else {
            return new ResponseEntity(new ErrorResponse("Bio text and commentnot found", null), HttpStatus.BAD_REQUEST);
        }
    }


}
