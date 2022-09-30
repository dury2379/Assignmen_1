import java.util.*;
import java.lang.Math;

public class SimulationDriver {
	
	private static Student[] students;
	// private VotingService iVote;
	private static Question qestion;
	
	public static void main(String[] args){
		students = new Student[30];
		for(int i = 0; i < 30; i++)
		{
			students[i] = new Student(generateID(10));
		}
		
		if((int)(Math.random() * 2) == 1)
		{
			ArrayList right = new ArrayList<String>();
			right.add("1945");
			ArrayList wrong = new ArrayList<String>();
			wrong.add("1776");
			wrong.add("1865");
			wrong.add("1939");
			qestion = new Question("When did WWII ended?", right, wrong);
		}
		else
		{
			ArrayList right = new ArrayList<String>();
			right.add("10");
			right.add("26");
			ArrayList wrong = new ArrayList<String>();
			wrong.add("15");
			wrong.add("7");
			wrong.add("9");
			qestion = new Question("Select even numbers.", right, wrong);
		}
		
		System.out.println(qestion);
	}
	
	
	// generates ID of set length (len). It contains capital letters (A - Z) and numbers (0 - 9).
	private static String generateID(int len)
	{
		String result = "";
		for(int i = 0; i < len; i++)
		{
			int randNum = (int)(Math.random() * 36) + 48;
			if(randNum > 57)
			{
				randNum += 7;
			}
			
			result += "" + (char)randNum;
		}
		return result;
		
	}
}