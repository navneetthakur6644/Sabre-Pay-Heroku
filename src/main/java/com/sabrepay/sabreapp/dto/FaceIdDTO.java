/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * FaceIdDTO.java Created On: Oct 27, 2019 Created By: M1041768
 */
public class FaceIdDTO {

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

}
