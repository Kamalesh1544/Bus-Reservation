package BusRegistration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Bus
{
    private int busNo;
    private Boolean ACorNonAc;
    private int capacity;
    private String From;
    private String To;
    private Date busDate;
    String DailySettingDate;
    Date hi;
    Date SetDates;

    public Bus(int no,Boolean ac,int cap,String currentposition,String reachingposition,String DailySettingDate)
    {
        busNo=no;
        ACorNonAc=ac;
        capacity=cap;
        From=currentposition;
        To=reachingposition;

        SimpleDateFormat DateInupstBus=new SimpleDateFormat("dd-MM-yyyy");
        try {
            hi = DateInupstBus.parse(DailySettingDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setBusDate(hi);
    }

    //SETTING DETAILS FOR BUS
    Date b;
    public Bus(int userOption,ArrayList<Bus>buses,ArrayList<Booking>book)
    { 
        if(userOption==2)
        {
               
                    Bus.SettingCapacity(buses, userOption, book);   

                    System.out.println(" ");
                    System.out.println(" ");

                    Bus.Displaying(userOption,buses, book);  
        }
        else if(userOption==3)
        {
                
                        Scanner scanner=new Scanner(System.in);
                        System.out.println("Enter Bus Number");
                        int settingDateForBusNo=scanner.nextInt();

                        Scanner obj=new Scanner(System.in);
                        System.out.println("Enter Date");
                        String dateSet=obj.nextLine();
                        
                        for(Bus seat:buses)
                        {
                            if(seat.getbusNo()==settingDateForBusNo)
                            {
                                SimpleDateFormat Setting =new SimpleDateFormat("dd-MM-yyyy");
                                try {
                                    SetDates=Setting.parse(dateSet);
                                } catch (ParseException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                System.out.println(seat.getbusNo());
                                seat.setBusDate(SetDates);
                                break; 
                            } 
                                                  
                    }
                    System.out.println(" ");
                    System.out.println(" ");
                    Bus.Displaying(userOption,buses, book);  
        }
        else if(userOption==4)
        {
                    Bus.SettingStartingPoint(buses, userOption, book);
                    System.out.println(" ");
                    System.out.println(" ");
                    Bus.Displaying(userOption,buses, book);  
        }
        else if(userOption==5)
        {
                
                    Bus.SettingEndingPoint(buses, userOption, book); 
                    System.out.println(" ");
                    System.out.println(" ");
                    Bus.Displaying(userOption,buses, book);  
        }
        
    }


    //METHOD FOR SETTING CAPACITY OF BUS//
   public static void SettingCapacity(ArrayList<Bus> buses,int userOption,ArrayList<Booking> book)
   {
    Scanner scanner=new Scanner(System.in);
                        System.out.println("Enter Bus Number");
                        int settingCapacityForBusNo=scanner.nextInt();

                        Scanner obj=new Scanner(System.in);
                        System.out.println("Enter new Capacity");
                        int capacitySetting=obj.nextInt();
                    for(Bus seat:buses)
                     {   

                            if(seat.getbusNo()==settingCapacityForBusNo)
                            {
                                seat.setCapacity(capacitySetting);
                                break; 
                            } 
                                                  
                    }
   }



   //METHOD FOR SETTING STARTING POINT OF BUS//
   public static void SettingStartingPoint(ArrayList<Bus> buses,int userOption,ArrayList<Booking> book)
   {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Bus Number");
            int settingFromForBusNo=scanner.nextInt();

            Scanner obj=new Scanner(System.in);
            System.out.println("Enter Bus Starting Point");
            String fromSet=obj.nextLine();
    
            for(Bus seat:buses)
            {
                if(seat.getbusNo()==settingFromForBusNo)
                {
                    seat.setFrom(fromSet);
                    break; 
                } 
                              
            }
   }

   //METHOD FOR SETTING ENDING OR REACHING POINT OF BUS
   public static void SettingEndingPoint(ArrayList<Bus> buses,int userOption,ArrayList<Booking> book)
   {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Bus Number");
            int settingToForBusNo=scanner.nextInt();

            Scanner obj=new Scanner(System.in);
            System.out.println("Enter Bus Reaching Point");
            String setTo=obj.nextLine();
    
            for(Bus seat:buses)
            {
                if(seat.getbusNo()==settingToForBusNo)
                {
                    seat.setTo(setTo);
                    break; 
                } 
                              
            }
   }


    //METHOD FOR DISPLAYING BUS DETAILS
    public static void displayBusDetails(ArrayList<Bus> buses,int userOption,ArrayList<Booking> book)
    {
        int BusSelectingoption;

        System.out.println("Want to show all Bus details type -----> 0");
        System.out.println("want to show paticular bus details type Bus Number");
        Scanner obj1=new Scanner(System.in);
        int ShowAllBusDetails=obj1.nextInt();

        if(ShowAllBusDetails==0)
        {
             for(Bus seat:buses)
                {
                    System.out.println("BUS-NUMBER: "+seat.getbusNo());
                    System.out.println("DATE: "+seat.getBusDate());
                    System.out.println("CAPACITY: "+seat.getcapacity()+"");
                    System.out.println("FROM: "+seat.getFrom());
                    System.out.println("TO: "+seat.getTo());
                    System.out.println(" ");  
                }
                System.out.println(" ");
                System.out.println(" ");
             Bus.Displaying(userOption,buses, book);
            }
             
        if(ShowAllBusDetails>0)
        {
            if(ShowAllBusDetails<buses.size())
            {
                for(Bus seat:buses)
                {
                    if(seat.getbusNo()==ShowAllBusDetails)
                    {      
                        System.out.println("BUS-NUMBER: "+seat.getbusNo());
                        System.out.println("DATE: "+seat.getBusDate());
                        System.out.println("CAPACITY: "+seat.getcapacity()+"");
                        System.out.println("FROM: "+seat.getFrom());
                        System.out.println("TO: "+seat.getTo()); 
                    }
                }
                 System.out.println(" ");
                System.out.println(" ");
                Bus.Displaying(userOption,buses, book);
            }
            else
            {
                 System.out.println("Bus Not Found");
                 Bus.Displaying(userOption,buses, book);
            }
        }
        
            
    }


    //METHOD FOR USEROPTION SETTING
    public  static void Displaying(int userOption,ArrayList<Bus>buses,ArrayList<Booking>book)
    {
        Scanner obj3=new Scanner(System.in);
        System.out.println("Enter 0 for Exit");
        System.out.println("Enter 2 for Seting Capacity");
        System.out.println("Enter 3 for Seting Date");
        System.out.println("Enter 4 for Seting Starting Point of Bus");
        System.out.println("Enter 5 for Seting Reaching Point of Bus");
        System.out.println("Enter 6 to Display Bus Details");
        System.out.println("Enter 7 to Display Booking Details");
        System.out.println("Enter 8 to get Total Number of Booking Done");
    
        userOption=obj3.nextInt();
    
            if(userOption>=2 && userOption<=5)
            {
                Bus obj=new Bus( userOption,buses,book);
            }
            else if(userOption==6)
            {
                Bus.displayBusDetails(buses,userOption,book);
            }
            else if(userOption==7)
                Booking.displayBookingDetails( book,userOption,buses);
            else if(userOption==8)
                Booking.BookingCount(book, userOption, buses);
         
    }


    //Getter
    public int getbusNo()
    {
        return busNo;
    }
    public boolean getACorNonAc()
    {
        return ACorNonAc;
    }
    public int getcapacity()
    {
        return capacity;
    }
    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }
    public Date getBusDate() {
        return busDate;
    }

    //Setter
    public void setBusDate(Date busDate) {
        this.busDate = busDate;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setFrom(String from) {
        From = from;
    }
    public void setTo(String to) {
        To = to;
    }
}