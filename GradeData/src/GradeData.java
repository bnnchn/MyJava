
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author Bonnie Chan
 */
public class GradeData {
    /**
     * sort grades in ascending order.
     * @param data an integer array of grades.
     * @param length the number of grades in the array to sort.
     */
    static void bubbleSort(int[] data, int length){
        boolean swap = false;
        do{
            swap = false;
            for (int i=1; i<length; i++){
                if (data[i-1] > data[i]){
                    int tmp = data[i-1];
                    data[i-1] = data[i];
                    data[i]=tmp;
                    swap = true;
                }
            }
        } while (swap);
    }

    /**
     *
     * @param data an integer array of grades.
     * @param length the number of grades in the array.
     * @return computed mean.
     */
    static double mean(int[] data, int length){
        double sum = 0;
        for (int i=0; i<length; i++){
            sum+=data[i];
        }
        return sum/length;
    }

    /**
     *
     * @param sortedData an integer array of grades sorted in ascending order.
     * @param length the number of grades in the array.
     * @return middle score in given array.
     */
    static int median(int[] sortedData, int length){
        int middle = length/2;
        return sortedData[middle];
    }

    /**
     * Reading in data from file and adding grades to the array.
     * @param fileName name of file to read scores from.
     * @param data an integer array of grades.
     * @return the number of grades loaded from file and stored in the array.
     */
    static int loadData(String fileName, int[] data){
        int i = 0;
        try{
            FileReader fileReader = new FileReader (fileName);
            Scanner fileScanner = new Scanner (fileReader);
            while(fileScanner.hasNext()){
                int score = fileScanner.nextInt();
                data[i] = score;
                i++;
            }
            fileScanner.close();
            System.out.println("Data read successfully.");
            return i;
        }catch(Exception e){
            System.out.println("Fail to read file.");
        }
        return 0;
    }

    /**
     *
     * @param sortedData an integer array of grades sorted in ascending order.
     * @param length the number of grades in the array.
     * @return a string of the computed statistics for output to user.
     */
    static String stats(int[] sortedData, int length){
        bubbleSort(sortedData, length);
        int min = sortedData[0];
        int max = sortedData[length-1];
        double mean = mean(sortedData, length);
        int median = median(sortedData, length);
        String stats = "Below are the compute values:\n";
        stats += "Min        = " + min + "\n";
        stats += "Max        = " + max + "\n";
        stats += "Mean       = " + mean + "\n";
        stats += "Median     = " + median;
        return stats;
    }

    /**
     * stores a string of computed statistics and writes it to fileName.
     * @param fileName name of file to write scores to.
     * @param stats a string of the computed statistics for output to user.
     */
    static void saveStats(String fileName, String stats){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(stats);

            fileWriter.close();
            System.out.println("Result saved successful.");
        }catch(Exception e){
            System.out.println("Unable to write to file");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int dataLength = 0;
        int[] data = new int[1000];
        int choice;

        do{
            System.out.println("Choose an option:");
            System.out.println("1. Load data");
            System.out.println("2. Display computed statistics");
            System.out.println("3. Save computed statistics");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (choice == 1){
                //ask user for input file to be read and load data from given file.
                System.out.print("Enter the name of the file: ");
                String fileName = scanner.nextLine();
                dataLength = loadData(fileName, data);
                System.out.println();
            } else if (choice == 2){
                //display computed statistics to user on screen
                String displayStats = stats(data, dataLength);
                System.out.println(displayStats);
                System.out.println();
            } else if (choice == 3){
                //write computed statistics and save to a file given by user.
                String saveStats = stats(data, dataLength);
                System.out.print("Enter the name of the file: ");
                String fileName = scanner.nextLine();
                saveStats(fileName, saveStats);
                System.out.println();
            }
        }while(choice != 4);
        //exit program
        System.out.println("Goodbye!");

    }
}


