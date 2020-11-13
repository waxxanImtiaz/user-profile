package com.user.profile.user.profile.service;

import com.user.profile.user.profile.model.Account;

public interface AccountService {

    public Account create (Account account);

    void createVerificationToken(Account account, String token);

    void confirmAccount(String token);
}
