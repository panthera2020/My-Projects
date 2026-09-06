import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardVerificationTest {
    private CreditCardVerification creditCard;

    @BeforeEach
    public void checkCard(){
        creditCard = new CreditCardVerification();
    }

    @Test
    public void testThatWhenDigitAreInputted_AndTheyAreNotUpToRequiredLength_CardLengthIsInvalid() {
        assertFalse(creditCard.isLenghtValid(5399833));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndTheyAreUpToRequiredLength_CardIsValid() {
        assertTrue(creditCard.isLenghtValid(539987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitIs4_CardIsValid() {
        assertTrue(creditCard.isLenghtValid(439987465855678L));
        assertTrue(creditCard.isFirstDigitValid(439987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitis5_CardIsValid() {
        assertTrue(creditCard.isLenghtValid(539987465855678L));
        assertTrue(creditCard.isFirstDigitValid(539987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigit6_CardIsValid() {
        assertTrue(creditCard.isLenghtValid(639987465855678L));
        assertTrue(creditCard.isFirstDigitValid(639987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigit3_AndSecondDigitIs7_CardIsValid() {
        assertTrue(creditCard.isLenghtValid(379987465855678L));
        assertTrue(creditCard.isFirstDigitValid(379987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitIs4_CardTypeIsVisa() {
        assertTrue(creditCard.isLenghtValid(439987465855678L));
        assertEquals("Visa", creditCard.cardType(439987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitis5_CardTypeIsMasterCard() {
        assertTrue(creditCard.isLenghtValid(539987465855678L));
        assertEquals("MasterCard", creditCard.cardType(539987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitis6_CardTypeIsDiscoverCard() {
        assertTrue(creditCard.isLenghtValid(639987465855678L));
        assertEquals("Discover Card", creditCard.cardType(639987465855678L));
    }

    @Test
    public void testThatWhenDigitAreInputted_AndLengthIsValid_AndTheFirstDigitIs3_AndSecondDigitIs7_CardTypeIsAmericanExpressCard() {
        assertTrue(creditCard.isLenghtValid(379987465855678L));
        assertEquals("American Express Card", creditCard.cardType(379987465855678L));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IGetAnArrayOfTheDigit(){
        int [] digits = {1,2,3,4,5};
        assertArrayEquals(digits, creditCard.getArrayOf(12345));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IGetAnArrayOfTheDigits_WithTheSecondDigitsDoubled_FromRightToLeft(){
        int [] doubledDigits = {2,2,6,4,10,6};
        assertArrayEquals(doubledDigits, creditCard.doubleSecondElementsRightToLeft(123456));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IGetAnArrayOfTheDigits_WithTheSecondDigitsDoubled_FromRightToLeft_WithoutAnyDoubleDigit() {
        int[] doubledDigits = {2, 2, 6, 4, 1, 6};
        assertArrayEquals(doubledDigits, creditCard.doubleSecondElementsRightToLeftNoDoubleDigitElement(123456));
    }

    @Test
    public void testThatWhenDigitAreInputted_IGetTheSumOfTheSecondDigits_FromRightToLeft_WithoutAnyDoubleDigit(){
        assertEquals(9,creditCard.sumOfSecondDigitsRightToLeft(123456));
    }

    @Test
    public  void testThatWhenDigitAreInputted_IGetTheSumOfTheOddPlacedDigits_FromRightToLeft_WithoutAnyDoubleDigit(){
        assertEquals(12,creditCard.sumOfOddPlacedDigitsRightToLeft(123456));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IGetTheSumOf_TheSumOfTheOddPlacedDigits_FromRightToLeft_WithoutAnyDoubleDigit_AndTheSumOfTheSecondDigits_FromRightToLeft_WithoutAnyDoubleDigit(){
        assertEquals(21,creditCard.sumOfOddPlacedSecondDigitsRightToLeft(123456));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IfTheSumOfThe_SumOfOddPlaceDigitsFromRightToLeftWithoutAnyDoubleDigits_AndTheSumOfTheSecondDigits_FromRightToLeft_WithoutAnyDoubleDigit_IsDivisibleByFour_CardIsValid(){
        assertTrue(creditCard.isCardValid(5399831619690403L));
    }

    @Test
    public void testThatWhenDigitsAreInputted_IGetLengthOfDigitsInputted(){
        assertEquals(15,creditCard.getCardLength(539987465855678L));
    }
}
