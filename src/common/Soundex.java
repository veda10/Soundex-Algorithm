package common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Soundex {
	
	class FreqAndId{
		private int freq;
		private List<Integer> postingList;
		
		public FreqAndId() {
			// TODO Auto-generated constructor stub
			freq = 0;
			postingList = new ArrayList<Integer>();
		}
		private void addFreq() {
			freq ++;
		}
		private void adddocId(int id) {
			postingList.add(id);
			postingList.sort(null);
		}
	}
	
	public Map<String,FreqAndId> dir; 
	public Map<String, ArrayList<String>> soundex;
	static Formatter formatter = new Formatter(System.out);
	
	public Soundex() {
		
		dir = new TreeMap<String,FreqAndId>(new Comparator<String>(){
             public int compare(String o1, String o2) {
               
            	 	o1 = o1.toLowerCase();
            	 	o2 = o2.toLowerCase();
                 if (o1 == null || o2 == null)
                     return 0; 
                return String.valueOf(o1).compareTo(String.valueOf(o2));
             }
		 });
		soundex = new TreeMap<String, ArrayList<String>>();
	}
	public String setSoundex(String term) {
		int i;
		//String t = term;
		term = term.toLowerCase();
		for(i=1;i<term.length();i++) {
			char c = term.charAt(i);
			if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'|| c == 'h'|| c == 'w'|| c == 'y')
				term = term.substring(0, i)+"0"+term.substring(i+1);
			else if(c == 'b' || c == 'f'|| c == 'p'|| c == 'v')
				term = term.substring(0, i)+"1"+term.substring(i+1);
			else if(c == 'c' || c == 'g'|| c == 'j'|| c == 'k'|| c == 'q'|| c == 's'|| c == 'x'|| c == 'z')
				term = term.substring(0, i)+"2"+term.substring(i+1);
			else if(c == 'd' || c == 't')
				term = term.substring(0, i)+"3"+term.substring(i+1);
			else if(c == 'l' )
				term = term.substring(0, i)+"4"+term.substring(i+1);
			else if(c == 'm' || c == 'n')
				term = term.substring(0, i)+"5"+term.substring(i+1);
			else if(c == 'r' )
				term = term.substring(0, i)+"6"+term.substring(i+1);
		}
		for(i=1;i<term.length()-1;i++) {
			if(term.charAt(i) == term.charAt(i+1))
				term = term.substring(0, i)+term.substring(i+1);
		}
		for(i=1;i<term.length();i++) {
			if(term.charAt(i) == '0')
				term = term.substring(0, i)+term.substring(i+1)+"000";
		}
		
		return term.substring(0,4);
	}
	
	public String Insert(String term,int docID) {
		if(!dir.containsKey(term)) {
			FreqAndId fId = new FreqAndId();
			fId.addFreq();
			fId.adddocId(docID);
			dir.put(term, fId);
		}
		else {
			FreqAndId fId = dir.get(term);
			if(!fId.postingList.contains(docID)) {
				fId.addFreq();
				fId.adddocId(docID);
				dir.put(term, fId);
			}
		}
		/****************************/
		System.out.println("$");
		String code = setSoundex(term);
		System.out.println(term + " code =  "+code);
		
		if(!soundex.containsKey(code)) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(term);
			soundex.put(code, list);
		}
		else {
			ArrayList<String> list = soundex.get(code);
			if(!list.contains(term)) {
				list.add(term);
				soundex.put(code, list);
			}
		}
		return code;
	}
	public void search(String s) {
		String code = setSoundex(s);
		if(soundex.containsKey(code)) {
			System.out.println("The search result:");
			for(String ss : soundex.get(code)) {	
				System.out.print("term:" + ss +" ");
				FreqAndId fId = dir.get(ss);
				formatter.format("freq:%-5s",fId.freq);
				 for (int tmp : fId.postingList) { 
					    System.out.print("-->"); 
						formatter.format("%-1s",tmp);  
				 }
				 System.out.println();
			}
		}else {
			System.out.println("no search!");
		}
	}
	
	public void print() {
		System.out.println();
		formatter.format("%-10s %-10s %-10s\n", "term", "doc.freq", "posting lists");
		for (String s : dir.keySet()) {
			formatter.format("%-15s",s);
				FreqAndId fId = dir.get(s);
				formatter.format("%-10s",fId.freq);
				 for (int tmp : fId.postingList) { 
					    System.out.print("-->"); 
						formatter.format("%-1s",tmp);  
			        }
				  System.out.println(""); 
			}
	}	
	public static void main(String[] args) {	
		Soundex br = new Soundex();
		br.Insert("Herman", 2);	
		br.Insert("Herman", 3);	
		br.Insert("Herman", 4);	
		br.Insert("Herman", 5);		
		br.Insert("erman", 9);	
		br.Insert("Hrman", 18);	
		br.Insert("Hermn", 10);
		//br.print();
		
		System.out.println();
		br.search("herman");
	}
}