/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 
 * FaceIdDTO.java Created On: Oct 27, 2019 Created By: M1041768
 */
public class FaceIdDTO {

    @NotNull
    @Email(message = "Email is a required field")
    private String email;

    @NotNull
    private String faceID;

    /**
     * @return the faceID
     */
    public String getFaceID() {
        return faceID;
    }

    /**
     * @param faceID
     *            the faceID to set
     */
    public void setFaceID(String faceID) {
        this.faceID = faceID;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
