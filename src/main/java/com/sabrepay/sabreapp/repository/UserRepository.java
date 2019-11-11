/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sabrepay.sabreapp.model.User;

/**
 * 
 * UserRepository.java Created On: Oct 26, 2019 Created By: M1041768
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u.email_id, u.wallet_id, u.user_role, u.face_id from USER_INFORMATION u where u.USER_PASS =:pswrd and u.EMAIL_ID = :email", nativeQuery = true)
    List<Object> checkLogin(@Param("pswrd") String pwd, @Param("email") String email);
    
    @Query(value = "select u.email_id, u.wallet_id, u.user_role, u.face_id from USER_INFORMATION u where u.EMAIL_ID = :email", nativeQuery = true)
    List<Object> loginWithFaceID(@Param("email") String email);
    
    @Query(value = "select u.walletID from USER_INFORMATION u where u.EMAIL_ID = :email", nativeQuery = true)
    Optional<Object> getWalletID(@Param("email") String email);

}
