package techtest.pageView;

import deviceDriver.DriverType;
import techtest.pageObjects.HospitalsPage;
import techtest.pageObjects.ResultPage;

import java.util.ArrayList;

public class ResultPageView {

    private static ResultPage androidResultPage;
    private static ResultPage s105GResultPage;
    private static ResultPage pixel4aResultPage;

    public synchronized static ArrayList<ResultPage> getResultPages(){
        if(androidResultPage == null){
            androidResultPage = new ResultPage(DriverType.ANDROID);
        }
        //Samsung Code
//        if(s105GResultPage ==null){
//            s105GResultPage = new ResultPage(DriverType.ANDROID_SAMSUNG_S105G);
//        }
        //Pixel Code
//        if(pixel4aResultPage == null){
//            pixel4aResultPage = new ResultPage(DriverType.ANDROID_GOOGLE_PXL4);
//        }

        ArrayList<ResultPage> ResultPages = new ArrayList();
        ResultPages.add(androidResultPage);
        //Samsung Code
//        ResultPages.add(s105GResultPage);
        //Pixel Code
//        ResultPages.add(pixel4aResultPage);
        return ResultPages;
    }
}
