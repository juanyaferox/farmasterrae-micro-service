package dev.juanyaferox.infrastructure.api.controller;

import dev.juanyaferox.application.core.usecase.profile.AssignProfileUseCase;
import dev.juanyaferox.application.core.usecase.profile.CreateProfileUseCase;
import dev.juanyaferox.application.core.usecase.profile.DeleteProfileUseCase;
import dev.juanyaferox.application.core.usecase.profile.UpdateProfileUseCase;
import dev.juanyaferox.infrastructure.api.dto.profile.CreateProfileApiRequest;
import dev.juanyaferox.infrastructure.api.dto.profile.UpdateProfileApiRequest;
import dev.juanyaferox.infrastructure.api.mapper.ProfileApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping ("/api/profile")
public class ProfileController {

    @Autowired
    ProfileApiMapper profileMapper;

    @Autowired
    CreateProfileUseCase createProfileUseCase;

    @Autowired
    UpdateProfileUseCase updateProfileUseCase;

    @Autowired
    AssignProfileUseCase assignProfileUseCase;

    @Autowired
    DeleteProfileUseCase deleteProfileUseCase;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void createProfile(@RequestBody CreateProfileApiRequest request) {
        createProfileUseCase.execute(profileMapper.createProfileCommandFromCreateProfileApiRequest(request));
    }

    @PutMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void updateProfile(@RequestBody UpdateProfileApiRequest request) {
        updateProfileUseCase.execute(profileMapper.updateProfileCommandFromUpdateProfileApiRequest(request));
    }

    @PutMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void assignProfile(@RequestParam UUID idUser, @RequestParam Long idProfile) {
        assignProfileUseCase.execute(idUser, idProfile);
    }

    @DeleteMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void updateProfile(@RequestParam Long idToDelete, @RequestParam Long idToAssign) {
        deleteProfileUseCase.execute(idToDelete, idToAssign);
    }
}
