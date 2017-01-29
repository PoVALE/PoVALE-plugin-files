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

import es.ucm.povale.entity.Entity;
import java.nio.file.Path;

/**
 * Instances of this class represent physical files in the current file system.
 * 
 * @author manuel
 */
public class FSFile implements File  {
    protected final Path path;

    public FSFile(Path path) {
        this.path = path;
    }

    @Override
    public String getName() {
        return path.getFileName().toString();
    }

    @Override
    public String getBaseName() {
        String fileName = path.getFileName().toString();
        int lastDotIndx = fileName.lastIndexOf(".");
        if (lastDotIndx == -1) {
            return fileName;
        } else {
            return fileName.substring(0, lastDotIndx);
        }
    }

    @Override
    public String getExtension() {
        String fileName = path.getFileName().toString();
        int lastDotIndx = fileName.lastIndexOf(".");
        if (lastDotIndx == -1) {
            return "";
        } else {
            return fileName.substring(lastDotIndx + 1);
        }
    }
    
    public static void main(String[] args) {
        Entity e = new FSFile(null);
    }
    

}
