package dshparko.by.belstat.task.reader.xml;


import java.io.IOException;
import java.io.InputStream;

public interface Serializer {

    <T> String serialize(T Value);

    <T> T deserialize(InputStream inputStream, Class<T> valueType) throws IOException;
}