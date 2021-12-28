package com.api.automation.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {

    public void slf4jPractice() {
        // Creating the Logger object
        Logger logger = LoggerFactory.getLogger("SampleLogger");

        // Logging the information
        logger.info("Hi This is my first SLF4J program");

        // In order to execute the above lines successfully by calling the method from
        // the main class, either the line "BasicConfigurator.configure();"
        // should be added to the main class or log4j.properties file in
        // src/main/resources and add that folder to the classpath

        // Having both will result in logs getting printed twice
        // Having a log4j properties file makes more sense, since we can customize the
        // log output to the console
    }

}
