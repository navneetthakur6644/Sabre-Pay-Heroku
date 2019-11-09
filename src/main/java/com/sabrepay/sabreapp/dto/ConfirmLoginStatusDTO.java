/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * LoginStatusDTO.java Created On: Oct 26, 2019 Created By: M1041768
 */
@JsonPropertyOrder("message")
public class ConfirmLoginStatusDTO {

    /**
     * @param email
     * @param walletID
     * @param userRole
     * @param faceID
     */
    public ConfirmLoginStatusDTO(String email, String walletID, String userRole, String mesage) {
        super();
        this.email = email;
        this.walletID = walletID;
        this.userRole = userRole;
        this.message = mesage;
    }

    /**
     * 
     */
    public ConfirmLoginStatusDTO() {
        super();
    }

    private String email;

    private String walletID;

    private String userRole;
    
    private String message;

    /**
     * @return the walletID
     */
    public String getWalletID() {
        return walletID;
    }

    /**
     * @param walletID
     *            the walletID to set
     */
    public void setWalletID(String walletID) {
        this.walletID = walletID;
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

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole
     *            the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
