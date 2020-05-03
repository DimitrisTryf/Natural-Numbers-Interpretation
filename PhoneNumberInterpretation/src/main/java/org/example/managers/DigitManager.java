package org.example.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitManager {

    /**
     * finds the ambiguities for each digit group provided
     *
     * @param phoneNumber a list of strings of the phone number`s digit groups provided
     * @return a List of Lists containing all the ambiguities for each digit group
     */
    public List<List<String>> getDigitInterpretations(List<String> phoneNumber) {
        List<List<String>> interpretedPhoneNumber = new ArrayList<>();
        phoneNumber.add("");
        for (int i = 0; i < phoneNumber.size() - 1; i++) {
            if (phoneNumber.get(i).length() == 2) {
                interpretedPhoneNumber.add(manageDoubleDigit(phoneNumber.get(i), phoneNumber.get(i + 1)));
            } else if (phoneNumber.get(i).length() == 3) {
                interpretedPhoneNumber.add(manageTripleDigit(phoneNumber.get(i), phoneNumber.get(i + 1)));
            } else {
                String[] temp = {phoneNumber.get(i)};
                interpretedPhoneNumber.add(Arrays.asList(temp));
            }
        }
        return interpretedPhoneNumber;
    }

    /**
     * gets the ambiguities for double digits
     *
     * @param digit          a two-length digit
     * @param followingDigit the following digit of the previously given
     * @return a list of the ambiguities for the given double digit
     */
    private List<String> manageDoubleDigit(String digit, String followingDigit) {
        List<String> newDigits = new ArrayList<>();
        newDigits.add(digit);
        if ((followingDigit.length() == 1 && digit.charAt(1) == '0')&& (digit.charAt(0) != '1' || (!followingDigit.equals("1") && !followingDigit.equals("2")))){
            newDigits.add(Character.toString(digit.charAt(0)));
        } else if (digit.charAt(1) != '0' && !digit.equals("11") && !digit.equals("12")) {
            newDigits.add(digit.charAt(0) + "0" + digit.charAt(1));
        }
        return newDigits;
    }

    /**
     * gets the ambiguities for triple digits
     *
     * @param digit          a three-length digit
     * @param followingDigit the following digit of the previously given
     * @return a list of the ambiguities for the given triple digit
     */
    private List<String> manageTripleDigit(String digit, String followingDigit) {
        List<String> newDigits = new ArrayList<>();
        newDigits.add(digit);
        if ((digit.charAt(1) == '0') && (digit.charAt(2) == '0')) {
            if (followingDigit.length() == 1) {
                newDigits.add(digit.charAt(0) + "0");
            } else {
                newDigits.add(Character.toString(digit.charAt(0)));
            }
        } else if (digit.charAt(2) == '0') {
            newDigits.add(digit.charAt(0) + "00" + digit.charAt(1) + digit.charAt(2));
            if (followingDigit.length() == 1) {
                newDigits.add(digit.charAt(0) + "" + digit.charAt(1));
            }
        } else if ((digit.charAt(1) == '0')) {
            newDigits.add(digit.charAt(0) + "0" + digit.charAt(1) + digit.charAt(2));
        } else {
            newDigits.add(Character.toString(digit.charAt(0)) + digit.charAt(1) + "0" + digit.charAt(2));
            newDigits.add(digit.charAt(0) + "00" + digit.charAt(1) + digit.charAt(2));
            newDigits.add(digit.charAt(0) + "00" + digit.charAt(1) + "0" + digit.charAt(2));
        }
        return newDigits;
    }
}
