package org.example.phonenumbers;

import org.example.managers.DigitManager;
import org.example.managers.InterpretedOptionsManager;
import org.example.validators.PhoneNumberValidator;

import java.util.*;

public class GreekPhoneNumber extends PhoneNumber {

    private Map<String, Boolean> numberCheckedAmbiguities;


    /**
     * Creates a phone number, inserting a List of String of the digit groups given
     *
     * @param phoneNumber a String of the phone number separated by spaces
     */
    public GreekPhoneNumber(String phoneNumber) {
        super(phoneNumber);
        initializePrefixes();
    }

    /**initializes the prefixes and their lengths for the current phone number*/
    private void initializePrefixes() {
        prefixesLengths = new HashMap<>();
        prefixesLengths.put("2", 10);
        prefixesLengths.put("69", 10);
        prefixesLengths.put("00302", 14);
        prefixesLengths.put("003069", 14);
    }

    /**
     * displays the validity of the current phone number (as requested BASE LEVEL: Phone number validation)
     */
    @Override
    public void showCurrentPhoneNumberValidity() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        boolean currentPhoneNumberValid = phoneNumberValidator.validatePhoneNumber(toString(), prefixesLengths);
        System.out.println(currentPhoneNumberValid ? toString() + " [phone number:VALID]" : toString() + " [phone number:INVALID]");
    }

    /**
     * displays the validity of the given phone number ambiguities (as requested ADVANCED LEVEL: Identify natural number ambiguities)
     */
    @Override
    public void showPhoneNumberAmbiguitiesValidity() {
        if (Objects.isNull(numberCheckedAmbiguities)) {
            PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
            InterpretedOptionsManager interpretedOptionsManager = new InterpretedOptionsManager();
            DigitManager digitManager = new DigitManager();
            List<String> toInterpret = new ArrayList<>();
            for(String str : this.phoneNumber){
                toInterpret.add(str);
                if(str.endsWith("12")|| str.endsWith("11")){
                    toInterpret.add("unambiguous");
                }
            }
            List<List<String>> interpretedOptions = digitManager.getDigitInterpretations(toInterpret);

            this.numberCheckedAmbiguities = phoneNumberValidator.validateNumberAmbiguities(interpretedOptionsManager.interpretNumbers(interpretedOptions), prefixesLengths);
        }
        this.numberCheckedAmbiguities.keySet().forEach(number ->
                System.out.println(this.numberCheckedAmbiguities.get(number) ? number + " [phone number: VALID]" : number + " [phone number: INVALID]"));
    }

}
