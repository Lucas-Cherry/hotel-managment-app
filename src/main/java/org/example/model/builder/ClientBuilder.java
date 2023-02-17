package org.example.model.builder;

import org.example.model.Client;

public class ClientBuilder {

    private Client client;
    public ClientBuilder () {
          client = new Client();
    }

    public ClientBuilder setId(int id) {
        this.client.setId(id);
        return this;
    }
    public ClientBuilder setFirstName(String firstName){
        this.client.setFirstName(firstName);
        return this;
    }
    public ClientBuilder setLastName(String lastName){
        this.client.setLastName(lastName);
        return this;
    }
    public ClientBuilder setPhoneNumber(String phoneNumber) {
        this.client.setPhoneNumber(phoneNumber);
        return this;
    }
    public ClientBuilder setEmail(String email){
        this.client.setEmail(email);
        return this;
    }

    public Client getClient() {
        return this.client;
    }

}
