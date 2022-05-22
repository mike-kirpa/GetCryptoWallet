package com.overonix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Addresses {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("address")
    private String address;
    @JsonProperty("label")
    private String label;
    @JsonProperty("pending_received_balance")
    private float pendingReceivedBalance;
    @JsonProperty("available_balance")
    private float availableBalance;
    @JsonProperty("is_segwit")
    private boolean isSegwit;

    @Override
    public String toString() {
        return "Addresses{" +
                "address='" + address + '\'' +
                ", availableBalance=" + availableBalance +
                '}';
    }

    public Addresses(){};


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getPendingReceivedBalance() {
        return pendingReceivedBalance;
    }

    public void setPendingReceivedBalance(float pendingReceivedBalance) {
        this.pendingReceivedBalance = pendingReceivedBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public boolean isSegwit() {
        return isSegwit;
    }

    public void setSegwit(boolean segwit) {
        this.isSegwit = segwit;
    }
}
