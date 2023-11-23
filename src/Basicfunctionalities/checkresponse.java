package Basicfunctionalities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.openqa.selenium.WebDriver;
import java.net.http.HttpResponse;

public class checkresponse {
     
     public static void code(WebDriver driver){
        String currentUrl = driver.getCurrentUrl();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(currentUrl))
                                .build();
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.request());
        } catch (IOException e) {
          
            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }  
            
                           

     }

}
