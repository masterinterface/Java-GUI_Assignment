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
public class CorrectAnswers 
{
    private int[] correct;
    //values used to increment student's final exam result eg when answers correct +1, incorrect-.25, and no answer given 0.
    private final double CORRECT = 1, INCORRECT = -0.25, NOANSWER = 0;  
    
    /**
     *
     * @return
     */
    public int[] getCorrect()
    {
        return correct;
    }
    
    /**
     *
     * @return
     */
    public double getCORRECT()
    {
        return CORRECT;
    }
    
    /**
     *
     * @return
     */
    public double getINCORRECT()
    {
        return INCORRECT;
    }   
    
    /**
     *
     * @return
     */
    public double getNOANSWER()
    {
        return NOANSWER;
    }    
    
    /**
     *
     * @param correct
     */
    public void setCorrect(int[] correct)
    {
        this.correct = correct;
    }            

}
