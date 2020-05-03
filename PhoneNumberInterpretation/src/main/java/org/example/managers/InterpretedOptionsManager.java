package org.example.managers;

import java.util.ArrayList;
import java.util.List;

public class InterpretedOptionsManager {

    /**
     * a recursive method that returns all the possible combinations from a List of Lists
     *
     * @param lists   a List of Lists of all the phone number`s digits ambiguities
     * @param result  an empty List for the method to add the results
     * @param depth   the starting index of the List (given:0)
     * @param current the current created String (given:"")
     */
    public void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }

    /**
     * calculates and return the current number`s ambiguities
     *
     * @param interpretedOptions a List of Lists of all the phone number`s digits ambiguities
     * @return the current number`s ambiguities
     */
    public List<String> interpretNumbers(List<List<String>> interpretedOptions) {

        List<String> interpretedPhoneNumbers = new ArrayList<>();
        generatePermutations(interpretedOptions, interpretedPhoneNumbers, 0, "");
        return interpretedPhoneNumbers;
    }
}
