/*
 * The MIT License
 *
 * Copyright 2016 PoVALE Team.
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
import java.io.IOException;
import java.io.InputStream;



/**
 * This class represents a file or directory of a given file system.
 * 
 * @author PoVALE Team.
 */
public interface FileEntity extends Entity {
    /**
     * It Returns the name of the file.
     * 
     * @return file name
     */
    public String getName();
    
    /**
     * It returns the name of the file (without extension).
     * 
     * @return base name
     */
    public String getBaseName();
    
    /**
     * It returns the extension of the file.
     * 
     * @return extension of the this object
     */
    public String getExtension();
    
    /**
     * It returns an input stream for accessing the contents of the file.
     * 
     * @return contents of the file.
     */
    public InputStream getContents() throws IOException;
}
