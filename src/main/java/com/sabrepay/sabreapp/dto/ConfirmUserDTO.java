/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ConfirmUserDTO.java Created On: Oct 26, 2019 Created By: M1041768
 */
@JsonPropertyOrder("message")
public class ConfirmUserDTO {

    /**
     * userName
     */
    private String userName;
    /**
     * role
     */
    private String role;

    /**
     * message
     */
    private String result;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the message
     */
    public String getResult() {
        return result;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setResult(String result) {
        this.result = result;
    }

}
