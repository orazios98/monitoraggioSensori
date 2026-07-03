package it.corsojava;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class SensoriApiClient {

    HttpClient client;

    public SensoriApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    // Legge tutti gli utenti
    // https://dummyjson.com/users
    public String getAllUsers() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://dummyjson.com/users"
                ))
                .GET()
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        if(response == null) {
            return "Errore";
        }

        int statusCode = response.statusCode();
        String bodyResponse = response.body();

        if(statusCode >= 200 && statusCode < 300) {
            return bodyResponse;
        } else {
            return "Errore: " + statusCode;
        }
    }
}
