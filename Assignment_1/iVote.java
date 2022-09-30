import java.util.*;

class iVote
{
	private Hashtable<String, ArrayList<String>> VotedSet; // keys are student ID's, values are all their votes
	private Hashtable<String, Integer> VoteStat; // keys are all of the answers, values atre couts of each answer
	
	// Just initializes set of students that voted, along with their votes
	// Also initializes the sts keeping hash set answers are keys and 
	// value is count.
	iVote()
	{
		VotedSet = new Hashtable<String, String>();
		VoteStat = new Hashtable<String, Integer>();
	}
	
	// first get students answer. then checks if it is a forst vote.
	// if it is, then the student is added to Voted Set.
	// Then each of students answers is added to VoteStat.
	// If ansewr does not exsist, then it is added.
	void vote(Student stu, Question q)
	{
		ArrayList<String> vote = stu.AnswerQuestion(q);
		if(VotedSet.containsKey(stu.getID()))
		{
			removeVote(stu);
		}
		else
		{
			VotedSet.put(stu.getID(), vote)
		}
		for(int i = 0; i < vote.size(); i++)
		{
			if(VoteStat.containsKey(vote.get(i)))
			{
				VoteStat.put(vote.get(i), VoteStat.get(vote.get(i)) + 1);
			}
			else
			{
				VoteStat.put(vote.get(i), 1);
			}
		}
	}
	
	void printVoteStat()
	{
		Set<String> keys = VoteStat.keySet();
		for(String key : keys)
		{
			System.out.println(VoteStat.get(
		}
	}
	
	// decrements each VoteStat entrance that student has voted in
	private void removeVote(Student stu)
	{
		for(int i = 0; i < VotedSet.get(stu.getID()).size(); i ++)
		{
			VoteStst.put(VotedSet.get(stu.getID()).get(i), VoteStst.get(VotedSet.get(stu.getID()).get(i)) - 1);
		}
	}
}