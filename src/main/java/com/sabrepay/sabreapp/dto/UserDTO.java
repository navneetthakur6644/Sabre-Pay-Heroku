/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.sabrepay.sabreapp.util.PasswordEncryptionUtil;

/**
 * 
 * UserDTO.java Created On: Oct 26, 2019 Created By: M1041768
 */
public class UserDTO {
    /**
     * email
     */
    @NotNull
    @Email(message = "Email is a required field")
    private String email;
    /**
     * role
     */
    @NotNull(message = "Role is a required field")
    private String userRole;
    /**
     * faceID
     */
    private String faceID;
    /**
     * password
     */
    @NotNull(message = "Password is a required field")
    private String password;
    /**
     * walletID
     */
    @NotNull(message = "WalletID is a required field")
    private String walletID;

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = PasswordEncryptionUtil.hashPassword(password);
    }

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
}
