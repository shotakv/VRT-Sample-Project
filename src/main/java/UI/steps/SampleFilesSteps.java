package UI.steps;

import UI.pages.SampleFilesPage;
import UI.util.Helper;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;

import java.io.File;

public class SampleFilesSteps {
    Page page;
    SampleFilesPage sampleFilesPage;

    public SampleFilesSteps(Page page){
        this.page = page;
        sampleFilesPage = new SampleFilesPage(page);
    }

    public SampleFilesSteps downloadAndValidatePDF(){
        Download download = page.waitForDownload(() ->{
            sampleFilesPage.sampleReportPDFButton.click();
        });

        File downloaded = download.path().toFile();

        Helper.validatePDFUsingVRT(downloaded);

        return this;
    }
}
