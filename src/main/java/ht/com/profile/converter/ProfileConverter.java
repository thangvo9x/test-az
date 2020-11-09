package ht.com.profile.converter;

import ht.com.profile.dto.ProfileResponse;
import ht.com.profile.dto.request.ProfileCreateRequest;
import ht.com.profile.model.Profile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter {
    public Profile convert(ProfileCreateRequest profileRequest) {
        Profile profile = new Profile();
        BeanUtils.copyProperties(profileRequest, profile);
        return profile;
    }

    public ProfileResponse convert(Profile profile) {
        ProfileResponse profileResponse = new ProfileResponse();
        BeanUtils.copyProperties(profile, profileResponse);
        return profileResponse;
    }
}
