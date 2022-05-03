package com.osiris.autoplug.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemLoopException;

public class UtilsFiles {

    /**
     * Force deletes the provided directory or file recursively.
     */
    public void forceDeleteDirectory(File dir) throws IOException {
        if (!dir.exists()) return;
        if (!dir.isDirectory()) {
            forceDeleteFile(dir);
            return;
        }

        // Delete all sub-directories and wait until all of them are actually deleted
        File[] files = dir.listFiles();
        while (files != null && files.length > 0) {
            for (File f :
                    files) {
                forceDeleteDirectory(f);
            }
            files = dir.listFiles(); // Update the existing files array
        }
        forceDeleteFile(dir); // Empty dir
    }

    /**
     * Tries deleting the provided file 100000 times, and throws {@link FileSystemLoopException} if it fails.
     */
    public void forceDeleteFile(File file) throws FileSystemLoopException {
        if(!file.exists()) return;
        for (int i = 0; i < 100000; i++) {
            if (file.delete()) return;
        }
        throw new FileSystemLoopException("Failed to delete file after trying 100000 times: " + file);
    }
}