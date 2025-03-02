import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicLookAndFeel;

import  BusRegistration.*;

class BusDemo
{
  public static void main(String arg[])
  {
    ArrayList<Bus>buses=new ArrayList<Bus>();
    ArrayList<Booking>book=new ArrayList<Booking>();

    buses.add(new Bus(1, true, 1, "ERD", "CBE","12-12-2004"));
    buses.add(new Bus(2, true, 1, "CBE", "ERD","12-12-2004"));
    buses.add(new Bus(3, true, 30, "ERD", "THIRU", "12-12-2004"));
    buses.add(new Bus(4, true, 30, "THIRU", "ERD", "12-12-2004"));
    
    int userOption=1;
    int a=1;

    while(userOption==1 || userOption==2)
    {
        System.out.println("Enter 1 for Booking");
        System.out.println("Enter 0 for Exit");
        System.out.println("Enter 2 for Seting Capacity");
        System.out.println("Enter 3 for Seting Date");
        System.out.println("Enter 4 for Seting Starting Point of Bus");
        System.out.println("Enter 5 for Seting Reaching Point of Bus");
        System.out.println("Enter 6 to Display Bus Details");
        System.out.println("EnteR 7 to Display Booking Details");
        System.out.println("Enter 8 to get total number of booking booking ");


      Scanner scanner=new Scanner(System.in);
      userOption=scanner.nextInt();
      
      if(userOption==1)
      {
        Booking booking=new Booking(getbusNo());
       if ((booking.isAvaliable(buses,book,a))==true)
       {
          book.add(booking);
                   System.out.println("--------------------------------------------");  
          System.out.println("Your booking is conformed....");  
          System.out.println(" "); 
          System.out.println(" ");    
       }
       else
       {
        System.out.println("Sorry Booking is not Conformed");
       }
      
      }
      else if(userOption>=2 && userOption<=5)
      {
        Bus obj=new Bus(userOption, buses,book);
      }
      else if(userOption==6)
      {
        Bus obj=new Bus(userOption, buses,book);
        obj.displayBusDetails(buses,userOption,book);
      }
      else if(userOption==7)
      {
        Booking.displayBookingDetails(book,userOption,buses);
      }
      else
      {
        if(userOption==0)
          BusDemo.end(userOption);
      }
    }
   
   
  }
  public static void end(int userOption)
  {
      System.out.println("Thank You............");
  }
  

  private static int getbusNo() {
    return 0;
  }
}