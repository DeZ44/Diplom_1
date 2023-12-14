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
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParamTest {
        private final int ingredientCount;
        private final String ingredientName;
        private final String ingredientType;
        private final String bunName;
        private final float price;

    public BurgerGetReceiptParamTest(int ingredientCount, String bunName, String ingredientType, String ingredientName, float price) {
            this.ingredientCount = ingredientCount;
            this.bunName = bunName;
            this.ingredientType = ingredientType;
            this.ingredientName = ingredientName;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Object[][] getReceiptData() {
            return new Object[][] {
                    {0, "Имя булочки", "SAUCE", "ингредиент", 200F},
                    {1, "Имя булочки", "FILLING", "ингредиент", 200F},
                    {2, "Имя булочки", "SAUCE", "ингредиент", 300F},
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
        public void getReceiptTest() {
            Burger burger = new Burger();
            burger.setBuns(bun);
            String resultIngredientName = "";
            String resultBunName = String.format("(==== %s ====)%n", bunName);
            int i = 0;
            while (i < ingredientCount) {
                burger.ingredients.add(ingredient);
                resultIngredientName = String.format(resultIngredientName +  "= %s %s =%n", ingredientType.toLowerCase(), ingredientName);
                i++;
            }
            String resultPrice = String.format("%nPrice: %f%n", (2 + i) * price);
            Mockito.when(bun.getName()).thenReturn(bunName);
            Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(ingredientType));
            Mockito.when(ingredient.getName()).thenReturn(ingredientName);
            Mockito.when(bun.getPrice()).thenReturn(price);
            Mockito.when(ingredient.getPrice()).thenReturn(price);

            String expectedResult = resultBunName + resultIngredientName + resultBunName + resultPrice;


            assertEquals(expectedResult, burger.getReceipt());
        }
}
