/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Member;
import remote.ws.mok.domain.Round;

/**
 *
 * @author Gijs
 */
public class MemberHelper {

    /**
     * Creates a Member object from a request, returns null if correct
     * parameters not present or empty
     *
     * @param request
     * @param team Id of linked team, can't be null
     * @return
     */
    public static Optional<Member> createMember(
            HttpServletRequest request, String team) {

        String membername = request.getParameter("membername");
        String email = request.getParameter("email");

        Optional<Member> memberOpt = Optional.empty();

        try {
            if (!(membername.isEmpty() || email.isEmpty() || team.isEmpty())) {
                Member member = new Member();
                member.setMembername(membername);
                member.setEmail(email);
                member.setTeam(team);
                memberOpt = Optional.of(member);
            }
        } catch (NullPointerException ex) {
            //parameter not available
        }

        return memberOpt;

    }

}
