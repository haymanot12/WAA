import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mvc.Account;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class ContactsRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8090);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneContact() {
        // add the contact to be fetched
        //books.put("A7474", new Book("A7474", "Brown", "Atlas", 23416));
        //accounts.put("A7474", new Account("A7474", "Brown", 23416));
        //accounts.put("A627363", new Account("A627363", "Jones", 23416));


        Account book = new Account("A74744", "Brown",23416);
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/accounts").then()
                .statusCode(200);
        // test getting the contact
        given()
                .when()
                .get("accounts/A74744")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("deposit",equalTo(null))
                .body("accountNumber",equalTo("A74744"))
                .body("accountHolder",equalTo("Brown"))
                .body("balance",equalTo("23416"))
                .body("withdraw",equalTo(null));
        //cleanup
        given()
                .when()
                .delete("accounts/A74744");
    }
/*
    @Test
    public void testDeleteContact() {
        // add the contact to be deleted book
        //books.put("A627363", new Book("A627363", "Jones", "Fountain", "23416"));

        Account book = new Account("A627363", "Jones", "Fountain", "23416");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        given()
                .when()
                .delete("books/A627363");

        given()
                .when()
                .get("books/A627363")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Book with isbn= A627363 is not available"));
    }

    @Test
    public void testAddContact() {
        // add the contact
        Account book = new Account("A627363", "Jones", "Fountain", "23416");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // get the contact and verify
        given()
                .when()
                .get("books/A627363")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("A627363"))
                .body("author",equalTo("Jones"))
                .body("title",equalTo("Fountain"))
                .body("price",equalTo("23416"));
        //cleanup
        given()
                .when()
                .delete("books/A627363");
    }

    @Test
    public void testUpdateContact() {
        // add the contact
        Account book = new Account("A627363", "Jones", "Fountain", "23416");
        Account book2 = new Account("A627363", "Johnson", "Fountain", "23416");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        //update contact
        given()
                .contentType("application/json")
                .body(book2)
                .when().put("/books/"+book2.getIsbn()).then()
                .statusCode(200);
        // get the contact and verify
        given()
                .when()
                .get("books/A627363")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("A627363"))
                .body("author",equalTo("Johnson"))
                .body("title",equalTo("Fountain"))
                .body("price",equalTo("23416"));
        //cleanup
        given()
                .when()
                .delete("books/A627363");
    }

    @Test
    public void testGetAllContacts() {
        // add the books
        Account book = new Account("A775", "Jones", "atlas", "23416");
        Account book2 = new Account("A627363", "Johnson", "Fountain", "23416");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("/books").then()
                .statusCode(200);

        // get all books and verify
        given()
                .when()
                .get("books")
                .then()
                .statusCode(200)
                .and()
                .body("books.isbn", hasItems("A775", "A627363"))
                .body("books.author",hasItems("Jones", "Johnson"))
                .body("books.title",hasItems("atlas", "Fountain"))
                .body("books.price",hasItems("23416", "23416"));
        //cleanup
        given()
                .when()
                .delete("books/A775");
        given()
                .when()
                .delete("books/A627363");
    }*/
}
