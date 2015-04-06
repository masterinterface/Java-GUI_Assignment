/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultipleChoiceProject;

/**
 *
 * @author bca
 */
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author bca
 */
public class ReadStudentFile
{   
    //declare a collection of Student objects
    ArrayList<Student> studentCollection = new ArrayList<Student>();
    
    //instatiate a CorrectAnswers object
    CorrectAnswers answers = new CorrectAnswers();
    
    //class constructor 

    /**
     *
     * @param studentFileName
     * @param answerFileName
     */
        public ReadStudentFile(String studentFileName, String answerFileName)
    {
        studentFileIn(studentFileName);
        answerFileIn(answerFileName);
        calcExamResult();
        
    }
        
        //implementation of method to read the student file 
        //takes string file name as argument

    /**
     *
     * @param studentFileName
     */
            public void studentFileIn(String studentFileName)
        {
            //The BufferedReader class can speed up IO quite a bit
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(studentFileName));
                String read = null;
                
                //when readline() gets to end of line it will stop
                while ((read = in.readLine()) != null) 
                {
                    readTheLine(read);
                }

            } catch (IOException e) {
                System.out.println("There was a problem: " + e);
                e.printStackTrace();
            } finally 
            {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        
        //implementation of method to read the correct answers file 
        //takes string file name as argument       

    /**
     *
     * @param answerFileName
     */
            public void answerFileIn(String answerFileName)
        {
            //The BufferedReader class can speed up IO quite a bit
            BufferedReader in = null;      
            try 
                {   
                    //BufferedReader reads text from a character-input stream (here -> the FileReader), buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
                    in = new BufferedReader(new FileReader(answerFileName));
                    String read = null;

                    //when readline() gets to end of line it will stop
                    while ((read = in.readLine()) != null) 
                    {
                        //separate values by comma and place in an array     
                        String[] splited = read.split(",");

                        //convert String array to int array
                        int[] splitedNumbers = new int[splited.length];

                        //a loop to convert each coma sparated input string to an integer
                        for(int i = 0;i < splited.length;i++)
                        {                
                           splitedNumbers[i] = Integer.parseInt(splited[i]);
                        }

                        //input the array to the CorrectAnswer object answers
                        answers.setCorrect(splitedNumbers);               
                    }
                }   
            //exception handling
            catch (IOException e) 
                {
                    System.out.println("There was a problem: " + e);
                    e.printStackTrace();
                } 

            finally 
                {
                    try 
                    {   
                        //close th BufferedReader object
                        in.close();
                    } 
                    catch (Exception e) {
                    }
                }



        }
    
    // a method to calculate each student's results for the exam. 

    /**
     *
     */
        public void calcExamResult()
    {         
        //fetch the correct exam answeres from a the CorrectAnswers instance
        int[] correctAnswers = answers.getCorrect();        
        
        //a loop to go through each list item (instantiated student object) and perform calculations
        for(Student s : studentCollection)
        {   
            //declare a result for the student
            double result = 0;
            
            //fetch the student's answers to the exam questions. 
            int[] thisAnswers = s.getAnswers();

            //a loop to go through each answer calculate the student's final result
            for(int i = 0; i<20; i++)
            {
                //when the student's answer matches the correct answer -> result incremented by getCORRECT()
                if(thisAnswers[i] == correctAnswers[i])
                    result += answers.getCORRECT();
                
                //when the student chose not to answer -> result incremented by getNOANSWER()
                else if(thisAnswers[i] == 0)
                    result += answers.getNOANSWER();
                
                //when the student chose not to answer -> result incremented by getINCORRECT()
                else result += answers.getINCORRECT();
            }
            
            //set the final result field in the student object
            s.setResult(result);
        }
                
    }
    //a method to read the csv values associated with a new student object, and add this new object to an ArrayList of Students

    /**
     *
     * @param read
     */
        public void readTheLine(String read)
                    {
                    //separate values by comma and place in an array       
                    String[] splited = read.split(",");
                    
                    //we now need to separate the different fields that will go into each Student object
                    //these are 3 String fields and one array of ints
                    
                    int[] answersTrans = new int[20]; 
                    for(int i = 0; i < 20; i++)
                    {
                        answersTrans[i] = Integer.parseInt(splited[i+3]);
                    }
                    //create the new student object and assing values to its fields. 
                    studentCollection.add(new Student(splited[0], splited[1], splited[2], answersTrans)); 
                    }
}