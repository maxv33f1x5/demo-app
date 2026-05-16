package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class App {

    private static final Logger logger =
            LoggerFactory.getLogger(App.class);

    // Custom Exception
    static class InvalidProjectException extends Exception {

        public InvalidProjectException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        logger.info("========== CI/CD PIPELINE STARTED ==========");

        String project = "Jenkins Maven Build";

        // Environment Variable
        String environment = System.getenv("ENVIRONMENT");

        if (environment == null) {
            environment = "Development";
        }

        logger.info("Environment: {}", environment);

        try {

            validateProject(project);

            compileStage();

            testStage();

            packageStage();

            deployStage();

            String result = greet(project);

            logger.info(result);

            System.out.println(result);

            logger.info("Build completed successfully at {}",
                    LocalDateTime.now());

        } catch (InvalidProjectException e) {

            logger.error("Validation Error: {}", e.getMessage());

        } catch (Exception e) {

            logger.error("Unexpected Error: {}", e.getMessage());

        } finally {

            long endTime = System.currentTimeMillis();

            logger.info("Total Execution Time: {} ms",
                    (endTime - startTime));

            logger.info("========== CI/CD PIPELINE FINISHED ==========");
        }
    }

    // Validation Method
    public static void validateProject(String project)
            throws InvalidProjectException {

        logger.info("Validating project...");

        if (StringUtils.isBlank(project)) {

            throw new InvalidProjectException(
                    "Project name cannot be empty"
            );
        }

        logger.info("Validation successful");
    }

    // Simulated Compile Stage
    public static void compileStage() throws InterruptedException {

        logger.info("Compiling source code...");

        Thread.sleep(1000);

        logger.info("Compilation successful");
    }

    // Simulated Test Stage
    public static void testStage() throws InterruptedException {

        logger.info("Running unit tests...");

        Thread.sleep(1000);

        logger.info("All test cases passed");
    }

    // Simulated Package Stage
    public static void packageStage() throws InterruptedException {

        logger.info("Packaging application...");

        Thread.sleep(1000);

        logger.info("JAR packaging successful");
    }

    // Simulated Deploy Stage
    public static void deployStage() throws InterruptedException {

        logger.info("Deploying application...");

        Thread.sleep(1000);

        logger.info("Deployment successful");
    }

    // Business Logic Method
    public static String greet(String project) {

        return "Hello, " + project +
                "! CI/CD Pipeline Build Successful.";
    }
}
