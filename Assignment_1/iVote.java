import java.util.*;

class iVote
{
	private Hashtable<String, ArrayList<String>> VotedSet; // keys are student ID's, values are all their votes
	private Hashtable<String, Integer> VoteStat; // keys are all of the answers, values atre couts of each answer
	private Question question;
	private ArrayList<String> choices;
	
	// Just initializes set of students that voted, along with their votes and question
	// Also initializes the sts keeping hash set answers are keys and 
	// value is count.
	iVote(Question question)
	{
		this.question = question;
		choices = this.question.getChoices();
		VotedSet = new Hashtable<String,  ArrayList<String>>();
		VoteStat = new Hashtable<String, Integer>();
		for(String key : choices)
		{
			VoteStat.put(key, 0);
		}
	}
	
	// first get students answer. then checks if it is a forst vote.
	// if it is, then the student is added to Voted Set.
	// Then each of students answers is added to VoteStat.
	// If ansewr does not exsist, then it is added.
	void vote(Student stu)
	{
		ArrayList<String> vote = stu.AnswerQuestion(question);
		if(VotedSet.containsKey(stu.getID()))
		{
			removeVote(stu);
		}
		else
		{
			VotedSet.put(stu.getID(), vote);
		}
		for(int i = 0; i < vote.size(); i++)
		{
			VoteStat.put(vote.get(i), VoteStat.get(vote.get(i)) + 1);
		}
	}
	
	//prints vote statistic
	void printVoteStat()
	{
		for(String key : choices)
		{
			System.out.println("\"" + key + "\" vote(s): " + VoteStat.get(key));
		}
	}
	
	// decrements each VoteStat entrance that student has voted in
	private void removeVote(Student stu)
	{
		for(int i = 0; i < VotedSet.get(stu.getID()).size(); i ++)
		{
			VoteStat.put(VotedSet.get(stu.getID()).get(i), VoteStat.get(VotedSet.get(stu.getID()).get(i)) - 1);
		}
	}
}