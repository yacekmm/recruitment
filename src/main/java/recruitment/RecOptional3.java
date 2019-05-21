package recruitment;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class RecOptional3 {

    public String getLowerCaseLang(String lang) {

        String langCode = StringUtils.lowerCase(lang, Locale.getDefault());

        return langCode;
    }
}

