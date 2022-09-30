import java.util.*;
import java.lang.Math;

class Student
{
	private String ID;
	
	// simple constructor, Just stores the id
	Student(String ID)
	{
		this.ID = ID;
	}
	
	// returns ID
	String getID()
	{
		return ID;
	}
	
	// vote function takes in a question and returns random answer(s).
	// if we have multiple right answers I assume that students can 
	// guestimate the number of right answers and will produce
	// same number of answers
	ArrayList<String> AnswerQuestion(Question q)
	{
		ArrayList result = new ArrayList<String>();
		ArrayList choices = (ArrayList<String>)q.getChoices().clone();
		int numOfAnswers = q.getRightAnswerCount();
		for(int i = 0; i < numOfAnswers; i++)
		{
			int randNum = (int)(Math.random() * choices.size());
			result.add(choices.remove(randNum));
		}
		return result;
	}
}