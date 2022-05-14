//package com.leaper.securityConfiguration;
//
//import com.leaper.repository.UserRepository;
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityService implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        return (UserDetails) userRepository.getUserByLogin(login).orElseThrow(() ->
//                new UsernameNotFoundException("User not found"));
//
////        return User.builder()
////                .username(login)
////                .password("password")
////                .authorities(Collections.singleton(Role.STUDENT))
////                .isAccountNonExpired(true)
////                .isAccountNonLocked(true)
////                .isCredentialsNonExpired(true)
////                .isEnabled(true)
////                .build();
//    }
//}
