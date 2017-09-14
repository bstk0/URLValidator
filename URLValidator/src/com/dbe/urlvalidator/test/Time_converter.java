package com.dbe.urlvalidator.test;

import java.util.Scanner;

//https://stackoverflow.com/questions/25903354/java-convert-seconds-to-minutes-hours-and-days

public class Time_converter {

	public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        int seconds;
        int minutes ;
        int hours;
        System.out.print("Enter the number of seconds : ");
        seconds = input.nextInt();
        hours = seconds / 3600;
        minutes = (seconds%3600)/60;
        int seconds_output = (seconds% 3600)%60;


        System.out.println("The time entered in hours,minutes and seconds is:");
        System.out.println(hours  + " hours :" + minutes + " minutes:" + seconds_output +" seconds"); 
        input.close();
    }
}
