package com.example.Wayfarer.payloads;

public class AuthResponse {
    private int status;
    private String message;
    private Data data;

    public static class Data {
        private String token;
        private String firstName;
        private String lastName;
        private String email;

        public Data(String token, String firstName, String lastName, String email) {
            this.token = token;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        // Getters and setters
        public String getToken() { return token; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
    }

    public AuthResponse() {}

    public AuthResponse(int status, String message, Data data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }
}
