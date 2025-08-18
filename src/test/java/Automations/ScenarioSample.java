package Automations;

import UI.steps.SampleFilesSteps;
import UI.util.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static UI.data.Constants.SAMPLE_FILES_URL;

public class ScenarioSample extends BaseTest {
    SampleFilesSteps sampleFilesSteps;

    @BeforeMethod
    public void setUpForAutomation(){
        page.navigate(SAMPLE_FILES_URL);
        sampleFilesSteps = new SampleFilesSteps(page);
    }

    @Test
    public void scenarioSample(){
        sampleFilesSteps.downloadAndValidatePDF();
    }
}
