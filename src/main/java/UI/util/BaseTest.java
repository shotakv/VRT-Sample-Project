package UI.util;


import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;

import org.testng.annotations.*;

import java.io.IOException;


public class BaseTest {
    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;
    public static VisualRegressionTracker vrt;

    @BeforeClass
    public void setUpTest() throws IOException {
        playwright = Playwright.create();


            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));



        context = browser.newContext();
        page = context.newPage();


        VisualRegressionTrackerConfig config = VisualRegressionTrackerConfig.builder()
                .apiUrl("http://localhost:3000")
                .apiKey("your-api-key-here")
                .project("your-project-name-here")
                .branchName("master")
                .enableSoftAssert(true)
                .build();

        vrt = new VisualRegressionTracker(config);

        vrt.start();

    }



    @AfterClass
    public void tearDown() throws IOException {
        browser.close();
        playwright.close();
        vrt.stop();
    }

}
