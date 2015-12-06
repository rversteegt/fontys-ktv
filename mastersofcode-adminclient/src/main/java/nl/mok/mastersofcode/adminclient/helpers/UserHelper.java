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
import remote.ws.mok.domain.Member;
import remote.ws.mok.domain.User;

/**
 *
 * @author Gijs
 */
public class UserHelper {

    /**
     * Creates a User object from a request, returns null if correct parameters
     * not present or empty
     *
     * @param request
     * @return
     */
    public static Optional<User> createUser(
            HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String teamname = request.getParameter("teamname");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        Optional<User> userOpt = Optional.empty();

        try {
            if (!(username.isEmpty() || password.isEmpty() || fullname.isEmpty()
                    || teamname.isEmpty() || email.isEmpty() || role.isEmpty())) {

                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setFullname(fullname);
                user.setTeamname(teamname);
                user.setEmail(email);
                user.setRole(role);
                userOpt = Optional.of(user);
            }
        } catch (NullPointerException ex) {
            //parameter not in request
        }

        return userOpt;
    }

    public static User addMember(User user, Member member) {

        user.setMembers(
                Stream.concat(user.getMembers().stream(),
                        Stream.of(member)).collect(toList())
        );

        return user;
    }

}
