/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import datalayer.OrderMapper;
import datalayer.UserMapper;
import businesslayer.LoginSampleException;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class SpecificUser extends Command {

    int chosenId = 0;
    UserMapper um = new UserMapper();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        chosenId = Integer.parseInt(request.getParameter("chosenuserid"));
        if(um.findUserId(chosenId)) {
        session.setAttribute("specificUserid", chosenId);
        return "specificuser"; }
        
        return "userlist";
    }
}

