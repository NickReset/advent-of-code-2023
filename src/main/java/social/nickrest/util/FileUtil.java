package social.nickrest.util;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

@UtilityClass
public class FileUtil {

    public InputStream getInputStream(String path) {
        try {
            InputStream stream = FileUtil.class.getResourceAsStream(path);

            if(stream == null) {
                throw new RuntimeException(String.format("File not found: %s", path));
            }

            return stream;
        } catch (Exception e) {
            throw new RuntimeException(String.format("File not found: %s", path), e);
        }
    }

    public String getContent(InputStream stream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                builder.append(line);

                if(reader.ready()) {
                    builder.append("\n");
                }
            }

            return builder.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error reading file", e);
        }
    }
}
