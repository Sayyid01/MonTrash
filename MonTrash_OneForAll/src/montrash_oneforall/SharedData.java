/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall;

/**
 *
 * @author Sayyid
 */
public class SharedData {
    public  static String email;

    public static void setEmail(String email) {
       SharedData.email = email;
    }

    public static String getEmail() {
       return email;
    }
}
