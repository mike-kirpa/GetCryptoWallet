package com.overonix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Wallets {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private Datas data;

    public Wallets(String status, Datas data) {
        this.status = status;
        this.data = data;
    }

    public Wallets(){};


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }
}
