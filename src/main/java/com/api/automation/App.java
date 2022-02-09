package com.api.automation;

import com.api.automation.lombok.POJOtoJSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;

@Slf4j
public class App {
    public static void main(String[] args) throws SerializeException, ParseException {

// new POJOtoJSON().convertPOJOtoJSONUsingGSON();
// new POJOtoJSON().convertPOJOtoJSONUsingJackson();
// log.info(new LombokDemo("aaa",20,true).toString());
// log.info(new LombokDemo("aaa",20,true).hashCode());
// log.info(new LombokDemo("aaa",20,true).equals(new LombokDemo("aaa",21,true)));

        new POJOtoJSON().convertPOJOtoJSONUsingJuneau();
        new POJOtoJSON().convertPOJOtoXMLUsingJuneau();
        new POJOtoJSON().convertPOJOtoHTMLUsingJuneau();
        new POJOtoJSON().convertJSONtoPOJOUsingJuneau();


    }
}
