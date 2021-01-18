package techtest.pageView;

import deviceDriver.DriverType;
import techtest.pageObjects.HospitalsPage;

import java.util.ArrayList;

public class HospitalsPageView {

    private static HospitalsPage androidHospitalsPage;
    private static HospitalsPage s105GHospitalsPage;
    private static HospitalsPage pixel4aHospitalsPage;

    public synchronized static ArrayList<HospitalsPage> getHospitalsPages(){
        if(androidHospitalsPage == null){
            androidHospitalsPage = new HospitalsPage(DriverType.ANDROID);
        }
        //Samsung Code
//        if(s105GHospitalsPage ==null){
//            s105GHospitalsPage = new HospitalsPage(DriverType.ANDROID_SAMSUNG_S105G);
//        }
        //Pixel Code
//        if(pixel4aHospitalsPage == null){
//            pixel4aHospitalsPage = new HospitalsPage(DriverType.ANDROID_GOOGLE_PXL4);
//        }

        ArrayList<HospitalsPage> HospitalsPages = new ArrayList();
        HospitalsPages.add(androidHospitalsPage);
        //Samsung Code
//        HospitalsPages.add(s105GHospitalsPage);
        //Pixel Code
//        HospitalsPages.add(pixel4aHospitalsPage);
        return HospitalsPages;
    }
}
