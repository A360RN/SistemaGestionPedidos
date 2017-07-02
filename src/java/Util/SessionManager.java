/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.servlet.http.HttpSession;

/**
 *
 * @author alonsorn
 */
public class SessionManager {
    
    public static boolean isLoggedIn(HttpSession session){
        return session.getAttribute("user") != null;
    }
}
