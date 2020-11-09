package ht.com.profile.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String userName;
    private String gender;
    private List<String> nationalities;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dob;
    private String fullName;
    private String pob;
    private String hometown;
    private String permanentAddress;
    private Date lastModifiedDate;
}
