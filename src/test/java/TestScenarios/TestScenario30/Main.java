package TestScenarios.TestScenario30;

/**
 * Implementation of test scenario 30 (TS30).
 *
 * <p>
 * The main test is in the {@link TestScenario30} class.
 * The {@link Main} class is used to simulate the actions
 * the user would have to do if this test scenario was
 * run in BlueJ as described.
 * <p>
 * Start the test scenario by running the main method.
 */
public class Main {
    public static void main(String[] args) {
        TestScenario30 testScenario30 = new TestScenario30();
        testScenario30.replace(testScenario30.nodeD, "F");
        testScenario30.newEdge(testScenario30.nodeA, testScenario30.nodeD);
    }
}
