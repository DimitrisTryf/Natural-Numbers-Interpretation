package org.example.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberValidator {

    /**
     * checks the validity of the phone number
     *
     * @param phoneNumber     a phone number as a String
     * @param prefixesLengths the prefixes and their corresponding phone number lengths
     * @return true: phone number valid, false: phone number invalid
     */
    public boolean validatePhoneNumber(String phoneNumber, Map<String, Integer> prefixesLengths) {
        for (String prefix : prefixesLengths.keySet()) {
            if (phoneNumber.startsWith(prefix) && phoneNumber.length() == prefixesLengths.get(prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks the validity of the phone number ambiguities
     *
     * @param interpretedNumbers a list of strings of the phone number`s digit groups provided
     * @param prefixesLengths    the prefixes and their corresponding phone number lengths
     * @return a map of the PhoneNumber and a boolean of it`s validity
     */
    public Map<String, Boolean> validateNumberAmbiguities(List<String> interpretedNumbers, Map<String, Integer> prefixesLengths) {
        Map<String, Boolean> validatedNumberAmbiguities = new HashMap<>();
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        interpretedNumbers.forEach(number -> validatedNumberAmbiguities.put(number, phoneNumberValidator.validatePhoneNumber(number, prefixesLengths)));
        return validatedNumberAmbiguities;
    }
}
