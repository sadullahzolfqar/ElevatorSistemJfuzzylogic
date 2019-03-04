/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.sistem;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author asus
 */
public class Elevetor {
    private FIS fis;
    private double Traffic_Type;
    private double Number_Passenger;
    
    
    public Elevetor(double traffic,double passenger)throws URISyntaxException
    {
        Traffic_Type=traffic;
        Number_Passenger=passenger;
    
        File dosya=new File(getClass().getResource("elevator.fcl").toURI());
        //2 . değişken eğer daha önce yüklenmişse onun üstüne yazmak için
        fis=FIS.load(dosya.getPath(),true);
        fis.setVariable("Traffic_Type",Traffic_Type );
        fis.setVariable("Number_Passenger", Number_Passenger);
        fis.evaluate();//hesaplandı
        
    }
    /* Burdahoca eğersiz çıktı istiyor */
    public Elevetor()throws URISyntaxException
    {
        File dosya=new File(getClass().getResource("elevator.fcl").toURI());
        //2 . değişken eğer daha önce yüklenmişse onun üstüne yazmak için
        fis=FIS.load(dosya.getPath(),true);
    }
    public FIS getModel()
    {
        return fis;
    }
    @Override
    public String toString(){
        String sonuc="traffic Type          : "+Traffic_Type+"\n"
                    +"Number of Pessenger   : "+Number_Passenger+"\n"+
                     "lift waiting floor     : "+Math.round(fis.getVariable("wait_floor").getValue());
        return sonuc;
    }
}
