# TP JWT avec Spring Boot et Spring Security

Code extrait des 3 enregistrements Webex (08/10/2026, Pr. A. Bousselham).

- `tp-jwt-spring/` : projet Spring Boot (Java 17+, Maven)
- `annexe-hmac/` : rappel HMAC de la Partie 2 (HMACExample, HmacVerify)
- `captures/` : captures de l'execution

## Lancer

    cd tp-jwt-spring
    mvn spring-boot:run

## Tester

    curl -X POST localhost:8080/auth/register -H "Content-Type: application/json" -d '{"email":"student@gmail.com","password":"123456"}'
    curl -X POST localhost:8080/auth/login    -H "Content-Type: application/json" -d '{"email":"student@gmail.com","password":"123456"}'
    curl localhost:8080/api/hello   -H "Authorization: Bearer <token>"
    curl localhost:8080/api/profile -H "Authorization: Bearer <token>"

Console H2 : http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:securitydbdemo`, user `sa`, mot de passe vide).

JwtFilter, SecurityConfig, AuthController et UserController reprennent le code du support de cours
(diapositives 18-33). Sans token ou avec un token invalide, /api/** repond 403 Forbidden.
