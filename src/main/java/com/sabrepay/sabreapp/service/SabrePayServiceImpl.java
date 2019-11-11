/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.sabrepay.sabreapp.dto.ConfirmLoginStatusDTO;
import com.sabrepay.sabreapp.dto.ConfirmUserDTO;
import com.sabrepay.sabreapp.dto.FaceIdDTO;
import com.sabrepay.sabreapp.dto.LoginDTO;
import com.sabrepay.sabreapp.dto.UserDTO;
import com.sabrepay.sabreapp.exception.AuthenticationFailureException;
import com.sabrepay.sabreapp.exception.InvalidRequestException;
import com.sabrepay.sabreapp.exception.RegistrationException;
import com.sabrepay.sabreapp.model.User;
import com.sabrepay.sabreapp.repository.UserRepository;

/**
 * 
 * SabrePayService.java Created On: Oct 26, 2019 Created By: M1041768
 */
@Service
public class SabrePayServiceImpl implements SabrePayService {

    @Autowired
    UserRepository userDAO;

    @Autowired
    RestTemplate restTemplate;

    private static final String AUTH_TOKEN = "a0e85n53sr-exCsumN7fCeurmXkx+vrnElMdQhIKZ9QOOORwB6CKS4=";

    private static final String BALANCE_URL = "https://console-ko.kaleido.io/api/v1/ledger/k0z7nyu64x/k0xpgllhtz/tokens/contracts/0xe9eF258925b3A6B57c346785EEee063d199a3950/balanceOf/0xd737b836064339e1230cf43e6d0892d15df9f7ad";

    private static final String TRANSACTION_URL = "https://console-ko.kaleido.io/api/v1/ledger/k0z7nyu64x/k0xpgllhtz/transactions";

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param user
     * @return
     * @throws RegistrationException
     * @throws InvalidRequestException
     */
    @Override
    public ConfirmUserDTO registerUser(UserDTO userDTO) throws RegistrationException {
        User savedUser = null;
        User user = mapDTOtoEntity(userDTO);
        try {
            savedUser = userDAO.save(user);
        }
        catch (DataIntegrityViolationException e) {
            throw new RegistrationException("User with username " + user.getEmail() + " already exists!");
        }
        catch (Exception e) {
            throw new RegistrationException("Couldn't register user");
        }
        return mapSavedUserToDTO(savedUser);
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param userDTO
     * @return
     */
    private User mapDTOtoEntity(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFaceID(userDTO.getFaceID());
        user.setPswrd(userDTO.getPassword());
        user.setUserRole(userDTO.getUserRole());
        user.setWalletID(userDTO.getWalletID());
        return user;
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param savedUser
     * @return
     */
    private ConfirmUserDTO mapSavedUserToDTO(User savedUser) {
        ConfirmUserDTO confirmUser = null;
        if (savedUser != null) {
            confirmUser = new ConfirmUserDTO();
            confirmUser.setUserName(savedUser.getEmail());
            confirmUser.setRole(savedUser.getUserRole());
            confirmUser.setResult("User with email " + savedUser.getEmail() + " registered successfully!");
        }
        return confirmUser;
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     * @throws AuthenticationFailureException
     */
    @Override
    public ConfirmLoginStatusDTO checkAndLogin(@Valid LoginDTO login) throws AuthenticationFailureException {
        List<Object> authenticatedUserDetails = null;
        try {
            authenticatedUserDetails = (List<Object>) userDAO.checkLogin(login.getPassword(), login.getEmail());
        }
        catch (Exception e) {
            throw new AuthenticationFailureException("Login Failed");
        }
        if (!CollectionUtils.isEmpty(authenticatedUserDetails)) {
            return mapRetrievedDataToDTO(authenticatedUserDetails);
        }
        else {
            throw new AuthenticationFailureException("User Not Authorized");
        }
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param authenticatedUserDetails
     * @return
     */
    private ConfirmLoginStatusDTO mapRetrievedDataToDTO(List<Object> authenticatedUserDetails) {
        ConfirmLoginStatusDTO confirmLogin = null;
        Iterator itr = authenticatedUserDetails.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String emailID = String.valueOf(obj[0]);
            String walletID = String.valueOf(obj[1]);
            String userRole = String.valueOf(obj[2]);
            String faceID = String.valueOf(obj[3]);
            confirmLogin = new ConfirmLoginStatusDTO(emailID, walletID, userRole, "Authentication Successful", faceID);
        }
        return confirmLogin;

    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     * @throws AuthenticationFailureException
     */
    @Override
    public ConfirmLoginStatusDTO faceIdLoginImpl(FaceIdDTO login) throws AuthenticationFailureException {
        List<Object> loggedInUserDetails = userDAO.loginWithFaceID(login.getEmail());
        if (!CollectionUtils.isEmpty(loggedInUserDetails)) {
            return mapRetrievedDataToDTO(loggedInUserDetails);
        }
        else {
            throw new AuthenticationFailureException("User not Authenticated");
        }
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @param login
     * @return
     */
    @Override
    public ResponseEntity<Object> getBalance() {
        return restTemplate.exchange(BALANCE_URL, HttpMethod.GET, setHeaderAndAuthToken(), Object.class);
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @return
     */
    @Override
    public ResponseEntity<Object> getTransactions() {
        return restTemplate.exchange(TRANSACTION_URL, HttpMethod.GET, setHeaderAndAuthToken(), Object.class);
    }
    
    /**
     * Description : 
     * <<WRITE DESCRIPTION HERE>>
     * 
     * @param emailID
     * @return
     */
    @Override
    public ResponseEntity<Object> getUserBalance(String emailID) {
        // TODO Auto-generated method stub
        Optional<Object> walletID = userDAO.getWalletID(emailID);
        String URL = "https://console-ko.kaleido.io/api/v1/ledger/k0z7nyu64x/k0xpgllhtz/tokens/contracts/0xe9eF258925b3A6B57c346785EEee063d199a3950/balanceOf/0xd737b836064339e1230cf43e6d0892d15df9f7ad";
        restTemplate.exchange(TRANSACTION_URL, HttpMethod.GET, setHeaderAndAuthToken(), Object.class);
        return null;
    }

    /**
     * Description : <<WRITE DESCRIPTION HERE>>
     * 
     * @return
     */
    private HttpEntity<String> setHeaderAndAuthToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }

}
