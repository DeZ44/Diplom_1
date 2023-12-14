import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetPriceParamTest {
    private final int ingredientCount;
    private final float ingredientPrice;
    private final float expected;

    public BurgerGetPriceParamTest(int ingredientCount, float ingredientPrice, float expected) {
        this.ingredientCount = ingredientCount;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][] {
                {0, 100F, 200F},
                {1, 100.25F, 300.5F},
                {2, 200F, 600F},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        int i = 0;
        while (i < ingredientCount) {
            burger.ingredients.add(ingredient);
            i++;
        }
        Mockito.when(bun.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(expected, burger.getPrice(), 0);
    }
}
