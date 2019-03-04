/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.sistem;

import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author asus
 */
public class ElevatorSistem {

  
    public static void main(String[] args) {
        
        Scanner input =new Scanner(System.in);
        System.out.println("Traffic type (5-23):");
        double traffic =input.nextDouble();
        System.out.println("Number of Passenger(0-20):");
        double passenger =input.nextDouble();
        try{
                Elevetor c=new Elevetor(traffic,passenger);
                //çıktıyı sağlar
                JFuzzyChart.get().chart(c.getModel());
                System.out.println(c);

        }
        catch(URISyntaxException ex)
        {
            System.out.print("Error");
        }
        
    }
    
}
