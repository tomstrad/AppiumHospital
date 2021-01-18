package techtest.pageView;

import deviceDriver.DriverType;
import techtest.pageObjects.HospitalsPage;
import techtest.pageObjects.ResultPage;

import java.util.ArrayList;

public class ResultPageView {

    private static ResultPage androidResultPage;
    private static ResultPage s105GResultPage;
//    private static HospitalsPage pixel4aResultPage;

    public synchronized static ArrayList<ResultPage> getResultPages(){
        if(androidResultPage == null){
            androidResultPage = new ResultPage(DriverType.ANDROID);
        }
        if(s105GResultPage ==null){
            s105GResultPage = new ResultPage(DriverType.ANDROID_SAMSUNG_S105G);
        }
//        if(pixel4aHospitalsPage == null){
//            pixel4aHospitalsPage = new GDPRPage(DriverType.ANDROID_SAMSUNG_J6);
//        }

        ArrayList<ResultPage> ResultPages = new ArrayList();
        ResultPages.add(androidResultPage);
//        HospitalsPages.add(iosGDPRPage);
        ResultPages.add(s105GResultPage);
        return ResultPages;
    }
}
