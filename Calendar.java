import java.util.*;
import java.io.*;

import static org.junit.Assert.*;
import org.junit.Test;

/****************************************************************************
* 
* TEAM NAME:            Tamarind
* 
* MEMBERS               Ken Wallace, Kevin Nguyen, Gary Tang
* 
* HOMEWORK:             iCalendar Project
*
* CLASS:                ICS 314
*
* INSTRUCTOR:           Brent Auernheimer
*
<<<<<<< HEAD
* DATE:                 April 4, 2015
*              
* FILE:                 Calendar.java
*      
* DESCRIPTION:          Checkin-3. Creates ics file from user input. Creates free time files
=======
* DATE:                 March 13, 2015
*              
* FILE:                 Calendar.java
*      
* DESCRIPTION:          Creates ics file from user input.
>>>>>>> origin/master
*
*****************************************************************************/
class Calendar {
   private static Scanner input;
   
   public Calendar() {
      input = new Scanner(System.in);
   }
      
   public static class Event {
      public String begin, version, calscale, publish, calname, timezone, begin2,
      dStart, dEnd, classType, location, summary, priority, end, end2, filename;

      public Event() {
         begin = "BEGIN:VCALENDAR\n";
         version = "VERSION:2.0\n";
         calscale = "CALSCALE:GREGORIAN\n";
         publish = "METHOD:PUBLISH\n";
         calname = "X-WR-CALNAME:LonganCal\n";
         timezone = "X-WR-TIMEZONE:Pacific/Honolulu\n";
         begin2 = "BEGIN:VEVENT\n";
         //empty because user defines it
         dStart = "";
         dEnd = "";
         classType = "";
         location = "";
         summary = "";
         priority = "";
         end = "END:VEVENT\n";
         end2 = "END:VCALENDAR\n";
         //extra name to save the file as
         filename = "";
      }
      
      public void setStart(String result) {
         dStart = result;
      }
      
      public void setEnd(String result) {
         dEnd = result;
      }
      
      public void setVisibility(String result) {
         classType = result;
      }
      
      public void setLocation(String result) {
         location = result;
      }
      
      public void setSummary(String result) {
         summary = result;
      }
      
      public void setPriority(String result) {
         priority = result;
      }
      
      public void setFilename(String result) {
         filename = result;
      }
   }
   
   public int startUp() {
      int userChoice = 0;
      System.out.println("What would you like to do?");
      System.out.println("[1] Create a calendar event");
      System.out.println("[2] Compute free time from list of events");
      System.out.println("[3] Find common free times from 2 or more lists of events");
      System.out.println("[4] Exit");
      System.out.print("Please type the corresponding number of choice: ");
      while (!input.hasNextInt() || (userChoice = input.nextInt()) < 1 || userChoice > 4) {
         System.out.println("\n**INVALID: Please choose a number from 1 to 4.");
         System.out.println("What would you like to do?");
         System.out.println("[1] Create a calendar event");
         System.out.println("[2] Compute free time from list of events");
         System.out.println("[3] Find common free times from 2 or more lists of events");
         System.out.println("[4] Exit");
         System.out.print("Please type the corresponding number of choice: ");
      }
      if (userChoice == 1) {
         System.out.println("Your choice: [1] Create a calendar event\n");
         return userChoice;
      }
      else if (userChoice == 2) {
         System.out.println("Your choice: [2] Compute free time from list of events\n");
      }
         else if (userChoice == 3) {
             System.out.println("Your choice: [3] Find common free times from 2 or more lists of events\n");
         }
            else {
               System.out.println("Your choice: [4] Exit\n");
            }
      input.nextLine();
      return userChoice;
   }
   
   public String getVisibility() {
      int userChoice = 0;
      String result = "";
      //Asking for visibility
      System.out.println("What is the visibility for this event?");
      System.out.println("[1] PUBLIC");
      System.out.println("[2] PRIVATE");
      System.out.println("[3] CONFIDENTIAL");
      System.out.print("Please type the corresponding number of choice: ");
      //Visibility must be between 1 and 3
      while (!input.hasNextInt() || (userChoice = input.nextInt()) < 1 || userChoice > 3) {
         input.nextLine();
         System.out.println("\n**INVALID: Please choose a number from 1 to 3.");
         System.out.println("What is the visibility for this calendar?");
         System.out.println("[1] PUBLIC");
         System.out.println("[2] PRIVATE");
         System.out.println("[3] CONFIDENTIAL");
         System.out.print("Please type the corresponding number of choice: ");		
      }
      //Storing visibility to class type
      if (userChoice == 1) {
         result = "CLASS:PUBLIC\n";
         System.out.println("Your choice: [1] PUBLIC");
      }
      else if (userChoice == 2) {
         result = "CLASS:PRIVATE\n";
         System.out.println("Your choice: [2] PRIVATE");
      }
         else {
            result = "CLASS:CONFIDENTIAL\n";
            System.out.println("Your choice: ...well that's confidential.");
         }
      input.nextLine();
      return (result);
   }
   
