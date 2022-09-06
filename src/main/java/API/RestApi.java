package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Scanner;
import static io.restassured.RestAssured.given;

public class RestApi {
    public static void main(String[] args){
        //Scanner is used to get user input
        Scanner scanner = new Scanner(System.in);
        // boolean is used for the loop to ensure the continues of the loop
        boolean check = true;
        System.out.println("Note: To exit type \"exit\" at anytime");
        while (check) {
            // baseURL to connect to the webservice conatining the data
            String baseURI = RestAssured.baseURI = "https://restcountries.com/v3.1/name/";
            //RequestSpecification is used to avoid repetitive common request from the data using api methods
            RequestSpecification httpRequest = given();
            System.out.print("Enter the country Name:");
            //country represents the name of the countries entered
            String country = scanner.nextLine();
            //exit is the input to close the application
            if (country.equals("exit")) {
                check = false;
            } try {
                Response response = httpRequest.get(country);
                //json is used to extract a specific data string
                JsonPath json = response.jsonPath();
                String all = json.getString("capital");
                //replace is used to eliminate the brackets
                all = all.replaceAll("\\[", "");
                all = all.replaceAll("]", "");
                System.out.println("The Capital of " + country + " is " + all);
                //Exception e is used to eliminate any error that might be caused due to wrong user input
            }catch (Exception e){
                System.out.println("Wrong Entry, Try Again!");
            }
        }
        //End of the code
        System.out.println("Good bye");
    }

    }