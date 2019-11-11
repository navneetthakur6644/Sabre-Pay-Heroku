/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.sabrepay.sabreapp.dto.ConfirmLoginStatusDTO;
import com.sabrepay.sabreapp.dto.ConfirmUserDTO;
import com.sabrepay.sabreapp.dto.FaceIdDTO;
import com.sabrepay.sabreapp.dto.LoginDTO;
import com.sabrepay.sabreapp.dto.UserDTO;
import com.sabrepay.sabreapp.exception.AuthenticationFailureException;
import com.sabrepay.sabreapp.exception.InvalidRequestException;
import com.sabrepay.sabreapp.exception.RegistrationException;
import com.sabrepay.sabreapp.model.User;

/**
 * 
 * SabrePayService.java Created On: Oct 26, 2019 Created By: M1041768
 */
public interface SabrePayService {

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param user
     * @return
     * @throws RegistrationException 
     * @throws InvalidRequestException 
     */
    ConfirmUserDTO registerUser(@Valid UserDTO user) throws RegistrationException;

    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     * @throws AuthenticationFailureException 
     */
    ConfirmLoginStatusDTO checkAndLogin(@Valid LoginDTO login) throws AuthenticationFailureException;

    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     * @throws AuthenticationFailureException 
     */
    ConfirmLoginStatusDTO faceIdLoginImpl(FaceIdDTO login) throws AuthenticationFailureException;

    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     */
    ResponseEntity<Object> getBalance();

    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @return
     */
    ResponseEntity<Object> getTransactions();

    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @param emailID
     * @return
     */
    ResponseEntity<Object> getUserBalance(String emailID);

}
