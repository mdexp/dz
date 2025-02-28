import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
    private static final String API_KEY = "d318ed35aea7730245c830e7";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
//програма яка виводить ціни валют.
    public static void main(String[] args) {
        String baseCurrency = "USD";
        String response = getExchangeRates(baseCurrency);
        System.out.println(response);
    }

    public static String getExchangeRates(String baseCurrency) {
        HttpClient httpClient = HttpClients.createDefault();
        String urlString = BASE_URL + baseCurrency;
        HttpGet request = new HttpGet(urlString);

        try {
            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : "No response received";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}