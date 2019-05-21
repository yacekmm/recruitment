package recruitment;

import java.util.Optional;

public class RecOptional1 {

    public String getLowerCaseLang(String lang) {

        //what does it do?
        return Optional.ofNullable(lang)
                .map(String::toLowerCase)
                .orElse(null);

    }
}

