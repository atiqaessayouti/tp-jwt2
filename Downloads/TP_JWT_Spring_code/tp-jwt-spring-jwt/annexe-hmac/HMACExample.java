import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

// Rappel (Partie 2) : signature HMAC-SHA256, le meme principe que la signature d'un JWT HS256/HS384.
public class HMACExample {

    public static void main(String[] args) throws Exception {

        String message = "Bonjour ENSET";
        String secret = "ma-cle-secrete";

        // Creation de la cle secrete
        SecretKeySpec secretKey =
                new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

        // Initialisation de HMAC
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);

        // Calcul du HMAC
        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));

        System.out.println("Message : " + message);
        System.out.println("HMAC (Base64) : " + Base64.getEncoder().encodeToString(hmacBytes));
    }
}
