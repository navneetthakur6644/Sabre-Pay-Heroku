/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * InvalidRequestException.java
 * Created On: Oct 26, 2019
 * Created By: M1041768
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends Exception {

    /**
     * 
     */
    public InvalidRequestException(String msg) {
        super(msg);
    }
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4535460808696331815L;

}
