package com.example.jsonsavedemo.service;

import com.example.jsonsavedemo.model.Parent;
import com.example.jsonsavedemo.payload.BioUpdate;

public interface iParentService {
    Parent saveParent(Parent parentRequest);

    Parent updateBio(BioUpdate bioUpdate);
}
