package org.ht.profile.repository;

import org.ht.profile.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    Profile findByUserName(String userName);
    Profile findByHtId(String htId);
}
