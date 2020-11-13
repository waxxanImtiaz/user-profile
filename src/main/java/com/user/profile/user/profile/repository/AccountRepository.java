package com.user.profile.user.profile.repository;


import com.user.profile.user.profile.model.Account;
import com.user.profile.user.profile.model.ConferenceUserDetails;
import com.user.profile.user.profile.model.VerificationToken;

public interface AccountRepository {
    public Account create (Account account);

    void saveToken(VerificationToken verificationToken);

    VerificationToken findByToken(String token);

    Account findByUsername(String username);

    void createUserDetails(ConferenceUserDetails userDetails);

    void createAuthorities(ConferenceUserDetails userDetails);

    void delete(Account account);

    void deleteToken(String token);
}
