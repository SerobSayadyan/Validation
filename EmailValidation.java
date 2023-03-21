package BankProject.VAlidation;

import java.io.File;
import java.util.Scanner;

/**
 * A Valid email should contain:
 *      - one at (@) symbol;
 *      - legit domain (if the domain is not in our database (i.e. emailDomain.txt), it will be considered not valid);
 *
 * P.S. If there are any problems with email validation try to write absolute PATH of emailDomain.txt file
 */

public class EmailValidation {
    private String email;
    public boolean checkEmail(String email) {
        this.email = email;
        if (checkEmailDomain()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean check_AT() {
        if (email.contains("@")) {
            if (email.indexOf("@") == email.lastIndexOf("@")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkEmailDomain() {
        if (check_AT()) {
            String[] str = email.split("@");
            try {
                File file = new File("emailDomain.txt"); // PATH of emailDomain.txt
                Scanner sc = new Scanner(file);
                String s;
                while (sc.hasNextLine()) {
                    s = sc.nextLine();
                    if (s.equals(str[1])) {
                        sc.close();
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
