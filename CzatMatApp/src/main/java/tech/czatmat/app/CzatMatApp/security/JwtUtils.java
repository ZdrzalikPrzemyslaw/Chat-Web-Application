package tech.czatmat.app.CzatMatApp.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    // TODO: 03.12.2020 Zrobić żeby klucz i timeout bral sie z pliku
    // @Value("${tech.czatMat.app.CzatMapApp.jwtSecret}")
    private final String jwtSecret = "superScisleTajnyKlucz";

    // @Value("${tech.czatMat.app.CzatMapApp.jwtExpirationMs}")
    private final int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            ex.getStackTrace();
        }

        return false;
    }

}
