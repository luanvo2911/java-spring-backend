// package com.example.demospring.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demospring.model.Auth;

// @RestController
// public class LoginController {

//   // @Autowired
//   private AuthenticationManager authenticationManger;

//   @PostMapping("/login")
//   public String login(@RequestBody Auth auth){
//     Authentication authentication = authenticationManger.authenticate(
//       new UsernamePasswordAuthenticationToken(auth.username, auth.passw)
//     );

//     SecurityContextHolder.getContext().setAuthentication(authentication);
//     return "Login successfully";
//   }

  

// }
