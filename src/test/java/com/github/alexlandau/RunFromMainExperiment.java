package com.github.alexlandau;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherConfig;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintStream;
import java.io.PrintWriter;

public class RunFromMainExperiment {
    public static void main(String[] args) {
        LauncherConfig config = LauncherConfig.builder().build();

//        Launcher launcher = LauncherFactory.create(config);
        Launcher launcher = LauncherFactory.create();
        LauncherDiscoveryRequest discoveryRequest = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        // JUnit 5 parameterized test, individual parameter
                        DiscoverySelectors.selectUniqueId("[engine:junit-jupiter]/[class:com.github.alexlandau.ExampleJUnit5Test]/[test-template:testMethod(int)]/[test-template-invocation:#2]"),
                        // JUnit 4 parameterized test, individual parameter
                        DiscoverySelectors.selectUniqueId("[engine:junit-vintage]/[runner:com.github.alexlandau.ExampleJUnit4Test]/[test:%5B0%5D]/[test:testMethod%5B0%5D(com.github.alexlandau.ExampleJUnit4Test)]")
                )
                .build();
        System.out.println("Request: " + discoveryRequest);
        TestPlan testPlan = launcher.discover(discoveryRequest);
        System.out.println("Plan contains tests?: " + testPlan.containsTests());

        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        TestExecutionListener listener2 = new TestExecutionListener() {
            @Override
            public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
                System.out.println("Ran test with identifier " + testIdentifier + ", result was: " + testExecutionResult);
            }
        };

        launcher.execute(testPlan, listener, listener2);

        listener.getSummary().printTo(new PrintWriter(System.out));
    }
}
