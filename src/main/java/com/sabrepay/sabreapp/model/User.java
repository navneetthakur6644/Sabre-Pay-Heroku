/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;

import org.hibernate.annotations.CreationTimestamp;

/**
 * 
 * User.java Created On: Oct 26, 2019 Created By: M1041768
 */
@Entity(name = "USER_INFORMATION")
public class User {

    /**
     * userId
     */
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer userId;
    /**
     * email
     */
    @Email
//    @NotNull(message = "Email is a required field")
    @Column(name = "EMAIL_ID", unique = true)
    private String email;
    /**
     * role
     */
//    @NotNull(message = "Role is a required field")
    @Column(name = "USER_ROLE")
    private String userRole;
    /**
     * faceID
     */
    @Column(name = "FACE_ID")
    private String faceID;
    /**
     * password
     */
//    @NotNull(message = "Password is a required field")
    @Column(name = "USER_PASS")
    private String pswrd;
    /**
     * walletID
     */
//    @NotNull(message = "WalletID is a required field")
    @Column(name = "WALLET_ID")
    private String walletID;

    @Null
    @CreationTimestamp
    @Column(name = "REGISTRATION_TIMESTAMP")
    private Date registrationTimeStamp;

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public String getPswrd() {
        return pswrd;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPswrd(String password) {
        this.pswrd = password;
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
     * @return the registrationTimeStamp
     */
    public Date getRegistrationTimeStamp() {
        return registrationTimeStamp;
    }

    /**
     * @param registrationTimeStamp
     *            the registrationTimeStamp to set
     */
    public void setRegistrationTimeStamp(Date registrationTimeStamp) {
        this.registrationTimeStamp = registrationTimeStamp;
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
