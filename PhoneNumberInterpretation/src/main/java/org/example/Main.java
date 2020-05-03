package org.example;

import org.example.phonenumbers.GreekPhoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Please insert a phone number");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GreekPhoneNumber phoneNumber = new GreekPhoneNumber(reader.readLine());
        System.out.println("\nBase Level : Checking single number validity");
        phoneNumber.showCurrentPhoneNumberValidity();
        System.out.println("\nAdvanced Level : Checking all interpretations");
        phoneNumber.showPhoneNumberAmbiguitiesValidity();


    }
}
