package Builder.impl;

import Builder.AbstractStringBuilder;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AbstractStringBuilderImpl implements AbstractStringBuilder {
    String string;

    public void build(){
        try {
            File file = new File("data.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);

            this.string = new String(byteArray);
        }
        catch (Exception e){

        }
    }

    public String getString() {
        return string;
    }

}
