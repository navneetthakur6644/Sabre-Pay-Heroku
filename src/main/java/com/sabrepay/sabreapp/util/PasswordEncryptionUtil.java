/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * PasswordEncryptionUtil.java Created On: Oct 26, 2019 Created By: M1041768
 */
@ConfigurationProperties("sabre-pay")
public class PasswordEncryptionUtil {

    private static String pwd_encryption;

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param password2
     * @return
     */
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, pwd_encryption);
    }

    /**
     * @return the pwd_encryption
     */
    public String getPwd_encryption() {
        return pwd_encryption;
    }

    /**
     * @param pwd_encryption
     *            the pwd_encryption to set
     */
    public void setPwd_encryption(String pwd_encryption) {
        this.pwd_encryption = pwd_encryption;
    }

}
