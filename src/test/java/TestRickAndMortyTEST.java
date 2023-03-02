import episodes.Result;
import episodes.Root;
import org.junit.Test;


import static io.restassured.RestAssured.when;


public class TestRickAndMortyTEST {

    @Test
    public void testDimension() {
        Root root = when().get("https://rickandmortyapi.com/api/location").then().extract().as(Root.class);
        do {
            for (Result l : root.results) {
                System.out.println(l.dimension);
            }
            if (root.info.next != null) {
                root = when().get(root.info.next).then().extract().as(Root.class);
            } else {
                break;
            }
            System.out.println("=======================================================================================");
        } while (true);
    }}


