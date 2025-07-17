//package com.akilan.application_tracking_system.Service;
//
//import com.akilan.application_tracking_system.DTO.Role;
//import com.akilan.application_tracking_system.Entity.Users;
//import com.akilan.application_tracking_system.Repo.UserDetailsJpaRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AdminUserInitializer  {
//
//    @Bean
//    public CommandLineRunner createAdminUser(UserDetailsJpaRepository userDetailsJpaRepository,
//                                             PasswordEncoder passwordEncoder){
//        return args -> {
//            if(userDetailsJpaRepository.findByUserName("akilan").isEmpty()){
//                Users admin = new Users();
//                admin.setUsername("akilan");
//                admin.setPassword(passwordEncoder.encode("admin1234"));
//                admin.setRole(Role.ADMIN);
//
//                userDetailsJpaRepository.save(admin);
//                System.out.println("Default admin created");
//            }
//
//            if(userDetailsJpaRepository.findByUserName("user").isEmpty()){
//                Users admin = new Users();
//                admin.setUsername("user");
//                admin.setPassword(passwordEncoder.encode("user123"));
//                admin.setRole(Role.USER);
//
//                userDetailsJpaRepository.save(admin);
//                System.out.println("Default user created");
//            }
//        };
//    }
//}
