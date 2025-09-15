package com.chatapp;

import com.chatapp.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Validator class.
 */
public class ValidatorTest {

    @Test
    @DisplayName("Test username validation - Valid cases")
    public void testCheckUsernameValid() {
        assertTrue(Validator.checkUsername("a_b"));
        assertTrue(Validator.checkUsername("ab_c"));
        assertTrue(Validator.checkUsername("_abc"));
        assertTrue(Validator.checkUsername("abc_"));
    }

    @Test
    @DisplayName("Test username validation - Invalid cases")
    public void testCheckUsernameInvalid() {
        assertFalse(Validator.checkUsername(""));
        assertFalse(Validator.checkUsername(null));
        assertFalse(Validator.checkUsername("abcde"));
        assertFalse(Validator.checkUsername("abc def"));
        assertFalse(Validator.checkUsername("abcdef_")); // Assuming "abcdef_" is too long per rule
    }

    @Test
    @DisplayName("Test password complexity validation - Valid cases")
    public void testCheckPasswordComplexityValid() {
        assertTrue(Validator.checkPasswordComplexity("Ab1!defg"));
        assertTrue(Validator.checkPasswordComplexity("A1@cdefgh"));
        assertTrue(Validator.checkPasswordComplexity("ABCdef1!"));
        assertTrue(Validator.checkPasswordComplexity("P@ssw0rd"));
    }

    @Test
    @DisplayName("Test password complexity validation - Invalid cases")
    public void testCheckPasswordComplexityInvalid() {
        assertFalse(Validator.checkPasswordComplexity(""));
        assertFalse(Validator.checkPasswordComplexity(null));
        assertFalse(Validator.checkPasswordComplexity("abcdefg"));
        assertFalse(Validator.checkPasswordComplexity("ABCDEFG"));
        assertFalse(Validator.checkPasswordComplexity("1234567"));
        assertFalse(Validator.checkPasswordComplexity("a1!"));
        assertFalse(Validator.checkPasswordComplexity("Abcdefg1"));
        assertFalse(Validator.checkPasswordComplexity("Abcdefg!"));
        assertFalse(Validator.checkPasswordComplexity("abcdefg1!"));
    }

    @Test
    @DisplayName("Test cell phone number validation - Valid cases")
    public void testCheckCellNumberValid() {
        assertTrue(Validator.checkCellNumber("+27123456789"));
        assertTrue(Validator.checkCellNumber("+27987654321"));
    }

    @Test
    @DisplayName("Test cell phone number validation - Invalid cases")
    public void testCheckCellNumberInvalid() {
        assertFalse(Validator.checkCellNumber(""));
        assertFalse(Validator.checkCellNumber(null));
        assertFalse(Validator.checkCellNumber("123456789"));
        assertFalse(Validator.checkCellNumber("+2712345678"));
        assertFalse(Validator.checkCellNumber("+271234567890"));
        assertFalse(Validator.checkCellNumber("+27abcdefghi"));
        assertFalse(Validator.checkCellNumber("27123456789"));
    }

    @Test
    @DisplayName("Test error messages")
    public void testErrorMessages() {
        assertNotNull(Validator.getUsernameErrorMessage());
        assertNotNull(Validator.getPasswordErrorMessage());
        assertNotNull(Validator.getCellNumberErrorMessage());

        assertTrue(Validator.getUsernameErrorMessage().toLowerCase().contains("underscore"));
        assertTrue(Validator.getPasswordErrorMessage().toLowerCase().contains("8 characters"));
        assertTrue(Validator.getCellNumberErrorMessage().contains("+27"));
    }
}
