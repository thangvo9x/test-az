package ht.com.profile.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import static ht.com.profile.constants.DateTime.BIRTHDAY_PATTERN;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateRequest {
    private String userName;
    private String gender;
    private List<String> nationalities;
    @DateTimeFormat(pattern = BIRTHDAY_PATTERN)
    private Date dob;
    private String fullName;
    private String pob;
    private String hometown;
    private String permanentAddress;
}
