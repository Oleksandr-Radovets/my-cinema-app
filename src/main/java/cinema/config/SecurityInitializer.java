package cinema.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import java.security.AuthProvider;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
AuthenticationManager authenticationManager;

AuthenticationManagerBuilder authenticationManagerBuilder;

}
