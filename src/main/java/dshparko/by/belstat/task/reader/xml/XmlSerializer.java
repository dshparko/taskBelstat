package dshparko.by.belstat.task.reader.xml;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dshparko.by.belstat.task.reader.Reader;
import dshparko.by.belstat.task.reader.xml.models.ListWrapper;

import java.io.*;

public class XmlSerializer implements Serializer, Reader {

    class BooleanDeserializer extends StdDeserializer<Boolean> {

        protected BooleanDeserializer() {
            super(Boolean.class);
        }

        @Override
        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            return jsonParser.getValueAsInt() == 1;
        }
    }

    XmlMapper xmlMapper = new XmlMapper();


    @Override
    public void fileRead(String filename) throws IOException {
        File file = new File(filename);
        InputStream is= new FileInputStream(file);
        System.out.println(inputStreamToString(is));


    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "windows-1251"));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


    private void registerCustomBooleanDeserializer() {
        SimpleModule module = new SimpleModule("configModule", com.fasterxml.jackson.core.Version.unknownVersion());
        module.addDeserializer(Boolean.class, new BooleanDeserializer());
        xmlMapper.registerModule(module);
    }

    private void registerCustomBooleanSerializer() {
        //TODO
    }

    public <T> T deserialize(InputStream inputStream, Class<T> valueType) throws IOException {
        return deserialize(inputStreamToString(inputStream), valueType);
    }

    public <T> T deserialize(String xmlString, Class<T> valueType) throws JsonProcessingException {
        return xmlMapper.readValue(xmlString, valueType);
    }

    public <T> String serialize(T Value) {

        return "";
    }

    public <T> void serialize(T Value, OutputStream outputStream) {
        //TODO
    }


    public XmlSerializer() {
        registerCustomBooleanSerializer();
        registerCustomBooleanDeserializer();
    }
}
