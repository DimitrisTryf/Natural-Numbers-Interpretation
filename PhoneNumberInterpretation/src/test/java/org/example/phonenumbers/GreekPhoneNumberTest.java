package org.example.phonenumbers;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GreekPhoneNumberTest {

    @Test
    public void getPhoneNumber() {
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("69 7 62 718 44");
        List<String> expected = Arrays.asList("69","7","62","718","44");
        assertEquals(expected,phoneNumber.getPhoneNumber());
    }

    @Test
    public void phoneNumberAsString() {
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("69 7 55 732 11");
        String expected = "6975573211";
        assertEquals(expected,phoneNumber.toString());

    }

    @Test
    public void setPhoneNumber() {
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("");
        phoneNumber.setPhoneNumber("69 7 55 732 11");
        List<String> expected = Arrays.asList("69","7","55","732","11");
        assertEquals(expected,phoneNumber.getPhoneNumber());
    }

    @Test
    public void showCurrentPhoneNumberValidity(){
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("69 7 55 732 11");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneNumber.showCurrentPhoneNumberValidity();

        String expectedOutput  = "6975573211 [phone number:VALID]";

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testToString() {
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("69 7 55 732 11");
        String expected = "6975573211";
        assertTrue(expected.equals(phoneNumber.toString()));
    }

    @Test
    public void showPhoneNumberAmbiguitiesValidity(){
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber("2 10 69 30 6 6 4");
        List<String> expected = Arrays.asList("2106930664 [phone number: VALID]","210693664 [phone number: INVALID]",
                                                "2106093664 [phone number: VALID]","21060930664 [phone number: INVALID]");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneNumber.showPhoneNumberAmbiguitiesValidity();
        String result = outContent.toString();

        for(String s : expected){
            result = result.replace(s,"");
        }

        assertTrue(result.trim().equals(""));
    }
}