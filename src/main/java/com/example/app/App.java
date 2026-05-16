package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

    private static final Logger logger =
            LoggerFactory.getLogger(App.class);

    // Colors
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    // Custom Exception
    static class InvalidProjectException extends Exception {

        public InvalidProjectException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long startTime = System.currentTimeMillis();

        logger.info("========== CI/CD PIPELINE STARTED ==========");

        String environment = System.getenv("ENVIRONMENT");

        if (environment == null) {
            environment = "Development";
        }

        System.out.println(CYAN);
        System.out.println("======================================");
        System.out.println("        CI/CD PIPELINE DASHBOARD      ");
        System.out.println("======================================");
        System.out.println(RESET);

        System.out.println("Environment : " + environment);
        System.out.println("Execution Time : " + LocalDateTime.now());

        try {

            System.out.print("\nEnter Project Name: ");
            String project = sc.nextLine();

            validateProject(project);

            while (true) {

                System.out.println("\n========== MENU ==========");
                System.out.println("1. Compile Project");
                System.out.println("2. Run Tests");
                System.out.println("3. Package Application");
                System.out.println("4. Deploy Application");
                System.out.println("5. Run Full CI/CD Pipeline");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        compileStage();
                        break;

                    case 2:
                        testStage();
                        break;

                    case 3:
                        packageStage();
                        break;

                    case 4:
                        deployStage();
                        break;

                    case 5:

                        compileStage();

                        testStage();

                        packageStage();

                        deployStage();

                        String result = greet(project);

                        logger.info(result);

                        System.out.println(
                                GREEN + "\n" + result + RESET
                        );

                        logger.info("Build completed successfully");

                        break;

                    case 6:

                        logger.info("Exiting application");

                        System.out.println(
                                CYAN + "Pipeline Closed Successfully"
                                        + RESET
                        );

                        sc.close();

                        long endTime = System.currentTimeMillis();

                        logger.info(
                                "Total Execution Time: {} ms",
                                (endTime - startTime)
                        );

                        logger.info(
                                "========== CI/CD PIPELINE FINISHED =========="
                        );

                        System.exit(0);

                    default:

                        System.out.println(
                                RED + "Invalid Choice!" + RESET
                        );
                }
            }

        } catch (InvalidProjectException e) {

            logger.error("Validation Error: {}", e.getMessage());

        } catch (Exception e) {

            logger.error("Unexpected Error: {}", e.getMessage());
        }
    }

    // Validation
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

    // Compile Stage
    public static void compileStage() throws InterruptedException {

        System.out.print("\nCompiling");

        for (int i = 0; i < 5; i++) {

            Thread.sleep(400);

            System.out.print(".");
        }

        System.out.println(
                GREEN + "\n[✓] Compilation Successful" + RESET
        );

        logger.info("Compilation successful");
    }

    // Test Stage
    public static void testStage() throws InterruptedException {

        System.out.print("\nRunning Tests");

        for (int i = 0; i < 5; i++) {

            Thread.sleep(400);

            System.out.print(".");
        }

        System.out.println(
                GREEN + "\n[✓] All Test Cases Passed" + RESET
        );

        logger.info("Testing successful");
    }

    // Package Stage
    public static void packageStage() throws InterruptedException {

        System.out.print("\nPackaging");

        for (int i = 0; i < 5; i++) {

            Thread.sleep(400);

            System.out.print(".");
        }

        System.out.println(
                GREEN + "\n[✓] JAR Packaging Successful" + RESET
        );

        logger.info("Packaging successful");
    }

    // Deploy Stage
    public static void deployStage() throws InterruptedException {

        System.out.print("\nDeploying");

        for (int i = 0; i < 5; i++) {

            Thread.sleep(400);

            System.out.print(".");
        }

        System.out.println(
                GREEN + "\n[✓] Deployment Successful" + RESET
        );

        logger.info("Deployment successful");
    }

    // Greeting Method
    public static String greet(String project) {

        return "Hello, " + project
                + "! CI/CD Pipeline Build Successful.";
    }
}
