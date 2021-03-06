/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Hint;

/**
 *
 * @author Gijs
 */
public class HintHelper {

    /**
     * Creates a Hint object from a request, returns null if correct parameters
     * not present or empty
     *
     * @param request
     * @return
     */
    public static Optional<Hint> createHint(
            HttpServletRequest request) {

        String text = request.getParameter("text");
        String assignment = request.getParameter("assignment");
        Integer time = Parser.parseInt(request.getParameter("time")).orElse(null);

        Optional<Hint> hintOpt = Optional.empty();

        try {
            if (!(text.isEmpty() || assignment.isEmpty() || time == null)) {
                Hint hint = new Hint();
                hint.setAssignment(assignment);
                hint.setText(text);
                hint.setTime(time);
                hintOpt = Optional.of(hint);
            }
        } catch (NullPointerException ex) {
            //parameter not available
        }

        return hintOpt;
    }

}
