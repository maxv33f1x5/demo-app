package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("CI/CD Pipeline Execution Started");

        String project = "Jenkins Maven Build";

        try {

            if (StringUtils.isBlank(project)) {
                throw new Exception("Project name cannot be empty");
            }

            String result = greet(project);

            logger.info(result);

            System.out.println(result);

            logger.info("Build Executed Successfully");

        } catch (Exception e) {

            logger.error("Application Error: " + e.getMessage());

        } finally {

            logger.info("Pipeline Execution Finished");
        }
    }

    public static String greet(String project) {

        return "Hello, " + project +
                "! CI/CD Pipeline Build Successful.";
    }
}