   public String getDateTime(String option) {   
      int year = 0;
      int month = 0;
      int day = 0;
      int hour = 0;
      int minute = 0;
      String result = "";
      String yearString = "";
      String monthString = "";
      String dayString = "";
      String hourString = "";
      String minuteString = "";
      String date = "";
      String time = "";
      //DSTART
      if(option.equals("start")) {
         result = "DTSTART:";
         System.out.println("\nPlease enter start date: ");
      }
      //DEND
      else {
         result = "DTEND:";
         System.out.println("\nPlease enter end date: ");
      }
      //Asking for year
      System.out.print("Year: ");
      while (!input.hasNextInt() || (year = input.nextInt()) < 1000 || year > 9999) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a 4-digit year.");
         System.out.print("Year: ");
      }    
      yearString = ((Integer) year).toString();
      input.nextLine();
      //Asking for month
      System.out.print("Month: ");
      while (!input.hasNextInt() || (month = input.nextInt()) < 1 || month > 12) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a month from 1 to 12.");
         System.out.print("Month: ");
      }
      //Pads a 0 if month is not 2 digits
      if (month < 10) {
         monthString = "0" + month;
      }
      //2 digit month, no padding
      else {
         monthString = ((Integer)month).toString();
      }
      input.nextLine();
      //Asking for day
      System.out.print("Day: ");
      while (!input.hasNextInt() || (day = input.nextInt()) < 1 || day > 31) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a day from 1 to 31.");
         System.out.print("Day: ");
      }
      //day is not 2 digit, add padding
      if (day < 10) {
         dayString = "0" + ((Integer)day).toString();
      }
      //day is 2-digit, no padding
      else {
         dayString = ((Integer)day).toString();
      }
      input.nextLine();
      //Asking for hour
      System.out.println("\nPlease enter the start time in military time. (i.e. 4PM is 16)");
      System.out.print("Hour: ");
      while (!input.hasNextInt() || (hour = input.nextInt()) < 0 || hour > 24) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a hour from 0 to 24");
         System.out.print("Hour: ");
      }
      //padding
      if (hour < 10) {
         hourString = "0" + ((Integer)hour).toString();
      }
      else {
         hourString = ((Integer)hour).toString();
      }
      input.nextLine();
      //Asking for minute
      System.out.print("Minute: ");
      while (!input.hasNextInt() || (minute = input.nextInt()) < 0 || minute > 59) {
         input.nextLine();
         System.out.println("**INVALID: Please enter minutes from 0 to 59");
         System.out.print("Minute: ");
      }
      //padding
      if (minute < 10) {
         minuteString = "0" + ((Integer)minute).toString();
      }
      else {
         minuteString = ((Integer)minute).toString();
      }
      input.nextLine();
      //Create DT
      date = yearString + monthString + dayString;
      time = hourString + minuteString;    
      result = result + date + "T" + time + "00\n";
      return result;
   }
   
   public String getSummary() {
      String result = "";
      String temp = "SUMMARY:";
      System.out.println("\nPlease enter summary of event: ");
      result = input.nextLine();
      result = temp + result + "\n";
      return result;
   }
   
   public String getLocation() {
      String result = "";
      String temp = "LOCATION:";
      System.out.print("\nPlease enter location of event: ");
      result = input.nextLine();
      result = temp + result + "\n";
      return result;
   }

   public String getPriority() {
      int userChoice = 0;
      String result = "";
      //Asking for priority
      System.out.println("\nWhat is the priority of the event?");
      System.out.println("[0] N/A");
      System.out.println("[1] HIGH");
      System.out.println("[2] MEDIUM");
      System.out.println("[3] LOW");
      System.out.print("Please type the corresponding number of choice: ");
      //Priority must be between 0 and 3
      while (!input.hasNextInt() || (userChoice = input.nextInt()) < 0 || userChoice > 3) {
         input.nextLine();
         System.out.println("\n**INVALID: Please choose a number from 0 to 3.");
         System.out.println("What is the priority of the event?");
         System.out.println("[0] N/A");
         System.out.println("[1] HIGH");
         System.out.println("[2] MEDIUM");
         System.out.println("[3] LOW");
         System.out.print("Please type the corresponding number of choice: ");
      }
      //Storing priority to class type
      //0 no priority
      if (userChoice == 0) {
         result = "PRIORITY:0\n";
         System.out.println("Your choice: [0] N/A");
      }
      //1-4 high
      else if (userChoice == 1) {
         result = "PRIORITY:1\n";
         System.out.println("Your choice: [1] HIGH");
      }
         //5 medium
         else if (userChoice == 2) {
            result = "PRIORITY:5\n";
            System.out.println("Your choice: [2] MEDIUM");
         }
            //6-9 low
            else {
            	result = "PRIORITY:9\n";
            	System.out.println("Your choice: [3] LOW");
            }
      input.nextLine();
      return result;
   }
   
   public String getFilename() {
      //**currently does NOT error check if user inputs invalid characters that the operating system will not allow in filenames
      String result = "";
      System.out.print("\nFinally, please enter the filename to save as: ");
      result = input.nextLine();
      result = result + ".ics";
      return result;
   }
   
   public void createFile(Event event) throws IOException {
      PrintWriter pw = new PrintWriter(new FileWriter(event.filename));
      pw.write(event.begin + event.version + event.calscale + event.publish + event.calname + event.timezone + event.begin2 + event.dStart + event.dEnd + event.classType + event.location + event.summary + event.priority + event.end + event.end2);
      pw.close();
   }
   
   //Compares 2 military times as string
   //returns 1 if t1 is greater than t2
   //returns -1 if t1 is less than t2
   //returns 0 if t1 is equal to t2
   public static int compareTime(String t1, String t2){
	   int t1h = Integer.valueOf(t1.substring(0, 2));
	   int t1m = Integer.valueOf(t1.substring(2, 4));
	   int t2h = Integer.valueOf(t2.substring(0, 2));
	   int t2m = Integer.valueOf(t2.substring(2, 4));
	   int result = 0;
      
	   if (t1h < t2h) {
		   result = -1;
	   }
	   else if (t1h > t2h) {
		   result = 1;
	   }
	   //t1h = t2h
	   else {
		   if (t1m == t2m) {
			   result = 0;
		   }
		   else if (t1m < t2m) {
			   result = -1;
		   }
   		   else if (t1m > t2m) {
   			   result = 1;
   		   }
	   }
	   return result;	   
   }
   
   //Generates free time files and returns an arraylist of free time events.
   public static ArrayList<Event> generateFreeTimes(String filename, Calendar cal, boolean flag) throws IOException {
       ArrayList<String> fileList = new ArrayList<String>();
       ArrayList<Event> eventList = new ArrayList<Event>();
       ArrayList<Event> freeTimeList = new ArrayList<Event>();
       int startTime = 0;
       int endTime = 0;
       int prevStartTime = 0;
       int prevEndTime = 0;
       int count = 0;
       Event tempEvent = null;
       String startTimeString, endTimeString, prevStartTimeString, prevEndTimeString;
       String startDateString = null;
       String endDateString = null;
       String dtstart, dtend;
       Scanner scan = null;    

       try {
           scan = new Scanner(new File(filename));
       }
       catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       //Storing ics filenames
       while (scan.hasNext()) {
           fileList.add(scan.nextLine());
       }
       //Process ics files
       for (int i = 0; i < fileList.size(); i++) {       
           try {
               scan = new Scanner(new File(fileList.get(i)));
           }
           catch (FileNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           //go to  BEGIN:VEVENT
           while ((scan.nextLine().compareTo("BEGIN:VEVENT")) != 0) {
           }
           dtstart = scan.next();
           dtend = scan.next();
           startDateString = dtstart;
           endDateString = dtend;
           //System.out.println("start: " + dtstart);
           //System.out.println("end: " + dtend);
           //remove date and T, z
           dtstart = dtstart.substring(17, 21);
           dtend = dtend.substring(15, 19);
           //System.out.println("start: " + dtstart);
           //System.out.println("end: " + dtend);
           //Store event w start and end times
           tempEvent = new Event();
           tempEvent.setStart(dtstart);
           tempEvent.setEnd(dtend);
           eventList.add(tempEvent);
       }
       //Sort events according to start time by insertion sort
       for (int i = 0; i < eventList.size(); i++) {
           tempEvent = eventList.get(i);
           //(compareTime(eventList.get(i).dStart, eventList.get(j).dStart) == -1)
           //tempEvent.dStart = start time of event i
           //eventList.get(j).dStart = start time of event j
           int j;
           for (j = i - 1; j >= 0 && (compareTime(tempEvent.dStart, eventList.get(j).dStart) == -1); j--) {
               eventList.set(j + 1, eventList.get(j));                             
           }
           eventList.set(j + 1, tempEvent);            
       }
       //test print
       //for(int i = 0; i < eventList.size(); i++){
       //System.out.println(eventList.get(i).dStart);
       //} 
       //trim off time and z
       startDateString = startDateString.substring(0, 17);
       endDateString = endDateString.substring(0, 15);
       //generate free time slots
       for (int i = 0; i < eventList.size(); i++) {
           tempEvent = new Event();
           startTimeString = eventList.get(i).dStart;
           endTimeString = eventList.get(i).dEnd;
           startTime = Integer.valueOf(startTimeString);
           endTime = Integer.valueOf(endTimeString);
           //Start section
           if (i == 0) {             
               if (startTime != 0) {
                   tempEvent.setStart(startDateString + "000000\n");
                   tempEvent.setEnd(endDateString + startTimeString + "00\n");
               }
               //Set rest of free file fields
               tempEvent.setLocation("LOCATION:NA\n");
               tempEvent.setPriority("PRIORITY:NA\n");
               tempEvent.setSummary("SUMMARY:FREE TIME\n");
               tempEvent.setVisibility("CLASS:PUBLIC\n");
               tempEvent.setFilename("Free" + count + ".ics");
               //Add to free time arraylist
               freeTimeList.add(tempEvent);
               //if we are using this function to get an arraylist, not actually write to file
               if (flag != true) {
                  cal.createFile(tempEvent);
               }
               //Number of free files
               count++;                
           }
           //Not first section
           else {
               //Middle section
               prevStartTimeString = eventList.get(i - 1).dStart;
               prevEndTimeString = eventList.get(i - 1).dEnd;
               prevStartTime = Integer.valueOf(prevStartTimeString);
               prevEndTime = Integer.valueOf(prevEndTimeString);
               //No free time
               if (prevEndTime == startTime) {
               }
               else {
                   tempEvent.setStart(startDateString + prevEndTimeString + "00\n");
                   tempEvent.setEnd(endDateString + startTimeString + "00\n");
               }
               //Set rest of free file fields
               tempEvent.setLocation("LOCATION:NA\n");
               tempEvent.setPriority("PRIORITY:NA\n");
               tempEvent.setSummary("SUMMARY:FREE TIME\n");
               tempEvent.setVisibility("CLASS:PUBLIC\n");
               tempEvent.setFilename("Free" + count + ".ics");
               //if we are using this function to get an arraylist, not actually write to file
               if (flag != true) {
                  cal.createFile(tempEvent);
               }
               //Add to free time arraylist
               freeTimeList.add(tempEvent);
               //Number of free files
               count++;               
           }
           //Only one event
           //End section, possibility of creating 2 files.
           if (eventList.size() == 1 || i == (eventList.size() - 1)) {
               //End section
               if (endTime != 24) {
                   tempEvent = new Event();
                   tempEvent.setStart(startDateString + endTimeString + "00\n");
                   tempEvent.setEnd(endDateString + "240000\n");
                   //Set rest of free file fields
                   tempEvent.setLocation("LOCATION:NA\n");
                   tempEvent.setPriority("PRIORITY:NA\n");
                   tempEvent.setSummary("SUMMARY:FREE TIME\n");
                   tempEvent.setVisibility("CLASS:PUBLIC\n");
                   tempEvent.setFilename("Free" + count + ".ics");
                   //if we are using this function to get an arraylist, not actually write to file
                   if (flag != true) {
                     cal.createFile(tempEvent);
                   }
                   //Add to free time arraylist
                   freeTimeList.add(tempEvent);
                   //Number of free files
                   count++;
               }                   
           }
       }
       //List of free time events.
       return freeTimeList;
   }
     
   public static void generateCommonFreeTimes(String fileName1, String fileName2, Calendar cal) throws IOException {
      ArrayList<Event> freeTimeList1;
      ArrayList<Event> freeTimeList2;
      int listLength;
      int count = 0;
      int test;
      Event tempEvent = null;
      String startTime1, endTime1, startTime2, endTime2, 
      dtStartString1, dtEndString1,dtStartString2, dtEndString2;
      boolean createF = false;
      boolean flag = true;
      //Free times of the 2 list
      freeTimeList1 = generateFreeTimes(fileName1, cal, flag);
      freeTimeList2 = generateFreeTimes(fileName2, cal, flag);
      //Generate common free times
      //iterates through list 1
      for (int i = 0; i < freeTimeList1.size(); i++) {
         //Get start and end time for event in list 1
         dtStartString1 = freeTimeList1.get(i).dStart;
         dtEndString1 = freeTimeList1.get(i).dEnd;
         //Remove date, T
         startTime1 = dtStartString1.substring(17,21);
         endTime1 = dtEndString1.substring(15,19);
         //iterates through list 2
         for (int j = 0; j < freeTimeList2.size(); j++) {
            tempEvent = new Event();
            //Get start and end time for event in list 2
            dtStartString2 = freeTimeList2.get(j).dStart;
            dtEndString2 = freeTimeList2.get(j).dEnd;
            //Remove date,t
            startTime2 = dtStartString2.substring(17,21);
            endTime2 = dtEndString2.substring(15,19);
            //Generate Common Free Times
            //Case 1: 
            //startTime2 within event1
            if (compareTime(startTime2, startTime1) >= 0 && compareTime(startTime2, endTime1) < 0) {
               //endTime2 within event1
               if (compareTime(endTime2, endTime1) <= 0) {
                  tempEvent.setStart(dtStartString2);
                  tempEvent.setEnd(dtEndString2);
                  createF = true;
               }
               //endTime2 > endTime1
               else {
                  tempEvent.setStart(dtStartString2);
                  tempEvent.setEnd(dtEndString1);
                  createF = true;
               }
            }
            //Case 2:
            //startTime1 within event2
            else if (compareTime(startTime1, startTime2) >= 0 && compareTime(startTime1, endTime2) < 0) {
               //endTime1 within event 2
               if (compareTime(endTime1, endTime2) <= 0) {
               //if (endTime1 <= endTime2) {
                  tempEvent.setStart(dtStartString1);
                  tempEvent.setEnd(dtEndString1);
                  createF = true;
               }
               //endTime1 > endTime2
               else {
                  tempEvent.setStart(dtStartString1);
                  tempEvent.setEnd(dtEndString2);
                  createF = true;
               }
            }
               else {
                  createF = false;
               }
            //create file
            if (createF == true) {
               //Set rest of file fields
               tempEvent.setLocation("LOCATION:NA\n");
               tempEvent.setPriority("PRIORITY:NA\n");
               tempEvent.setSummary("SUMMARY:POSSIBLE MEETING TIME\n");
               tempEvent.setVisibility("CLASS:PUBLIC\n");
               tempEvent.setFilename("Common_Free_Times" + count + ".ics");
               System.out.println("i: " + i + " j: " + j);
               System.out.println("start: " + tempEvent.dStart);
               System.out.println("end: " + tempEvent.dEnd);
               cal.createFile(tempEvent);
               createF = false;
               //Number of free files
               count++;              
            }
         }   
      }      
   }
   
   public static void main(String[] args) throws IOException {            
      Calendar cal = new Calendar();
      String inputFilename1, inputFilename2;
      int start = 0;
      boolean flag = false;
   
      System.out.println("Welcome!");
      //if they want to create an event
      while ((start = cal.startUp()) == 1 || start == 2 || start == 3) {
         if (start == 1) {
            Event event;
            event = new Event();
            //asking for visibility
            event.setVisibility(cal.getVisibility());
            //asking for start and end times
            event.setStart(cal.getDateTime("start"));
            event.setEnd(cal.getDateTime("end"));
            event.setSummary(cal.getSummary());
            event.setLocation(cal.getLocation());
            event.setPriority(cal.getPriority());
            event.setFilename(cal.getFilename());
            cal.createFile(event);
            System.out.println("Your calendar event has finish propagating. Thank you.\n");
         }
         //if they want to compute free times between events
         else if (start == 2) {
        	//Retrieve file w list of events
            System.out.println("Please type the name of the file (.txt) containing a list of calendar events on the same date:");
            inputFilename1 = input.nextLine();
            generateFreeTimes(inputFilename1, cal, flag);
            System.out.println("Event files of free time have been created. Please check your working directory for the files.");
         }
         //if they want to compare two list for common free times
            else {
                //Retrieve files w list of events
                System.out.println("Please type the name of the first file (including the .txt extension) containing a list of calendar events on the same date:");
                inputFilename1 = input.nextLine();
                System.out.println("Please type the name of the second file (including the .txt extension) containing a list of calendar events on the same date as the previous list:");
                inputFilename2 = input.nextLine();
                generateCommonFreeTimes(inputFilename1, inputFilename2, cal);
                System.out.println("Event files of mutual free time have been created. Please check your working directory for the files.");
            }
      }
      //if they wanted to exit, they would hop out the loop
      System.out.println("Thank you. Good bye.");
      input.close();
   }
}
