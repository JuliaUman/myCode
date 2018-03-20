package supermarket;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SupermarketTest {

    public static final int BAR_CODE_TOMATO = 524814;
    public static final int BAR_CODE_POTATO = 532689;
    public static final int BAR_CODE_ONION = 5214885;
    public static final int BAR_CODE_GARLIC = 541785;

    @Test
    public void shouldSumProductPrices() {
        Supermarket supermarketWithProducts = createSupermarketWithProducts();
        supermarketWithProducts.addToCheckout(BAR_CODE_GARLIC);
        supermarketWithProducts.addToCheckout(BAR_CODE_GARLIC);
        supermarketWithProducts.addToCheckout(BAR_CODE_GARLIC);
        supermarketWithProducts.addToCheckout(BAR_CODE_GARLIC);

        assertThat(supermarketWithProducts.getCheckout()).isEqualTo(808);
    }

    @Test
    public void shouldShowProductPrices() {
        Supermarket products = createSupermarketWithProducts();

        assertThat(products.scanProduct(BAR_CODE_POTATO)).isEqualTo(242);
        assertThat(products.scanProduct(BAR_CODE_GARLIC)).isEqualTo(202);
        assertThat(products.scanProduct(BAR_CODE_ONION)).isEqualTo(245);
        assertThat(products.scanProduct(BAR_CODE_TOMATO)).isEqualTo(245);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldTrowIllegalStateforNoBarCode() {
        Supermarket products = createSupermarketWithProducts();
        products.scanProduct(521485548);
    }

    @Test
    public void shouldAddPricetoCheckout() {
        Supermarket prices = createSupermarketWithProducts();
        prices.addToCheckout(BAR_CODE_TOMATO);
        prices.addToCheckout(BAR_CODE_ONION);
        prices.addToCheckout(BAR_CODE_GARLIC);
        prices.addToCheckout(BAR_CODE_POTATO);

        assertThat(prices.checkout.size()).isEqualTo(4);
    }

    @Test
    public void shouldAddSpecialPrices() {
        Supermarket products = createSupermarketWithProducts();

        assertThat(products.specialCheckout(BAR_CODE_TOMATO, 6)).isEqualTo(800);
        assertThat(products.specialCheckout(BAR_CODE_GARLIC, 7)).isEqualTo(604);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldTrowIllegalState() {
        Supermarket products = createSupermarketWithProducts();
        products.specialCheckout(521479885, 6);
    }

    private Supermarket createSupermarketWithProducts() {
        Supermarket supermarket = new Supermarket();
        supermarket.addProduct("tomato", 245, BAR_CODE_TOMATO, 400, 3);
        supermarket.addProduct("potato", 242, BAR_CODE_POTATO, 200,3);
        supermarket.addProduct("onion", 245, BAR_CODE_ONION, 180,2);
        supermarket.addProduct("garlic", 202, BAR_CODE_GARLIC, 200,5);
        return supermarket;
    }
}
