package Automations;

import UI.util.Helper;

import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;


public class OnlyPDFSample{
    public VisualRegressionTracker vrt;

    @BeforeClass
    public void setUpTest() throws IOException {
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





    @Test
    public void validateSimplePDF(){
        File pdfFile = new File("fillable-form.pdf");
        Helper.validatePDFUsingVRT(pdfFile,vrt);
    }

    @AfterClass
    public void tearDown() throws IOException {
        vrt.stop();
    }

}
