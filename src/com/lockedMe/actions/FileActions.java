package com.lockedMe.actions;

//import java.util.List;

import com.lockedMe.exceptions.FileExceptions;
import com.lockedMe.file.File;

public interface FileActions {
	
	public File addFile(File file) throws FileExceptions;
	public boolean searchFile(String fname) throws FileExceptions;
	public void deleteFile(String fname) throws FileExceptions;
//	public static void displayFiles() throws FileExceptions {
//	}

}
