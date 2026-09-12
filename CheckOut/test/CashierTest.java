import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {
    private Cashier cashier;

    @BeforeEach
    public void setUp() {
        cashier = new Cashier("Donald");
    }

    @Test
    public void testThatWhenIAskForCashierName_IGetCashierName(){
        assertEquals("Donald", cashier.getCashierName());
    }

    @Test
    public void testThatCashierCanAddItemAmountAndPriceOfItemToOrder() {
        cashier.addItem("Parfait", 2100, 2);
        assertEquals(1, cashier.getItems().size());
    }

    @Test
    public void testThatWhenIAddTwoItems_TheirAmountAndPriceToOrder_ItShouldBeAdded(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(2, cashier.getItems().size());
    }

    @Test
    public void testThatWhenIAddItems_TheirAmountAndPriceToOrder_IGetSubTotalOfAllPrices(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(9200,cashier.getSubTotal());
    }

    @Test
    public void testThatWhenIAddItems_TheirAmountAndPriceToOrder_IGetAmountOfDiscount(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(920,cashier.getDiscount(10));
    }

    @Test
    public void testThatWhenIAddItems_TheirAmountAndPriceToOrder_IGetVatOfTotalOrder(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(690, cashier.getVat());
    }

    @Test
    public void testThatWhenIAddItems_TheirAmountAndPriceToOrder_IGetTotalBill(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(8970.0, cashier.getTotalBill(10));
    }

    @Test
    public void testThatWhenIAddItems_TheirAmountAndPriceToOrder_AndIGetAmountFromCustomer_IGetChangeToReturn(){
        cashier.addItem("Parfait", 2100, 2);
        cashier.addItem("Biscuits", 1000, 5);
        assertEquals(30, cashier.getChange(9000, 10));
    }
}
