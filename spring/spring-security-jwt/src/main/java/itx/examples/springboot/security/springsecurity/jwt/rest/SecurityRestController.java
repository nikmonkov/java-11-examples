package itx.examples.springboot.security.springsecurity.jwt.rest;

import itx.examples.springboot.security.springsecurity.jwt.services.UserAccessService;
import itx.examples.springboot.security.springsecurity.jwt.services.dto.LoginRequest;
import itx.examples.springboot.security.springsecurity.jwt.services.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/services/security/")
public class SecurityRestController {

    @Autowired
    private UserAccessService userAccessService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<UserData> login(@RequestBody LoginRequest loginRequest) {
        Optional<UserData> userData = userAccessService.login(httpSession.getId(), loginRequest);
        if (userData.isPresent()) {
            return ResponseEntity.ok().body(userData.get());
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        userAccessService.logout(httpSession.getId());
        return ResponseEntity.ok().build();
    }
}