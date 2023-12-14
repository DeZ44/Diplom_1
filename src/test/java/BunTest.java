import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;

    @Before
    public void setBun(){
        this.bun = new Bun("имя", 22.3F);
    }

    @Test
    public void getNameTest() {
        String expectedResult = bun.name;

        String actualResult = bun.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        float expectedResult = bun.price;

        float actualResult = bun.getPrice();

        assertEquals(expectedResult, actualResult,0);
    }

}
