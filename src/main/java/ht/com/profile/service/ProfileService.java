package ht.com.profile.service;

import ht.com.profile.converter.ProfileConverter;
import ht.com.profile.dto.request.ProfileCreateRequest;
import ht.com.profile.dto.request.ProfileUpdateRequest;
import ht.com.profile.model.Profile;
import ht.com.profile.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileConverter profileConverter;

    public ProfileService(ProfileRepository profileRepository, ProfileConverter profileConverter) {
        this.profileRepository = profileRepository;
        this.profileConverter = profileConverter;
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findById(String id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile findByHtId(String htId) {
        return profileRepository.findByHtId(htId);
    }

    public Profile findByUserName(String userName) {
        return profileRepository.findByUserName(userName);
    }

    public Profile create(ProfileCreateRequest profileRequest) {
        Profile profile = profileConverter.convert(profileRequest);
        profile.setHtId(profile.getUserName());
        return profileRepository.insert(profile);
    }

    public Profile update(String htId, ProfileUpdateRequest updatedProfile) {
        Profile profile = findByHtId(htId);
        BeanUtils.copyProperties(updatedProfile, profile);
        return profileRepository.save(profile);
    }

    public void delete(String htId) throws Exception {
        Profile profile = findByHtId(htId);
        if (profile == null) {
            throw new Exception("Profile does not exists.");
        }
        profileRepository.delete(profile);
    }

}
