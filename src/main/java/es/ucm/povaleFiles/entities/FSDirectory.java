/*
 * The MIT License
 *
 * Copyright 2016 PoVALE team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.ucm.povaleFiles.entities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author manuel
 */
public class FSDirectory extends FSFile implements Directory {

    public FSDirectory(Path path) {
        super(path);
    }

    @Override
    public List<File> children() {
        try {
            List<File> result = new LinkedList<>();
            
            DirectoryStream<Path> children = Files.newDirectoryStream(path);
            for (Path p : children) {
                if (Files.isDirectory(p)) {
                    result.add(new FSDirectory(p));
                } else {
                    result.add(new FSFile(p));
                }
            }
            return result;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<File> childrenRec() {
        try {
            return Files.walk(path)
                    .map(p -> {
                        if (Files.isDirectory(p)) {
                            return new FSDirectory(p);
                        } else {
                            return new FSFile(p);
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<File> files() {
        try {
            List<File> result = new LinkedList<>();
            DirectoryStream<Path> children = Files.newDirectoryStream(path,
                    p -> !Files.isDirectory(p));
            children.forEach(p -> result.add(new FSFile(p)));
            return result;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    

    @Override
    public List<File> filesRec() {
        try {
            return Files.walk(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> new FSFile(p))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    
}
