/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.sabrepay.sabreapp.util.PasswordEncryptionUtil;

/**
 * 
 * LoginStatusDTO.java Created On: Oct 26, 2019 Created By: M1041768
 */
public class LoginDTO {

    /**
     * email
     */
    @NotNull
    @Email
    private String email;
    /**
     * password
     */
    @NotNull
    private String password;

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
        ;
    }

}
