package org.example.model.builder;

import org.example.model.Position;

public class PositionBuilder {

    private Position position;

    public PositionBuilder() {
        position = new Position();
    }

    public PositionBuilder setId(int id) {
        this.position.setId(id);
        return this;
    }
    public PositionBuilder setName(String name) {
        this.position.setName(name);
        return this;
    }

    public PositionBuilder setSalary(int salary) {
        this.position.setSalary(salary);
        return this;
    }

    public PositionBuilder setSeniority(String seniority) {
        this.position.setSeniority(seniority);
        return this;
    }

    public Position getPosition() {
        return this.position;
    }
}
