import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class ConsumoApi {

	String moeda = "";
	
	public static BagOfPrimitives obterDados(String Url) throws Exception{
		
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Url))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } //catch ()

        String json = response.body();
        Gson gson = new Gson();
    	BagOfPrimitives BoF = gson.fromJson(json, BagOfPrimitives.class);
    	return BoF;
    }
}
