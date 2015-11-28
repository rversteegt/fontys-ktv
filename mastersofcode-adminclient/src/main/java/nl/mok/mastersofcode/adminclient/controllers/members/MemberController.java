/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.controllers.members;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Member;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/members")
public class MemberController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showMembers(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("members", getFakeMembers());

        mav.addObject("page", new Object() {
            public String uri = "/mok/members";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("members/members.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/new")
    public ModelAndView showAddMember(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/member_new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("members/member_new.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/new")
    public ModelAndView addMember(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/member_new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("members/member_new.twig");

        return mav;
    }

    public List<Member> getFakeMembers() {
        List<Member> members = new ArrayList<>();

        Member m = new Member();
        m.setEmail("jan@jan.nl");
        m.setMembername("Jan Jansen");
        m.setTeam("De JavaDokters");
        members.add(m);

        m = new Member();
        m.setEmail("bert1988@home.nl");
        m.setMembername("Bert de Ven");
        members.add(m);

        m = new Member();
        m.setEmail("iemand@ziggo.nl");
        m.setMembername("Lisa Sonneveld");
        members.add(m);

        m = new Member();
        m.setEmail("StefanHendriks@hotmail.com");
        m.setMembername("Stefan Hendriks");
        m.setTeam("De JavaDokters");
        members.add(m);

        m = new Member();
        m.setEmail("devlieger@vlieger.eu");
        m.setMembername("Marnix de Vris");
        members.add(m);

        m = new Member();
        m.setEmail("wieishet1@home.nl");
        m.setMembername("Wim Wimser");
        m.setTeam("Stackers");
        members.add(m);

        m = new Member();
        m.setEmail("Bert133@gmail.com");
        m.setMembername("Bert Stenen");
        members.add(m);

        m = new Member();
        m.setEmail("roland1977@gmail.com");
        m.setMembername("Roland de Rolf");
        m.setTeam("Stackers");
        members.add(m);

        return members;
    }

}
