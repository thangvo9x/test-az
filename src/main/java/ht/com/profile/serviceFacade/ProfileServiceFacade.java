package ht.com.profile.serviceFacade;

import ht.com.profile.dto.ProfileResponse;
import ht.com.profile.dto.request.ProfileCreateRequest;
import ht.com.profile.dto.request.ProfileUpdateRequest;

import java.util.List;


public interface ProfileServiceFacade {
    ProfileResponse create(ProfileCreateRequest p);

    ProfileResponse findById(String id);

    List<ProfileResponse> findAll();

    ProfileResponse update(String hiId, ProfileUpdateRequest p);

    void delete(String htId) throws Exception;

    ProfileResponse find(String htId);
}
