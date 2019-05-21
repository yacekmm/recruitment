package recruitment;

import java.util.Locale;

public class RecOptional2 {

    public String getLowerCaseLang(String lang) {

        return lang != null ? lang.toLowerCase(Locale.getDefault()) : null;
    }
}

