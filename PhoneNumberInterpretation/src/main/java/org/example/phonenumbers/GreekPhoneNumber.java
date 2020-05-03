package org.example.phonenumbers;

import org.example.managers.InterpretedOptionsManager;
import org.example.validators.PhoneNumberValidator;

import java.util.*;

public class GreekPhoneNumber extends PhoneNumber {

    private Map<String, Boolean> numberCheckedAmbiguities;
    private static final Map<String, Integer> greekPrefixesLengths;

    static {
        greekPrefixesLengths = new HashMap<>();
        greekPrefixesLengths.put("2", 10);
        greekPrefixesLengths.put("69", 10);
        greekPrefixesLengths.put("00302", 14);
        greekPrefixesLengths.put("003069", 14);
    }

    /**
     * Creates a phone number, inserting a List of String of the digit groups given
     *
     * @param phoneNumber a String of the phone number separated by spaces
     */
    public GreekPhoneNumber(String phoneNumber) {
        super(phoneNumber);
    }

    /**
     * displays the validity of the current phone number (as requested BASE LEVEL: Phone number validation)
     */
    public void showCurrentPhoneNumberValidity() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        boolean currentPhoneNumberValid = phoneNumberValidator.validatePhoneNumber(toString(), greekPrefixesLengths);
        System.out.println(currentPhoneNumberValid ? toString() + " [phone number:VALID]" : toString() + " [phone number:INVALID]");
    }

    /**
     * displays the validity of the given phone number ambiguities (as requested ADVANCED LEVEL: Identify natural number ambiguities)
     */
    public void showPhoneNumberAmbiguitiesValidity() {
        if (Objects.isNull(numberCheckedAmbiguities)) {
            PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
            InterpretedOptionsManager interpretedOptionsManager = new InterpretedOptionsManager();

            this.numberCheckedAmbiguities = phoneNumberValidator.validateNumberAmbiguities(interpretedOptionsManager.interpretNumbers(this), greekPrefixesLengths);
        }
        this.numberCheckedAmbiguities.keySet().forEach(number ->
                System.out.println(this.numberCheckedAmbiguities.get(number) ? number + " [phone number: VALID]" : number + " [phone number: INVALID]"));
    }

}
