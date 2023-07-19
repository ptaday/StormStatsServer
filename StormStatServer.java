/**
 * @author Pushkar Taday
 * SBU ID:114375166
 * Recitation:04
 */

package Homework6;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class represents a server for keeping storms information
 */

public class StormStatServer {

    private static HashMap<String, Storm> database;

    /**
     * This main method consists of menu driven program for operations in the storm server.
     * @param args
     * arguments for String array
     * @throws IOException
     * if there is an input output exception
     */
    public static void main(String[] args) throws IOException {
        database = new HashMap<String, Storm>();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the StormStatServer, we may not be able to make it rain, but we sure can tell you when it happened!");

        System.out.println();

        boolean fileExists = false;
        File file = new File("hurricane.ser ");

        //Checks if file exists
        if (file.exists() && !file.isDirectory()) {
            fileExists = true;
        }

        if (fileExists) {

            try {


                FileInputStream fileInputStream = new FileInputStream("hurricane.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                     database=(HashMap<String,Storm>)objectInputStream.readObject();
                objectInputStream.close();
                
                fileInputStream.close();
                System.out.println("hurricane.ser was found and loaded.");
                System.out.println();

            }
            catch(IOException | ClassNotFoundException io)
            {
                io.printStackTrace();
            }

        } else {
            System.out.println("No previous data found!");
            System.out.println();
        }

        System.out.println("Menu:\n" +
                "\n" +
                "    A) Add A Storm\n" +
                "\n" +
                "    L) Look Up A Storm\n" +
                "\n" +
                "    D) Delete A Storm\n" +
                "\n" +
                "    E) Edit Storm Data\n" +
                "\n" +
                "    R) Print Storms Sorted By Rainfall\n" +
                "\n" +
                "    W) Print Storms by Windspeed\n" +
                "\n" +
                "    X) Save and quit\n" +
                "\n" +
                "    Q) Quit and delete saved data\n" +
                "\n" +
                " ");

        boolean check = true;

        while (check) {

            System.out.print("Please enter an option:");
            char ch = input.next().charAt(0);

            ch = Character.toUpperCase(ch);


            switch (ch) {
                case 'A':
                    System.out.print("Please enter name:");
                    String name = input.next();

                    name = name.toUpperCase();

                    input.nextLine();

                    if(database.containsKey(name))
                    {
                        System.out.println("Storm "+name+ " already exists! You can create a storm with a new name or go to the Edit option to change details regarding the storm.");
                        System.out.println();
                        break;
                    }

                    boolean checkDate = true;

                    System.out.print("Please enter date:");
                    String date = input.nextLine();


                    if(checkDate(date)) {
                        System.out.print("Please enter precipitation (cm):");
                        double precipitation = input.nextDouble();

                        System.out.print("Please enter windspeed (km/h):");
                        double windSpeed = input.nextDouble();

                        Storm newStorm = new Storm(name, precipitation, windSpeed, date);

                        database.put(newStorm.getName(), newStorm);

                        System.out.println(newStorm.getName() + " added.");
                    }

                    else
                    {
                        System.out.println("Invalid date format.");
                    }

                    System.out.println();

                    break;


                case 'L':
                    System.out.print("Please enter name:");
                    String lookUpName = input.next();

                    lookUpName = lookUpName.toUpperCase();

                    if (database.containsKey(lookUpName)) {
                        System.out.println();
                        System.out.println("Storm " + lookUpName + ": Date " + database.get(lookUpName).getDate() + ", " + database.get(lookUpName).getWindSpeed() + " km/h winds, " + database.get(lookUpName).getPrecipitation() + " cm of rain");

                    } else {
                        System.out.println("Key not found.");
                    }

                    System.out.println();
                    break;

                case 'D':
                    System.out.print("Please enter name:");
                    String removeName = input.next();

                    removeName = removeName.toUpperCase();

                    Storm removedStorm = database.remove(removeName);

                    if (removedStorm != null)
                        System.out.println("Storm " + removedStorm.getName() + " has been deleted.");

                    else
                        System.out.println("Storm " + removeName + " does not exist.");

                    System.out.println();

                    break;

                case 'E':
                    System.out.print("Please enter name:");
                    String editName = input.next();

                    input.nextLine();

                    editName = editName.toUpperCase();

                    if (database.containsKey(editName)) {

                        Storm editStorm = database.get(editName);

                        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

                        System.out.println("In Edit Mode, press enter without any input to leave data unchanged.");

                        System.out.print("Please enter date:");
                        String editDate = reader.readLine();

                        boolean flag=false; boolean dateFlag=true;

                        if(editDate.isEmpty()) {
                            flag=true;
                            dateFlag=false;
                        }

                         if(flag==false)
                         {
                             if(checkDate(editDate))
                                 dateFlag=false;
                         }


                         if (dateFlag==false) {

                                if(flag==false)
                                editStorm.setDate((editDate));
                                flag=true;
                            }

                            else
                            {
                                System.out.println("Invalid date format.");
                                flag=false;
                            }

                             if(flag)
                             {
                                System.out.print("Please enter precipitation (cm):");
                                String editPrecipitation = reader.readLine();

                                if (!editPrecipitation.isEmpty()) {
                                    double editPrecipitationValue = Double.parseDouble(editPrecipitation);
                                    editStorm.setPrecipitation(editPrecipitationValue);
                                }


                                System.out.print("Please enter windspeed (km/h):");
                                String editWindSpeed = reader.readLine();

                                if (!editWindSpeed.isEmpty()) {
                                    double editWindSpeedValue = Double.parseDouble(editWindSpeed);
                                    editStorm.setPrecipitation(editWindSpeedValue);
                                }
                                 System.out.println(editName+ " added.");
                            }
                    }else {
                        System.out.println("Key not found.");
                    }

                    System.out.println();
                    break;

                case 'R':
                    toPrint(null,new PrecipitationComparator());
                    break;


                case 'W':
                    toPrint(new WindSpeedComparator(),null);
                    break;

                case 'X':


                    if(fileExists==false)
                    {
                        file.createNewFile();
                    }
                    
                    try {

                        FileOutputStream fileOutputStream = new FileOutputStream("hurricane.ser");

                        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

                            outputStream.writeObject(database);

                        outputStream.close();

                        fileOutputStream.close();
                    }
                   catch(IOException io)
                    {
                        System.out.println(io);
                    }
                    check=false;

                    System.out.println("File saved to hurricane.ser; feel free to use the weather channel in the meantime.");
                    break;

                case 'Q':
                    if(fileExists)
                    {
                           file.delete();
                           fileExists=false;
                    }

                    check=false;

                    System.out.println("Goodbye, it's hard to hold an (electric) candle in the cold November (and April!) rain!.");

                    break;

                default:
                    System.out.println("Wrong option selected. Enter Again.");
                    System.out.println();


            }

        }
    }



    public static boolean checkDate(String date)
    {
        SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("yyyy-M-dd"),
                new SimpleDateFormat("yyyy-M-d"),
                new SimpleDateFormat("yyyy-MM-d")
        };

        boolean dateFlag=false;

        for (SimpleDateFormat format: possibleFormats) {
            try {
                format.setLenient(false);
                Date formattedDate= format.parse(date);
                dateFlag=true;
                break;
            }
            catch(Exception e)
            {

            }
        }

        return dateFlag;

    }

    public static void toPrint(WindSpeedComparator windSpeed,PrecipitationComparator precipitationComparator)
    {

        System.out.println();

        System.out.printf("%-20s%-15s%-15s%-20s\n", "Name", "Windspeed", "Rainfall", "Date");


        System.out.println("-------------------------------------------------------------------");

        if(database.size()!=0&&database.size()!=1) {
            ArrayList<Storm> storms = new ArrayList<Storm>(database.values());

            if(windSpeed==null){
            Collections.sort(storms, precipitationComparator);}

            if(precipitationComparator==null)
            {
                Collections.sort(storms, windSpeed);
            }



            for (int i = 0; i < storms.size(); i++) {
                System.out.println(storms.get(i).toString());
            }
        }

        else if(database.size()==1)
        {
            ArrayList<Storm> storms = new ArrayList<Storm>(database.values());

            System.out.println(storms.get(0));
        }

        else
        {
            System.out.println();
            System.out.println();
            System.out.println();
        }
        System.out.println();

    }
}
