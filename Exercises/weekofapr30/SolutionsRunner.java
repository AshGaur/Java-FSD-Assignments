package weekofapr30;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
class SolutionsRunner{
    public static void main(String[] args) {
        exerciseSelection();
    }
    static void exerciseSelection(){
        SolutionMethods sol = new SolutionMethods();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome !\n");
        System.out.println(getExercisesInfoFromFile());
        
        String op = "exit";
        do{
            System.out.print("Please Enter an exercise seq to run from 1 to 8 or type exit to quit:");
            op = sc.hasNextLine()?sc.nextLine():"-1";
            switch(op){
                case "1": sol.trafficSimulator(sc);break;
                case "2": sol.nthFibonacci(sc);break;
                case "3": sol.primesPrinter(sc);break;
                case "4": sol.durationForInputDate(sc);break;
                case "5": sol.sumOfCubesOfDigits(sc);break;
                case "6": sol.numReverseArraySort(sc);break;
                case "7": sol.secondSmallest(sc);break;
                case "8": sol.sumOfDivBy3Or5(sc);break;
                case "exit": break;
                default : System.out.println("Invalid Input !");break;
            }

        }while(!op.toLowerCase().equals("exit"));
    }
    static String getExercisesInfoFromFile(){
        String fileContents = "";

        try{
            File f = new File("weekofapr30/ExercisesDescription.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                fileContents+=sc.nextLine()+"\n";
            }
        }catch(FileNotFoundException e){
            System.out.println();
        }

        return fileContents;
    }

}