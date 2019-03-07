package common;
import java.util.ArrayList;

import java.io.IOException;
import java.nio.file.Paths;
 
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
 
public class LuceneReadIndexFromFileExample
{
    //directory contains the lucene indexes
    private static final String INDEX_DIR = "indexedFiles";
 
    public static String main(String sc,int a) throws Exception
    {
        //Create lucene searcher. It search over a single IndexReader.
    	//if a is 1 -> soundex
    	//else a is 0 -> without soundex
        IndexSearcher searcher = createSearcher();
        ArrayList<String> wordList = new ArrayList<String>();
       String query = sc;
       if(a==1 && ParserTest.noun_size==0) {
	       wordList=sr.StopRem(query);
	        //Total found documents
	         String c,os="";
	 	    //sr sound = new sr();
	 	    for (String str : wordList){
	 	    	c="";
	 	    	c=sr.getGode(str);
	 	    	os=os+' '+c;
	 	    }
	 	    query=os;
 	    }
 	   TopDocs foundDocs = searchInContent(query, searcher);
        System.out.println("Total Results :: " + foundDocs.totalHits);
         
       
        String output;
        //System.out.println(output);
        if(foundDocs.totalHits==0)
        	output="NO RESULTS FOUND\n";
        else {
        	output="Total Results :: \nFile Names :\n";
        //Let's print out the path of files which have searched term
        for (ScoreDoc sd : foundDocs.scoreDocs)
        {
            Document d = searcher.doc(sd.doc);
            System.out.println("Path : "+ d.get("path") + ", Score : " + sd.score);
            output = output + "Path : "+ d.get("path") + ", Score : " + sd.score+"\n";
            
        }}
        //System.out.println(output);
        return output;
    }
     
    private static TopDocs searchInContent(String textToFind, IndexSearcher searcher) throws Exception
    {
        //Create search query
        QueryParser qp = new QueryParser("contents", new StandardAnalyzer());
        Query query = qp.parse(textToFind);
         
        //search the index
        TopDocs hits = searcher.search(query, 10);
        return hits;
    }
 
    private static IndexSearcher createSearcher() throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
         
        //It is an interface for accessing a point-in-time view of a lucene index
        IndexReader reader = DirectoryReader.open(dir);
         
        //Index searcher
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }

}