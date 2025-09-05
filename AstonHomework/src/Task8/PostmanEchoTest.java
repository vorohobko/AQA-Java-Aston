package Task8;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Импорты для Apache HttpClient
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.CloseableHttpResponse;

public class PostmanEchoTest {

    private String sendRequest(String method, String urlString, String body) throws Exception {
        // Обработка PATCH запроса через Apache HttpClient
        if ("PATCH".equalsIgnoreCase(method)) {
            return sendPatchRequest(urlString, body);
        }
        
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        
        if (body != null) {
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream os = connection.getOutputStream()) {
                os.write(body.getBytes());
                os.flush();
            }
        }
        
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode);
        
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream())
        );
        StringBuilder response = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        return response.toString();
    }

    private String sendPatchRequest(String urlString, String body) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPatch patch = new HttpPatch(urlString);
            patch.setHeader("Content-Type", "application/json");
            
            if (body != null) {
                patch.setEntity(new StringEntity(body));
            }
            
            try (CloseableHttpResponse response = client.execute(patch)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(200, statusCode);
                return EntityUtils.toString(response.getEntity());
            }
        }
    }

    @Test
    public void testGetRequest() throws Exception {
        String response = sendRequest("GET", 
            "https://postman-echo.com/get?foo1=bar1&foo2=bar2", null);
        
        assertTrue("Должен содержать foo1 или bar1. Response: " + response, response.contains("foo1") || response.contains("bar1"));
        assertTrue("Должен содержать foo2 или bar2. Response: " + response,  response.contains("foo2") || response.contains("bar2"));
        assertTrue("Должен содержать URL. Response: " + response, response.contains("postman-echo.com/get"));
    }

    @Test
    public void testPostRequest() throws Exception {
        String requestBody = "{\"name\": \"John\", \"age\": 30}";
        String response = sendRequest("POST", 
            "https://postman-echo.com/post", requestBody);
        
        assertTrue("Должен содержать name или John. Response: " + response, response.contains("name") || response.contains("John"));
        assertTrue("Должен содержать age или 30. Response: " + response, response.contains("age") || response.contains("30"));
        assertTrue("Должен содержать URL. Response: " + response, response.contains("postman-echo.com/post"));
        assertTrue("Ответ должен быть JSON. Response: " + response, response.contains("{") && response.contains("}"));
    }

    @Test
    public void testPutRequest() throws Exception {
        String requestBody = "{\"title\": \"Test\", \"completed\": false}";
        String response = sendRequest("PUT", 
            "https://postman-echo.com/put", requestBody);
        
        assertTrue("Должен содержать title или Test", response.contains("title") || response.contains("Test"));
        assertTrue("Должен содержать completed или false", response.contains("completed") || response.contains("false"));
        assertTrue("Должен содержать URL", response.contains("postman-echo.com/put"));
        assertTrue("Ответ должен быть валидным JSON", response.contains("{") && response.contains("}"));
    }

    @Test
    public void testPatchRequest() throws Exception {
        String requestBody = "{\"field\": \"updated_value\"}";
        String response = sendRequest("PATCH", 
            "https://postman-echo.com/patch", requestBody);
        
        assertTrue(response.contains("field"));
    }

    @Test
    public void testDeleteRequest() throws Exception {
        String response = sendRequest("DELETE", 
            "https://postman-echo.com/delete", null);
        
        assertTrue("Должен содержать URL", response.contains("postman-echo.com/delete"));
    }
}