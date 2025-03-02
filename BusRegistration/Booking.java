package BusRegistration;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking
{
    String name;
    String from;
    String to;
    Date date;
    int busAllot;
   
 


    public Booking(int busNo)
    {
        System.out.println(" ");
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter name");
        name=scanner.nextLine();

        System.out.println("From which Location");
        from=scanner.nextLine();

        System.out.println("where to go");
        to=scanner.nextLine();

        System.out.println("Enter Date");
        String dateInput=scanner.next();

        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Enter Correnct Formate");
            e.printStackTrace();
        }
        
        busAllot=busNo;
    }

    int AllotedBusNumber;
    public boolean isAvaliable(ArrayList<Bus>buses,ArrayList<Booking>book,int a)
    {
        
        int totalCapacityOccupiedTillNow=0;
        for (Bus seat : buses) {
            if (seat.getFrom().equals(from) && seat.getTo().equals(to)) {
                totalCapacityOccupiedTillNow = seat.getcapacity();
                AllotedBusNumber=seat.getbusNo();
            }
        }
            int filledSeat=0;
        // Single pass over bookings
        for (Booking seat : book) {
            if (seat.from.equals(from) && seat.to.equals(to) && seat.busAllot==(AllotedBusNumber)) {
                filledSeat++;
            }
        }
        int BusNumberAloted=0;
        String AllotedFrom="";
        String AllotedTo="";
        Date assigningdateforlist;
        
        if(filledSeat<totalCapacityOccupiedTillNow)
        {
         for(Bus seat:buses)
            {
            if(seat.getFrom().equals(from) && seat.getTo().equals(to) && seat.getBusDate().equals(date))
                {
                    BusNumberAloted=seat.getbusNo();
                    assigningdateforlist=seat.getBusDate();
                    AllotedFrom=seat.getFrom();
                    AllotedTo=seat.getTo();
                   if(seat.getFrom().equals(from) && seat.getTo().equals(to) && seat.getBusDate().equals(date) )
                    {
                        busAllot=BusNumberAloted;
                        date=assigningdateforlist;
                        System.out.println(" ");
                        System.out.println("Bus Number: "+BusNumberAloted+" From: "+AllotedFrom+" To: "+AllotedTo);
                    }
                   else
                   {
                    System.out.println("Sorry!!....No bus running on that date");
                        return false;
                   }  
               }
               else if(seat.getFrom().equalsIgnoreCase(from) && seat.getTo().equalsIgnoreCase(to) && seat.getBusDate()!=(date))
               {
                   System.out.println("No bus running at that date....");
                   return false;
               }  
            }
            
        }
        else
        {
                System.out.println("Sorry!!...Seats are fully Occupied");
                return false;
        } 
                
        return true;
    }
    public static void displayBookingDetails(ArrayList<Booking> book, int userOption,ArrayList<Bus>buses) {

        int bookSize=0;
        
        if(book.size()==0)
        {
            System.out.println("No Booking happend till now.....");
        }
        else
        {
            if (userOption == 7)  
           while(bookSize<buses.size())
           {
            
                 for (Booking b : book) {
                     if(b.busAllot==bookSize)
                      {
                      System.out.println(b.name+"        "+b.from+"        "+b.to+"        "+b.date+"       "+b.busAllot);
                      }
                            
            }
                 bookSize++;
                 if(bookSize>0)
                 {
                System.out.println(" ");
                System.out.println(" ");

            System.out.println("                             BUS NUMBER ="+bookSize+"                                            ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println(" ");
            System.out.println("    NAME       FROM       To                      Date               Bus Allote "); 
                 }
            
        }
       
        
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println(" ");
            System.out.println(" "); 
             Bus.Displaying(userOption,buses, book);

        
        }  

    }


    //METHOD FOR TOTAL BOOKING COUNT

    public static void BookingCount(ArrayList<Booking>book,int userOption,ArrayList<Bus>buses)
    {
        int Bookingcount=0;

        for(Booking count:book)
        {
            Bookingcount++;
        }

        System.out.println("Total Number of Booking Successfully Done:"+Bookingcount);
        Bus.Displaying(userOption,buses, book);  
    }
}
