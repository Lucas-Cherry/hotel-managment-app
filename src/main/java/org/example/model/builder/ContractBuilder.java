package org.example.model.builder;

import org.example.model.Contract;
import org.example.model.Hotel;
import org.example.model.Worker;
import org.example.service.ContractService;

import java.util.Date;

public class ContractBuilder {
    private Contract contract;

    public ContractBuilder() {
        contract = new Contract();
    }

    public ContractBuilder setId(int id) {
        this.contract.setId(id);
        return this;
    }
    public ContractBuilder setContractType(String contractType) {
        this.contract.setContractType(contractType);
        return this;
    }
    public ContractBuilder setWorkerId(int workerId) {
        this.contract.setWorkerId(workerId);
        return this;
    }

    public ContractBuilder setHotelId(int hotelId) {
        this.contract.setHotelId(hotelId);
        return this;
    }

    public ContractBuilder setStartDate(Date startDate) {
        this.contract.setStartDate(startDate);
        return this;
    }

    public ContractBuilder setEndDate(Date endDate) {
        this.contract.setEndDate(endDate);
        return this;
    }

    public Contract getContract() {
        return this.contract;
    }
}
