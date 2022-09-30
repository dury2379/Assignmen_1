import java.util.*;
import java.lang.Math;

public class SimulationDriver {
	
	private static Student[] students;
	private static iVote VotingService;
	private static Question question;
	
	public static void main(String[] args){
		students = new Student[30];
		for(int i = 0; i < students.length; i++)		// initialise students array
		{
			students[i] = new Student(generateID(10));
		}
		
		if((int)(Math.random() * 2) == 1)		// randomly choose multiple right answer or single
		{
			ArrayList right = new ArrayList<String>();
			right.add("1945");
			ArrayList wrong = new ArrayList<String>();
			wrong.add("1776");
			wrong.add("1865");
			wrong.add("1939");
			question = new Question("When did WWII ended?", right, wrong);
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
			question = new Question("Select even numbers.", right, wrong);
		}
		
		
		VotingService = new iVote(question);
		
		System.out.println(question);
		
		for(int i = 0; i < students.length; i++)		// let evety student vote
		{
			VotingService.vote(students[i]);
		}
		
		System.out.println("Stat prior to double-vote: ");
		VotingService.printVoteStat();	
		
		for(int i = 0; i < students.length; i++)		// random second voting (50/50)
		{
			if((int)(Math.random() * 2) == 1)
			{
				VotingService.vote(students[i]);
			}
		}
		
		System.out.println("Stat post to double-vote: ");
		VotingService.printVoteStat();	
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