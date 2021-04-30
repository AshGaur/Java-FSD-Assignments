class Student{
    //using concepts of constructor and getter, setters
    int marks1;
    int marks2;
    int marks3;
    int total;

    Student(int marks1,int marks2,int marks3){
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    int getMarks1(){
        return marks1;
    }

    int getMarks2(){
        return marks1;
    }

    int getMarks3(){
        return marks1;
    }

    int getTotal(){
        return total;
    }

    void setTotal(){
        this.total = this.marks1+this.marks2+this.marks3;
    }

    boolean passStatus(){
        return this.getMarks1()>=40 && this.getMarks2()>=40 && this.getMarks3()>=40 && this.getTotal()>=125;
    }

    void displayResult(){
        String result = this.passStatus()?"Passed":"Failed";
        System.out.println("The student has "+result);
    }

}

class GetStudentPassStatus{
    public static void main(String[] args) {
        Student stud1 = new Student(41,41,43);
        Student stud2 = new Student(50,60,70);
        Student stud3 = new Student(40,40,41);
        stud1.setTotal();
        stud2.setTotal();
        stud3.setTotal();
        stud1.displayResult();
        stud2.displayResult();
        stud3.displayResult();
    }
}