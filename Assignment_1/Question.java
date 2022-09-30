import java.util.*;
import java.lang.Math;

class Question
{
	private String questionString;
	private ArrayList<String> rightAnswers, wrongAnswers, scramble;
	
	// Sets question, right answers, wrong answers. Creates a scramble, a random set of 
	// all righ and wrong answers, used for menue creation and giving a random ArrayList
	// to Students to answer.
	Question(String questionString, ArrayList<String> rightAnswers, ArrayList<String> wrongAnswers)
	{
		this.questionString = questionString;
		this.rightAnswers = (ArrayList<String>)rightAnswers.clone();
		this.wrongAnswers = (ArrayList<String>)wrongAnswers.clone();
		scramble = new ArrayList<String>();
		for(int i = 0; i < this.rightAnswers.size() + this.wrongAnswers.size(); i++)
		{
			int randNum = (int)(Math.random() * (rightAnswers.size() + wrongAnswers.size()));
			if(randNum >= rightAnswers.size())
			{
				scramble.add("" + (char)(i + 65) + ". " + wrongAnswers.remove(randNum - rightAnswers.size()));
			}
			else
			{
				scramble.add("" + (char)(i + 65) + ". " + rightAnswers.remove(randNum));
			}
		}
	}
	
	// retuns a random set of all answers
	ArrayList getChoices()
	{
		return scramble;
	}
	
	// returns amout of right answers. Used for more accurate guesses
	int getRightAnswerCount()
	{
		return rightAnswers.size();
	}
	
	public String toString()
	{
		String result = questionString + "\n";
		for(int i = 0; i < scramble.size(); i++)
		{
			result += "     " + scramble.get(i) + "\n";
		}
		return result;
	}
}