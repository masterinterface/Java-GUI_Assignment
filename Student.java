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
public class Student extends Person implements Comparable<Student>
{
    private String studentId;
    private int[] answers = new int[20];
    private double result;
    
    /**
     *
     * @param studentId
     * @param lastName
     * @param firstName
     * @param answers
     */
    public Student(String studentId, String lastName, String firstName, int[] answers)
    {
        this.studentId =  studentId;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.answers = answers; 
    }
    
    /**
     *
     * @return
     */
    public String getStudentId()
    {
        return studentId;
    }
    
    /**
     *
     * @return
     */
    public int[] getAnswers()
    {
        return answers;
    }
    
    /**
     *
     * @return
     */
    public double getResult()
    {
        return result;
    }        
            
    /**
     *
     * @param studentId
     */
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    
    /**
     *
     * @param answers
     */
    public void setAnswers(int[] answers)
    {
        this.answers = answers;
    }
            
    /**
     *
     * @param result
     */
    public void setResult(double result)
    {
        this.result = result;
    }
    
    @Override
    public int compareTo(Student other)
    {
        return this.getLastName().compareTo(other.getLastName());
    }

    
}   

