package gov.iti.jets.ecommerce.business.servicesImpl;

import gov.iti.jets.ecommerce.persistence.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

//    minimum requirement for jwt is 256bit
    private static final String SECRET_KEY = "77217A25432A462D4A614E645267556B58703273357638782F413F4428472B4B";
    public String extractUsername(String token) {
//        subject should be username or email of my user
        return extractClaim(token,Claims::getSubject);
    }
    public  <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    public String generateToken(User userDetails){
        return generateToken(new HashMap<>() , userDetails);
    }
    public String generateToken(Map<String , Object> extraClaims , User userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .claim("role",userDetails.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis())) //means when this Claim was Created
                .setExpiration(new Date(System.currentTimeMillis() + 1000 *60 *24)) // 24 h + 1000 mls
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact(); //compact will generate and return the token
    }


//    validate that this token belong to this userDetails
    public boolean isTokenValid(String token , UserDetails userDetails){
        final  String userName = extractUsername(token);
        return  (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token , Claims::getExpiration);
    }

    //    Claims is an extra data send with jwt
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())//setSigningKey uses to create the signature (secret key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
