package challenge2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static void main(String[] args) {

        String emailSnippet = """
                john.boy@valid.com
                bob-1964@valid.net
                david_ad@valid.io
                jane.doe-smith@valid.co.uk
                jane_Doe1976@valid.co.uk
                elaine@valid-test.com.au
                john.boy@valid
                david@invalid..com
                elaineinvalid1983@.com
                bob!@invalid.com
                """;

        String valids = """
                john.boy@valid.com
                bob-1964@valid.net
                david_ad@valid.io
                jane.doe-smith@valid.co.uk
                jane_Doe1976@valid.co.uk
                elaine@valid-test.com.au
                """;

        String invalid = """
                john.boy@valid
                david@invalid..com
                elaineinvalid1983@.com
                bob!@invalid.com
                """;

        Pattern emailPattern = Pattern.compile("([\\w._-]+)@(([\\w-]+\\.)+[\\w-]{2,}+)");

        Matcher emailMatcher = emailPattern.matcher(valids);
//        emailMatcher.results()
//                .forEach(mr -> System.out.println(mr.group(0)));

        Pattern emailPattern2 = Pattern.compile("([\\w._-]+)@(([\\w-]+\\.)+[\\w-]{2,}+)");

        String[] emailSamples = emailSnippet.lines().toArray(String[]::new);
        for(String email : emailSamples){
            Matcher eMatcher = emailPattern2.matcher(email);
            boolean matched = eMatcher.matches();
            System.out.print(email + " is " + (matched? "VALID " : "INVALID "));
            if(matched){
                System.out.printf("[username=%s, domain=%s%n",eMatcher.group(1),eMatcher.group(2));
            }else{
                System.out.println();
            }
        }
    }
}
