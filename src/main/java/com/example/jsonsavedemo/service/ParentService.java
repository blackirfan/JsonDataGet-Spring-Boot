package com.example.jsonsavedemo.service;

import com.example.jsonsavedemo.Repository.ParentRepo;
import com.example.jsonsavedemo.model.Bio;
import com.example.jsonsavedemo.model.Parent;
import com.example.jsonsavedemo.payload.BioUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService implements iParentService{

    @Autowired
    private ParentRepo parentRepo;
    @Override
    public Parent saveParent(Parent parentRequest) {
        Parent parent = new Parent();
        parent = parentRepo.save(parentRequest);


        return parent;
    }

    @Override
    public Parent updateBio(BioUpdate bioUpdate) {
        Integer id= bioUpdate.getId();
        Parent parent = new Parent();
        Bio bio = new Bio();
        parent = parentRepo.getById(id);
        bio = parent.getBio();
        bio.setText(bioUpdate.getText());
        bio.setComment(bioUpdate.getComment());
        parent.setBio(bio);
        return parentRepo.save(parent);
    }
}
