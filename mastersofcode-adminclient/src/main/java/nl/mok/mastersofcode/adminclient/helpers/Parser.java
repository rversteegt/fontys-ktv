/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;

/**
 *
 * @author Gijs
 */
public class Parser {

    /**
     * Attempts to parse an integer from a string.
     *
     * @param integer A string representing an integer.
     * @return Maybe an integer if it can be parsed, otherwise nothing.
     */
    public static Optional<Integer> parseInt(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException | NullPointerException e) {
            return Optional.empty();
        }
    }

}
