import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE,"имя", 22.3F);
        String expectedResult = ingredient.name;

        String actualResult = ingredient.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(FILLING,"имя", 22.3F);
        float expectedResult = ingredient.price;

        float actualResult = ingredient.getPrice();

        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE,"имя", 22.3F);
        IngredientType expectedResult = ingredient.type;

        IngredientType actualResult = ingredient.getType();

        assertEquals(expectedResult, actualResult);
    }
}
