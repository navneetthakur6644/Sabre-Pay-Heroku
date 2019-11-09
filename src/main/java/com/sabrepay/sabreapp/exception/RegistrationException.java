/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * PersistenceException.java
 * Created On: Oct 26, 2019
 * Created By: M1041768
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistrationException extends Exception {

    /**
     * 
     */
    public RegistrationException(String msg) {
        super(msg);
    }
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3793933651249505751L;

}
