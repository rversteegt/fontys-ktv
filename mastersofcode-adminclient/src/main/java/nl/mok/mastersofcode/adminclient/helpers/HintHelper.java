/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Assignment;
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
     * @param id id of hint to be updated or null if new hint
     * @return
     */
    public static Optional<Hint> createHint(
            HttpServletRequest request, Integer id) {

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
                if(id!=null){
                    hint.setId(id);
                }
                hintOpt = Optional.of(hint);
            }
        } catch (NullPointerException ex) {
            //parameter not available
        }

        return hintOpt;
    }

}
