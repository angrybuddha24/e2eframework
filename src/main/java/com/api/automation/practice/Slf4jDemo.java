package com.api.automation.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Slf4jDemo {

    public void slf4jPractice() {

        /*
         * Simple Logging Facade for Java provides a simple abstraction of all the
         * logging frameworks. It enables a user to work with any of the logging
         * frameworks such as Log4j, Logback, JUL (java.util.logging), etc. using single
         * dependency. We can migrate to the required logging framework at
         * run-time/deployment time.
         */

        /*
         * Advantages:
         * SLF4J provides a simple Java tool known as migrator. Using this tool, you can
         * migrate existing projects, which use logging frame works like Jakarta Commons
         * Logging (JCL) or, log4j or, Java.util.logging (JUL) to SLF4J.
         */

        /*
         * Logging Framework Overview
         * A logging framework usually contains three elements −
         * 
         * Logger
         * Captures the message along with the metadata.
         * 
         * Formatter
         * Formats the messages captured by the logger.
         * 
         * Handler
         * The Handler or appender finally dispatches the messages either by printing on
         * the console or, by storing in the database or, by sending through an email.
         * 
         * Some frameworks combine the logger and appender elements to speed up the
         * operations.
         */

        /*
         * Logger Object
         * To log a message, the application sends a logger object (sometimes along with
         * the exceptions if any) with name and security level.
         */

        /*
         * Logger Interface
         * The logger interface of the org.slf4j package is the entry point of the SLF4J
         * API.
         */

        // Creating the Logger object
        Logger logger = LoggerFactory.getLogger("SampleLogger");

        // Logging the information
        logger.info("Hi This is my first SLF4J program");

        /*
         * In order to execute the above lines successfully, by calling the method from
         * the main class, either the line "BasicConfigurator.configure();"
         * should be added to the main class or log4j.properties file should be added in
         * src/main/resources and the folder path has to be added to the classpath
         */

        /*
         * Having both will result in logs getting printed twice
         * Having a log4j properties file makes more sense, since we can customize the
         * log output to the console
         */

        /*
         * Severity Level
         * The messages logged will be of various levels. The following table lists down
         * the general levels of logging.
         * 
         * Sr.No Severity level & Description
         * 1
         * Fatal
         * 
         * Severe issue that causes the application to terminate.
         * 
         * 2
         * ERROR
         * 
         * Runtime errors.
         * 
         * 3
         * WARNING
         * 
         * In most cases, the errors are due to the usage of deprecated APIs.
         * 
         * 4
         * INFO
         * 
         * Events that occur at runtime.
         * 
         * 5
         * DEBUG
         * 
         * Information about the flow of the system.
         * 
         * 6
         * TRACE
         * 
         * More detailed information about the flow of the system.
         */

        logger.error("Hi This is my first SLF4J program - error");
        logger.warn("Hi This is my first SLF4J program - warn");
        logger.info("Hi This is my first SLF4J program - info");
        logger.debug("Hi This is my first SLF4J program - debug");
        logger.trace("Hi This is my first SLF4J program - trace");

        /*
         * The above statements will be printed based on the log4j.rootLogger value in
         * the log4j propreties file.
         * Logs levels >= the level mentioned will only be printed and the lower levels
         * will be ignored
         */

        /*
         * fatal isn't supported by slf4j by default, we have to use a marker as a
         * workaround to log fatal messages
         */

        /*
         * If slf4j-nop jar is used, the properties file will be ignored and no logs
         * will be printed
         * If slf4j-simple jar is used, the properties file will be ignored and only
         * messages for info and higher will be printed
         */

        /*
         * To make SLF4J work along with slf4l-api-x.x.jar, you need to add the
         * respective Jar file (binding) of the desired logger framework in the
         * classpath of the project (set build path).
         * 
         * To switch from one framework to other, you need to replace the respective
         * binding. If no bounding is found, it defaults to no-operation mode.
         */

        // Logging other data types
        int a = 2, b = 5;
        logger.info("the value of a is {}", a);
        logger.info("the value of a is {} and b is {}", a, b);
    }

    /*
     * What is log4j?
     * log4j is a reliable, fast and flexible logging framework (APIs) written in
     * Java, which is distributed under the Apache Software License.
     */

    /*
     * Comparison SLF4J and Log4j
     * Unlike log4j, SLF4J (Simple Logging Facade for Java) is not an implementation
     * of logging framework, it is an abstraction for all those logging frameworks
     * in Java similar to log4J. Therefore, you cannot compare both. However, it is
     * always difficult to prefer one between the two.
     * 
     * If you have a choice, logging abstraction is always preferable than logging
     * framework. If you use a logging abstraction, SLF4J in particular, you can
     * migrate to any logging framework you need at the time of deployment without
     * opting for single dependency.
     */
}