import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mvc.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class ContactsRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8090);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }
/*
    @Test
    public void testGetOneContact() {
        // add the contact to be fetched
        //books.put("A7474", new Book("A7474", "Brown", "Atlas", 23416));

        Book book = new Book("A7474", "Brown", "Atlas", 23416.0);
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the contact
        given()
                .when()
                .get("books/A7474")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("A7474"))
                .body("author",equalTo("Brown"))
                .body("title",equalTo("Atlas"))
                .body("price",equalTo(23416.0f));
        //cleanup
        given()
                .when()
                .delete("books/A7474");
    }

    //////////////////////////////////////////////////////////////
    @Test
    public void testSearchByAuthor() {
        // add the contact to be fetched
        //books.put("A7474", new Book("A7474", "Brown", "Atlas", 23416));

        Book book = new Book("A7474", "Brown", "Atlas", 23416.0);
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the contact
        given()
                .when()
                .get("books/search/?author=Brown")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("findAll{author=='Brown'}",hasSize((1));

        //cleanup
        given()
                .when()
                .delete("books/A7474");
    }



    ///////////////////////////////////////////////////////
/*
    @Test
    public void testDeleteContact() {
        // add the contact to be deleted book
        //books.put("A627363", new Book("A627363", "Jones", "Fountain", "23416"));

        Book book = new Book("A627363", "Jones", "Fountain", "23416");
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
        Book book = new Book("A627363", "Jones", "Fountain", "23416");
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
        Book book = new Book("A627363", "Jones", "Fountain", "23416");
        Book book2 = new Book("A627363", "Johnson", "Fountain", "23416");
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
        Book book = new Book("A775", "Jones", "atlas", "23416");
        Book book2 = new Book("A627363", "Johnson", "Fountain", "23416");
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
