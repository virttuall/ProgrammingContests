package uva;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uva_59_SearchingQuickly {
static class Word implements Comparable<Word>
{
	String word;
	int indexTitle;
	int indexInTitle;
	@Override
	public int compareTo(Word o)
	{
		int result = word.compareTo(o.word);
		if ( result != 0) return result;
		result = new Integer(indexTitle).compareTo(o.indexTitle);
		if ( result != 0) return result;
		return new Integer(indexInTitle).compareTo(o.indexInTitle);
	}
	public Word(String word, int indexTitle, int indexInTitle)
	{
		this.word = word;
		this.indexTitle = indexTitle;
		this.indexInTitle = indexInTitle;
	}
	public String toString()
	{
		return word;
	}
}
static boolean contain(String word, String[] words, int length)
{
	for ( int i = 0; i < length; i++ ) if ( words[i].equals(word)) return true;
	return false;
}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[], wordsToIgnore[] = new String[100], titles[][] = new String[400][];
	int countWordsI = 0, countTitles = 0, count = 0;
	Word words[] = new Word[8000], aux;
	while (!(line = in.readLine()).equals("::")) {
		wordsToIgnore[countWordsI++] = line;
	}
	while ( (line = in.readLine()) != null  && !line.equals("")) {
		titles[countTitles++] = line.toLowerCase().split("\\s+");
	}
	for ( int i = 0; i < countTitles; i++ )
	{
		for ( int j = 0; j < titles[i].length; j++ )
		{
			if ( !contain(titles[i][j], wordsToIgnore, countWordsI))
			{
				words[count++] = new Word(titles[i][j], i, j);
			}
		}
	}
	Arrays.sort(words, 0, count);
	for ( int i = 0; i < count; i++ )
	{
		aux = words[i];
		line = "";
		for ( int j = 0; j < titles[aux.indexTitle].length; j++ )
		{
			if ( j == aux.indexInTitle )
			{
				line += aux.word.toUpperCase();
			}
			else
			{
				line += titles[aux.indexTitle][j];
			}
			if ( j != titles[aux.indexTitle].length - 1)
				line += " ";
				
		}
		out.append(line+"\n");
	}
	System.out.print(out);
}
}
