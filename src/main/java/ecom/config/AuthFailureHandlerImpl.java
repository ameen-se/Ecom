package ecom.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import ecom.entities.UserDtls;
import ecom.repository.UserRepository;
import ecom.service.UserService;
import ecom.util.AppConstant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String email = request.getParameter("username");
        UserDtls userDtls = userRepository.findByEmail(email);

        if (userDtls == null) {
            super.setDefaultFailureUrl("/signin?error=Invalid email or password");
            super.onAuthenticationFailure(request, response, exception);
            return;
        }

        if ((userDtls.getIsEnabled() != null) && !userDtls.getIsEnabled()) {
            exception = new LockedException("Account inactive");
        }
        else if ((userDtls.getAccountNonBlocked() != null) && !userDtls.getAccountNonBlocked()) {
            if (userService.unlockAccountTimeExpired(userDtls)) {
                exception = new LockedException("Account is unlocked !! Please try to login");
            } else {
                exception = new LockedException("Account locked !! Please try after sometimes");
            }
        }
        else {
            int failedAttempts = (userDtls.getFailedAttempt() != null) ? userDtls.getFailedAttempt() : 0;

            if (failedAttempts < AppConstant.ATTEMPT_TIME) {
                userService.increaseFailedAttempt(userDtls);
            } else {
                userService.userAccountLock(userDtls);
                exception = new LockedException("Account is locked !! failed attempt " + (AppConstant.ATTEMPT_TIME + 1));
            }
        }

        super.setDefaultFailureUrl("/signin?error");
        super.onAuthenticationFailure(request, response, exception);
    }
}
