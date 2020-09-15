package com.lockedMe.actions.exe;

//import java.util.List;
import java.util.Map;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
//import java.util.Collections;
//import java.util.Comparator;

import com.lockedMe.actions.FileActions;
import com.lockedMe.exceptions.FileExceptions;
import com.lockedMe.file.File;

public class ActionExecution implements FileActions {
	
	private static Map<String, File> fileMap = new HashMap<>();
//	private List<HashMap<String, File>> files = new ArrayList<>();
//	private static int count;
	private static File searchedFile;
	
//	File f1 = new File();//, f2, f3, F1, F2, f11, F11, file0;
//	f1.setName("f1");

	@Override
	public File addFile(File file) throws FileExceptions {
		if(searchFile(file.getName())) {
			System.out.println(file.getName());
			throw new FileExceptions(file.getName()+" named file already exists");
		}
		System.out.println(file.getName());
		fileMap.put(file.getName(), file);
		return file;
	}

	@Override
	public boolean searchFile(String fname) throws FileExceptions {
		if(!fileMap.containsKey(fname)) {
//			throw new FileExceptions(fname+" named file not found, Check case");
			return false;
		}
		searchedFile = fileMap.get(fname);
		System.out.println(fname+" is found with following details:\n"+searchedFile);
		return true;
	}

	@Override
	public void deleteFile(String fname) throws FileExceptions {
		if(!searchFile(fname)) {
			throw new FileExceptions(fname+" named file does not exist");
		}
		fileMap.remove(fname,searchedFile);
		System.out.println(fname+" has been deleted");
	}
	
	public static void displayFiles() throws FileExceptions{
		if(fileMap.size()==0) {
			throw new FileExceptions("There are currently no files");
		}
//		Map<String, File> sorted = new HashMap<>();
//		sorted = fileMap.entrySet().stream().sorted(comparingByKey()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
//		for(Map<> f: fileMap.values()) {
//			System.out.println(f);
//		}
//		System.out.println(fileMap.entrySet());//.values());
		TreeMap<String, File> sorted = new TreeMap<>();
		sorted.putAll(fileMap);
		for(Map.Entry<String,File> itr: sorted.entrySet()) {
			System.out.println(itr.getValue());
//			System.out.println(itr.getKey());
		}
		
	}

}
