package org.example.model.builder;

import org.example.model.Position;
import org.example.model.Worker;

public class WorkerBuilder {

    private Worker worker;

    public WorkerBuilder() {
        worker = new Worker();
    }

    public WorkerBuilder setId(int id) {
        this.worker.setId(id);
        return this;
    }
    public WorkerBuilder setFirstName(String firstName) {
        this.worker.setFirstName(firstName);
        return this;
    }
    public WorkerBuilder setLastName(String lastName) {
        this.worker.setLastName(lastName);
        return this;
    }

    public WorkerBuilder setPhoneNumber(String phoneNumber){
        this.worker.setPhoneNumber(phoneNumber);
        return this;
    }

    public WorkerBuilder setEmail(String email){
        this.worker.setEmail(email);
        return this;
    }

    public WorkerBuilder setPositionId(int positionId) {
        this.worker.setPositionId(positionId);
        return this;
    }

    public WorkerBuilder setCity(String city) {
        this.worker.setCity(city);
        return this;
    }
    public Worker getWorker() {
        return this.worker;
    }

}
