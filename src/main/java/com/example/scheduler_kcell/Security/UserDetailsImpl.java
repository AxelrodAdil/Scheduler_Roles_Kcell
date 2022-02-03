package com.example.scheduler_kcell.Security;

import com.example.scheduler_kcell.Model.model_roles;
import com.example.scheduler_kcell.Repo.repo_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsImpl")
public class UserDetailsImpl implements UserDetailsService {
    private final repo_user user_repository;

    @Autowired
    public UserDetailsImpl(repo_user user_repository) {
        this.user_repository = user_repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        model_roles user = user_repository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("Error! Don't exist."));
        return SecurityUser.from_Model_roles(user);
    }
}