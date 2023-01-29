package br.com.ada.itau950.pedidos.compras.config.security;

public class SecurityConstants {

    public static final String SECRET = "4453fd5e8408dc24655669d0a37ef72e";
    public static final long EXPIRATION_TIME = 1800_000; // 30 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
