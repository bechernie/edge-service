package com.github.bechernie.edgeservice.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("user")
    public Mono<User> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        return Mono.just(
                new User(
                        oidcUser.getPreferredUsername(),
                        oidcUser.getGivenName(),
                        oidcUser.getFamilyName(),
                        oidcUser.getClaimAsStringList("roles")
                )
        );
    }
}
