package common;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class sr {
	static Set<String> stopWordsSet = new HashSet<String>();
	static ArrayList<String> wordsList = new ArrayList<String>();
	public static String getGode(String s)
    {
        char[] x = s.toUpperCase().toCharArray();
         
         
        char firstLetter = x[0];
 
        //RULE [ 2 ]
        //Convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
            case 'B':
            case 'F':
            case 'P':
            case 'V': {
                x[i] = '1';
                break;
            }
 
            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z': {
                x[i] = '2';
                break;
            }
 
            case 'D':
            case 'T': {
                x[i] = '3';
                break;
            }
 
            case 'L': {
                x[i] = '4';
                break;
            }
 
            case 'M':
            case 'N': {
                x[i] = '5';
                break;
            }
 
            case 'R': {
                x[i] = '6';
                break;
            }
 
            default: {
                x[i] = '0';
                break;
            }
            }
        }
 
        //Remove duplicates
        //RULE [ 1 ]
        String output = "" + firstLetter;
         
        //RULE [ 3 ]
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                output += x[i];
 
        //RULE [ 4 ]
        //Pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }
	public static ArrayList<String> StopRem(String s)
	{
		String[] words = s.split(" ");
	    for(String word : words)
	    {
	        String wordCompare = word.toUpperCase();
	        if(!sr.stopWordsSet.contains(wordCompare))
	        {
	            sr.wordsList.add(word);
	        }
	    }
	    return wordsList;
	}
	
	public static void main() throws IOException {
		//int k=0,i;
		
		
		String sCurrentLine;
		
		FileReader fr=new FileReader("C:\\Users\\chakr_000\\eclipse-workspace\\IR_1\\stopwords.txt\\");
        BufferedReader br= new BufferedReader(fr);
        while ((sCurrentLine = br.readLine()) != null){
        	stopWordsSet.add(sCurrentLine);
        }
		
		File dir = new File("C:\\Users\\chakr_000\\eclipse-workspace\\IR_1\\inputfiles\\");
        //get all the files from a directory
        File[] fList = dir.listFiles();
        int a=1;
        for (File file : fList){
        	String s="",os="";
        	
          //  System.out.println(file.getName());
            FileReader f=new FileReader("C:\\Users\\chakr_000\\eclipse-workspace\\IR_1\\inputfiles\\"+file.getName());
            BufferedReader br1= new BufferedReader(f);
            while ((sCurrentLine = br1.readLine()) != null){
                //stopwords[k]=sCurrentLine;
                 //k++;
            	s=s+sCurrentLine;
            }
            br1.close();
           wordsList = StopRem(s);
    	    String c;
    	    //sr sound = new sr();
    	    for (String str : wordsList){
    	    	//System.out.println(str);
    	    	c="";
    	    	c=sr.getGode(str);
    	    	os=os+' '+c;
    	    }
    	    
    	    wordsList.clear();
    	    File file1 = new File("C:\\Users\\chakr_000\\eclipse-workspace\\IR_1\\outputfiles\\"+file.getName());
    	    
    	  //Create the file
    	  
    	  //Write Content
    	  FileWriter writer = new FileWriter(file1);
    	  writer.write(os);
    	  os="";
    	//  System.out.println("yes");
    	  writer.close();
    	  a++;
    	  br.close();
    	  
        }       
        
	}
}

