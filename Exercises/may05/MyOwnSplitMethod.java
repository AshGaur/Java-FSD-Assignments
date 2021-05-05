package may05;
class MyOwnSplitMethod{
    public static void main(String[] args) {
        System.out.println("Enter string");
        String inputString = new java.util.Scanner(System.in).nextLine();
        System.out.println("enter delimiter string");
        String delimiter = new java.util.Scanner(System.in).nextLine();

        System.out.println("After My Split method:");
        for(String temp:mySplit(delimiter,inputString)){
            System.out.println(temp);
        }

        System.out.println();

        System.out.println("Java split method:");
        for(String temp:inputString.split(delimiter)){
            System.out.println(temp);
        }
    }
    public static String[] mySplit(String delimiter,String origStr){
        int arrayEndIndex = 0;
        String temp = new String(origStr);

        while(temp.contains(delimiter)){
            arrayEndIndex+=1;
            temp = temp.replaceFirst(delimiter,"");
        }

        String output[] = new String[arrayEndIndex+1];
        temp = new String(origStr);

        int i = 0;
        while(temp.contains(delimiter)){
            int ind = temp.indexOf(delimiter);
            output[i] = temp.substring(0,ind); 
            temp = temp.substring(ind+delimiter.length());
            i++;
        }
        output[arrayEndIndex] = temp.substring(0);

        return output;
    }
}