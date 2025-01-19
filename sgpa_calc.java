//This Code Calculates the SGPA for the 1st Semester B.Tech Students 
import java.util.*;
class sgpa_calc
{
    static String name;
    static int marks_int[]=new int[10];//To store Internal marks
    static int marks_ext[]=new int[10];//To store External Marks
    static char grade[]=new char[10];//To store grade obtained in individual grade
    static String sub1[]={"MATHS   ","Chemistry","English","B.  Etc","BE Engn","Elective","Enggn Lab","Workshop","Chem Lab","Commn Lab"};
    static int credit[]={4,3,2,2,2,2,1,1,1,1};
    static double sg=0.0;
    static int sum=0;
    
    static double tc=19.0;
    Scanner sc=new Scanner(System.in);
    void input()
    {
        
        System.out.println("Please Enter your name !!!");  //Enter Student's Name
        name=sc.nextLine();
    }
    
    void input_sem1()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Please Enter your Internal Marks out of 50 in "+sub1[i]); 
            marks_int[i]=sc.nextInt(); //Taking Internal Marks Input
            
            System.out.println("Please Enter your External Marks out of 50 in "+sub1[i]);
            
            marks_ext[i]=sc.nextInt();//Taking External Marks Input
        }
    }
    
    void calc_grade()
    {
        for(int i=0;i<10;i++)
        {
            double in=marks_int[i];
            double ex=marks_ext[i];
            double sum=in+ex;
            
            if(sum>=90)
            grade[i]='O'; //Grade is Outstanding
            
            else if(sum>=80 && sum<90)
            grade[i]='E'; //Grade is Excellent
            
            else if(sum>=70 && sum<80)
            grade[i]='A'; //Grade is Average
            
            else if(sum>=60 && sum<70)
            grade[i]='B'; //Grade is Below Average
            
            else if(sum>=50 && sum<60)
            grade[i]='C'; //Grade is Need for Improvement
            
            else if(sum>=40 && sum<50)
            grade[i]='D'; //Grade is Just Pass
            
            else
            grade[i]='F'; //You have Failed in this particular Subject
            
        }
    }
    int csum=0;
    int sum_pt()
    {
        for(int i=0;i<10;i++)
        {
            sum=marks_int[i] + marks_ext[i];
            
            int p=0;
            if(sum>=90)
            p=10; //Calculating points...10 pointer
            
            else if(sum>=80 && sum<90)
            p=9; // 9 pointer
            
            else if(sum>=70 && sum<80)
            p=8; // 8 pointer
            
            else if(sum>=60 && sum<70)
            p=7; // 7 pointer
        
            
            else if(sum>=50 && sum<60)
            p=6; // 6 ponter
            
            else if(sum>=40 && sum<50)
            p=5; // 5 ponter
            
            else
            p=0; // You have failed so 0 points in that particular subject
            
            
             csum = csum + (p*credit[i]); //Calculating total points multipying it with credits
        }
        
        return csum;
        
        
    }
    
    double calc_sg()
    {
        int s=sum_pt();
        
        sg= s/tc;
        return sg; //Calculated the sgpa
    }
    
    
    public static void main(String args[])
    {
        sgpa_calc obj=new sgpa_calc();
        obj.input();
        obj.input_sem1();
        obj.calc_grade();
        double sgpa=obj.calc_sg();
        
        System.out.println("Your name is : "+name+"\n\n");
        System.out.println( " Subject "+ "    Credit    "+"    Internal    "+"External   "+"  Grade ");       
        for(int i=0;i<10;i++)
        {
            System.out.println(" "+sub1[i]+"         "+credit[i]+"            "+marks_int[i]+"        "+marks_ext[i]+"            "+grade[i]);
            
        }
        
        System.out.println("\n\n "+name + " Your calculated SGPA for this Semester is = "+sgpa);
        
        
    }
    
}