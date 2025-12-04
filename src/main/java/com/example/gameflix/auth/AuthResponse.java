
package com.example.gameflix.auth;

public class AuthResponse {
    private String message;

    public AuthResponse() {}
    public AuthResponse(String m){ this.message=m; }

    public String getMessage(){ return message; }
    public void setMessage(String m){ this.message=m; }
}
