import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

// Rappel (Partie 2) : verification d'une signature HMAC en la recalculant avec la meme cle.
public class HmacVerify {
    public static void main(String[] args) throws Exception {
        String secretKey = "mySecretKey123";
        String message = "Ceci est un document a signer.";
        // Signature recue (Base64). Passer une autre valeur en argument pour tester un rejet.
        String givenSignature = args.length > 0 ? args[0] : sign(secretKey, message);

        Mac hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        hmac.init(keySpec);
        byte[] recalculated = hmac.doFinal(message.getBytes());

        boolean isValid = Arrays.equals(Base64.getDecoder().decode(givenSignature), recalculated);

        System.out.println("Document : " + message);
        System.out.println("Signature recue : " + givenSignature);
        System.out.println("Signature valide ? " + isValid);
    }

    private static String sign(String key, String message) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        return Base64.getEncoder().encodeToString(mac.doFinal(message.getBytes()));
    }
}
