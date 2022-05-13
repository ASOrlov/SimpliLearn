package alex.formatter;

import alex.model.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String text, Locale locale) throws ParseException {

        //text=641-451-1111
        String[] temp=text.split("-");
        Phone phone=new Phone();
        phone.setAreaCode(temp[0]);
        phone.setPrefix(temp[1]);
        phone.setNumber(temp[2]);
        System.out.println("Inside PhoneFormatter parse method: "+phone);
        return phone;

    }

    @Override
    public String print(Phone object, Locale locale) {
        return null;
    }
}
