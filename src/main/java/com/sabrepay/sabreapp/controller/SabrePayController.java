/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sabrepay.sabreapp.dto.ConfirmLoginStatusDTO;
import com.sabrepay.sabreapp.dto.ConfirmUserDTO;
import com.sabrepay.sabreapp.dto.FaceIdDTO;
import com.sabrepay.sabreapp.dto.LoginDTO;
import com.sabrepay.sabreapp.dto.UserDTO;
import com.sabrepay.sabreapp.exception.AuthenticationFailureException;
import com.sabrepay.sabreapp.exception.RegistrationException;
import com.sabrepay.sabreapp.service.SabrePayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * SabrePayController.java Created On: Oct 26, 2019 Created By: M1041768
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "Sabre Pay", description = "Operations pertaining User Registration and Login")
public class SabrePayController {

    private static final String ACCESS_TOKEN = "a0e85n53sr-exCsumN7fCeurmXkx+vrnElMdQhIKZ9QOOORwB6CKS4=";

    @Autowired
    SabrePayService sabreService;

    @ApiOperation(value = "Register user", response = ConfirmUserDTO.class)
    @PostMapping(value = "/api/registerUser")
    public ResponseEntity<ConfirmUserDTO> registerUser(@Valid @RequestBody UserDTO user) throws RegistrationException {
        ConfirmUserDTO registeredUser = sabreService.registerUser(user);
        if (registeredUser != null) {
            return new ResponseEntity<ConfirmUserDTO>(registeredUser, HttpStatus.OK);
        }
        else {
            throw new RegistrationException("DB Issue Couldn't register user");
        }
    }

    @ApiOperation(value = "Login user with username and password", response = ConfirmLoginStatusDTO.class)
    @PostMapping(value = "/api/login")
    public ResponseEntity<ConfirmLoginStatusDTO> login(@RequestBody @Valid LoginDTO login)
        throws AuthenticationFailureException {
        ConfirmLoginStatusDTO loginStatus = sabreService.checkAndLogin(login);
        return new ResponseEntity<ConfirmLoginStatusDTO>(loginStatus, HttpStatus.OK);

    }

    @ApiOperation(value = "Login user with faceID", response = ConfirmLoginStatusDTO.class)
    @PostMapping(value = "/api/faceIdLogin")
    public ResponseEntity<ConfirmLoginStatusDTO> loginByFaceId(@RequestBody @Valid FaceIdDTO login)
        throws AuthenticationFailureException {
        ConfirmLoginStatusDTO loginStatus = sabreService.faceIdLoginImpl(login);
        return new ResponseEntity<ConfirmLoginStatusDTO>(loginStatus, HttpStatus.OK);

    }

    @ApiOperation(value = "Server health checkup", response = ConfirmLoginStatusDTO.class)
    @GetMapping(path = "/api/status")
    public String getServerStatus() {
        return "Server is up and running.";
    }

    @ApiOperation(value = "Wallet ID using API URL")
    @GetMapping(path = "/api/walletId")
    public ResponseEntity<Object> getWalletId(String apiURL) throws RegistrationException {
        final String uri = "https://console-ko.kaleido.io/api/v1/consortia/k0z7nyu64x/environments/k0xpgllhtz/nodes/k0vpc8ky3u/eth/accounts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json");
        headers.setContentType(mediaType);
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);
        String requestJson = "{ \"password\": \"anything\" }";
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        ResponseEntity<Object> result;
        try {
            result = restTemplate.exchange(uri, HttpMethod.POST, entity, Object.class);
            if (result != null) {
                return result;
            }
        }
        catch (RestClientException e) {
            throw new RegistrationException("Couldn't create wallet account");
        }
        return null;
    }

    @ApiOperation(value = "Get Sabre Account's Current Balance")
    @GetMapping(value = "/api/getBalance")
    public ResponseEntity<Object> getBalance() {
        ResponseEntity<Object> accountBalance = sabreService.getBalance();
        return accountBalance;
    }
    
    @ApiOperation(value = "Get last 25 transactions of the consortia")
    @GetMapping(value = "/api/getTransactions")
    public ResponseEntity<Object> getLastTransactions() {
        ResponseEntity<Object> lastTransactions = sabreService.getTransactions();
        return lastTransactions;
    }

    /**
     * @return the sabreService
     */
    public SabrePayService getSabreService() {
        return sabreService;
    }

    /**
     * @param sabreService
     *            the sabreService to set
     */
    public void setSabreService(SabrePayService sabreService) {
        this.sabreService = sabreService;
    }

}
