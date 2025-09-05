import io.restassured.RestAssured;
import io.restassured.response.Response;
import Task8.PostmanEchoTest;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Запускаем пример запроса...");
        
        Response response = RestAssured.get("https://postman-echo.com/get?test=hello");
        
        System.out.println("Код ответа: " + response.getStatusCode());
        System.out.println("Тело ответа: " + response.getBody().asString());
        System.out.println("Готово!");
    }
}