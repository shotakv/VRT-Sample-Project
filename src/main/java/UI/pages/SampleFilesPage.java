package UI.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SampleFilesPage {
    public Locator sampleReportPDFButton;

    public SampleFilesPage(Page page){
        this.sampleReportPDFButton = page.locator("a[href='/downloads/documents/pdf/sample-report.pdf']");
    }

}
