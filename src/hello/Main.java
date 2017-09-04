package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {

	static int count=0;
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		String filepath="/Users/i079889/Documents/workspace/ASEDOJO/src/hello/Main.java";
		System.out.println("Code lines of current file is "+getCodeLinesOfSource(filepath));
		filepath="/Users/i079889/Documents/workspace/ASEDOJO/src/hello/whitespaceandcommentstest.java";
		System.out.println("Code lines of "+"whitespaceandcommentstest.java is "+getCodeLinesOfSource(filepath));
		filepath="/Users/i079889/Documents/workspace/ASEDOJO/src/hello/Emptyfiletest.java";
		System.out.println("Code lines of "+"Emptyfiletest.java is "+getCodeLinesOfSource(filepath));
		
        File path = new File("/Users/i079889/git/gradle-aafsystem-module/src/main/java/com/successfactors/aaf/tests/system/odata");
        search(path);
        
        System.out.println(count+" java files so far!");
	}

	//this is for testing
	/**
	 * Main method to test
	 * @param filepath
	 * @return
	 */
	public static int getCodeLinesOfSource(String filepath) {
		String line;
		int count = 0;
		try {
			InputStream fis = new FileInputStream(filepath);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			boolean commentflag = false;
			while ((line = br.readLine()) != null) {
				String linecontext = line.trim();
				if (linecontext.matches("^[ ]*$")) {
					continue;
				} else if (linecontext.startsWith("//")) {
					continue;
				} else if (linecontext.startsWith("/*") && linecontext.endsWith("*/")) {
					continue;
				} else if (linecontext.startsWith("/*") && !linecontext.endsWith("*/")) {
					commentflag = true;
					continue;
				} else if (commentflag == true && !linecontext.endsWith("*/")) {
					continue;
				} else if (commentflag == true && linecontext.endsWith("*/")) {
					commentflag = false;
					continue;
				} else {
					count++;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
    //recursive search all .java files
    private static void search(File path) {
        File[] files = path.listFiles();
         
        //search all .java files in the directory,
        //but not include those .java files occurs in the sub-directory
        if(path.getAbsolutePath().equalsIgnoreCase("/Users/i079889/git/gradle-aafsystem-module/src/main/java/com/successfactors/aaf/tests/system/odata") ){
            listFilteredFileName(path);
        }
         
        //search all .java files in the sub-directory
        for (File file : files) {
            if (file.isDirectory()) {
            	if(file.getName().endsWith("sapui5support")||file.getName().endsWith("metadatadriven"))
            	{
            		continue;
            	}
                //File dir = file.getAbsoluteFile();
                listFilteredFileName(file);
                search(file);
            }
        }
    }
 
    //show .java files by directory
    private static void listFilteredFileName(File file) {
        String[] files = file.list(new DirFilter("\\w+.java"));
        for (String fileName: files) {
            System.out.println(fileName + " ");
            count++;
        }
    }

}
