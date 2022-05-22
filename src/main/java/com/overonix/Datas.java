package com.overonix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datas {

    public Datas(){};

    public Datas(String network, List<Addresses> addresses) {
        this.network = network;
        this.addresses = addresses;
    }

    @JsonProperty("network")
    String network;

    @JsonProperty("addresses")
    List<Addresses> addresses = null;

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }
}
