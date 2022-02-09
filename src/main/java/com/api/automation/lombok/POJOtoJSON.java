package com.api.automation.lombok;

import com.api.automation.juneau.SimplePOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

import java.util.Arrays;

// Find the difference in the variable name printed - isStudent vs student

@Slf4j
public class POJOtoJSON {
    public void convertPOJOtoJSONUsingGSON() {
        LombokDemo lombokDemo = new LombokDemo("def", 22, false);
        lombokDemo.setName("abc");
        lombokDemo.setAge(26);
        lombokDemo.setStudent(true);

        log.info("Name: " + lombokDemo.getName());
        log.info("Age: " + lombokDemo.getAge());
        log.info("isStudent: " + lombokDemo.isStudent());

        log.info(new Gson().toJson(lombokDemo));

        /*
         * When values are passed through both constructor and set menthod, the set
         * method values takes preference and
         * the output is {"name":"abc","age":26,"isStudent":true}
         *
         * When values are passed only via constructor, the constructor values are
         * considered and
         * the output is {"name":"def","age":22,"isStudent":false}
         *
         * When some null values are passed via constructor, gson excludes the key while
         * forming the json and
         * the output is {"age":22,"isStudent":false}
         */

    }

    public void convertPOJOtoJSONUsingJackson() {
        LombokDemo lombokDemo = new LombokDemo("ghi", 27, true);
        lombokDemo.setName("xyz");
        lombokDemo.setAge(23);
        lombokDemo.setStudent(false);

        try {
            log.info("Name: " + lombokDemo.getName());
            log.info("Age: " + lombokDemo.getAge());
            log.info("isStudent: " + lombokDemo.isStudent());

            log.info(new ObjectMapper().writeValueAsString(lombokDemo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // output is {"name":"xyz","age":23,"student":false}

    /*
     * When some null values are passed via constructor, jackson includes the key
     * while forming the json and sets the value as null and
     * the output is {"name":null,"age":27,"student":true}
     */

    /*Serialization using Juneau*/
    public void convertPOJOtoJSONUsingJuneau() throws SerializeException {
        JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
        log.info(jsonSerializer.serialize(new SimplePOJO("abc", 20, true, new String[]{"cricket", "music"})));
    }

    public void convertPOJOtoXMLUsingJuneau() throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        log.info(xmlSerializer.serialize(new SimplePOJO("abc", 20, true, new String[]{"cricket", "music"})));
    }

    public void convertPOJOtoHTMLUsingJuneau() throws SerializeException {
        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
        log.info(htmlSerializer.serialize(new SimplePOJO("abc", 20, true, new String[]{"cricket", "music"})));
    }

    public void convertJSONtoPOJOUsingJuneau() throws ParseException {
        /*Deserialization using Juneau*/
        String json = "{\n" +
                "\t\"age\": 20,\n" +
                "\t\"hobbies\": [\n" +
                "\t\t\"cricket\",\n" +
                "\t\t\"music\"\n" +
                "\t],\n" +
                "\t\"name\": \"abc\",\n" +
                "\t\"student\": true\n" +
                "}";
        JsonParser jsonParser = JsonParser.DEFAULT;
        SimplePOJO simplePOJO = jsonParser.parse(json, SimplePOJO.class);
        log.info(simplePOJO.getName());
        log.info(Integer.toString(simplePOJO.getAge()));
        log.info(Boolean.toString(simplePOJO.isStudent()));
        log.info(Arrays.toString(simplePOJO.getHobbies()));


    }

}
