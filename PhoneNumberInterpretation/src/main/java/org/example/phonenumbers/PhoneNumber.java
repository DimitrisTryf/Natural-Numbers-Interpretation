package org.example.phonenumbers;

import java.util.*;
import java.util.stream.Collectors;

public abstract class PhoneNumber {

    protected List<String> phoneNumber;
    protected Map<String, Integer> prefixesLengths;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = new ArrayList<>();
        this.phoneNumber.addAll(Arrays.asList(phoneNumber.split(" ")));
        this.phoneNumber.removeAll(Arrays.asList("", null));

        this.phoneNumber.forEach(pn ->{
            if(pn.length()>3){
                throw new UnsupportedOperationException("4-digit input not supported");
            }
        });
    }

    /**
     * getter of the phone number
     *
     * @return List of String of digit groups
     */
    public List<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * setter for the phone number, inserting a List of String of the digit groups given
     *
     * @param phoneNumber a String of the phone number separated by spaces
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = new ArrayList<>();
        this.phoneNumber.addAll(Arrays.asList(phoneNumber.split(" ")));
        this.phoneNumber.removeAll(Arrays.asList("", null));
        this.phoneNumber.forEach(pn ->{
            if(pn.length()>3){
                throw new UnsupportedOperationException("4-digit input not supported");
            }
        });
    }

    /**
     * returns the phone number as a String
     *
     * @return the current phone number as a String
     */
    @Override
    public String toString() {
        return this.phoneNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public abstract void showCurrentPhoneNumberValidity();

    public abstract void showPhoneNumberAmbiguitiesValidity();

}
