package me.magicall.util.net.http.part.embeded;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import java.util.Map;

import me.magicall.util.net.http.part.HttpHeaderValue;

/**
 * @author Liang Wenjian
 */
public class AcceptLanguageValue implements HttpHeaderValue {
    private Locale locale;
    private Double weight;

    public AcceptLanguageValue() {
        super();
    }

    @Override
    public Object getValue() {
        return locale;
    }

    @Override
    public Map<String, Object> getAttrs() {
        if (weight == null) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap("q", weight);
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Locale locale=Locale.getDefault();
        System.out.println(locale.toLanguageTag());
        System.out.println(locale.toString());
        final List<LanguageRange> parse = LanguageRange.parse("zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        for (LanguageRange languageRange : parse) {

            System.out.println(languageRange.getRange());
            System.out.println(languageRange.getWeight());
        }

    }
}
