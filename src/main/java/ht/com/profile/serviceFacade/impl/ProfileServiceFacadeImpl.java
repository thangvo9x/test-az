package ht.com.profile.serviceFacade.impl;

import ht.com.profile.converter.ProfileConverter;
import ht.com.profile.dto.ProfileResponse;
import ht.com.profile.dto.request.ProfileCreateRequest;
import ht.com.profile.dto.request.ProfileUpdateRequest;
import ht.com.profile.model.Profile;
import ht.com.profile.service.ProfileService;
import ht.com.profile.serviceFacade.ProfileServiceFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileServiceFacadeImpl implements ProfileServiceFacade {

    private final ProfileService profileService;
    private final ProfileConverter profileConverter;

    public ProfileServiceFacadeImpl(ProfileService profileService, ProfileConverter profileConverter) {
        this.profileService = profileService;
        this.profileConverter = profileConverter;
    }

    @Override
    public ProfileResponse create(ProfileCreateRequest profileRequest) {
        return profileConverter.convert(profileService.create(profileRequest));
    }

    @Override
    public ProfileResponse findById(String id) {
        return profileConverter.convert(profileService.findById(id));
    }

    @Override
    public ProfileResponse find(String htId) {
        return profileConverter.convert(profileService.findByHtId(htId));

    }

    @Override
    public List<ProfileResponse> findAll() {
        List<Profile> list = profileService.findAll();
        return list.stream().map(profileConverter::convert).collect(Collectors.toList());
    }

    @Override
    public ProfileResponse update(String id, ProfileUpdateRequest profileRequest) {
        return profileConverter.convert(profileService.update(id, profileRequest));
    }

    @Override
    public void delete(String id) throws Exception {
        profileService.delete(id);
    }

}
