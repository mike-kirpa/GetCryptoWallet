package com.overonix;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class App {
    public static final String API_TOKEN = "6ed9-9f02-0b72-bb93";
    public static final String FILE_HEADER = String.format("%s,%s,%s\n","Currency", "address", "ballance");
    public static final String FILE_NAME = "transactions.csv";


    public static void main(String[] args) {

        RestAssured.baseURI = "https://block.io/api/v2";
        Wallets response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/get_my_addresses/?api_key=" + API_TOKEN + "&page=")
                .then()
                .extract()
                .response()
                .as(Wallets.class);


        String result = null;
        if (args.length > 0){
            float limit = Float.parseFloat(args[0]);
            if (limit > 0){
                result = writeToScv(response, limit);
            }
        } else {
            result = writeToScv(response);
        }

        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(FILE_NAME);
                myWriter.write(result);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            try {
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static String writeToScv(Wallets response, float limit){
        List<Addresses> addresses = response.getData().getAddresses().stream().filter(c -> c.getAvailableBalance() >= limit).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(FILE_HEADER);
        for(Addresses adr: addresses) {
            sb.append(String.format(Locale.US,"%s,%s,%.8f%n", response.getData().getNetwork(), adr.getAddress(), adr.getAvailableBalance()));
        }
        return sb.toString();
    }

    private static String writeToScv(Wallets response) {
        List<Addresses> addresses = response.getData().getAddresses();
        StringBuilder sb = new StringBuilder();
        sb.append(FILE_HEADER);
        for(Addresses adr: addresses) {
            sb.append(String.format(Locale.US,"%s,%s,%.8f%n", response.getData().getNetwork(), adr.getAddress(), adr.getAvailableBalance()));
        }
        return sb.toString();
    }
}
