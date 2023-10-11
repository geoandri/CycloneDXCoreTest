package org.example;

import org.cyclonedx.BomParserFactory;
import org.cyclonedx.exception.ParseException;
import org.cyclonedx.generators.json.BomJsonGenerator15;
import org.cyclonedx.model.Bom;
import org.cyclonedx.model.Component;
import org.cyclonedx.model.Metadata;
import org.cyclonedx.model.Tool;
import org.cyclonedx.model.metadata.ToolInformation;
import org.cyclonedx.parsers.Parser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

        Bom bom = new Bom();
        Metadata metadata = new Metadata();
        Component component = new Component();
        component.setName("test");
        component.setVersion("1.0");
        component.setGroup("org.example");
        component.setType(Component.Type.APPLICATION);


        ToolInformation toolInformation = new ToolInformation();
        List components = new ArrayList<Component>();
        components.add(component);
        toolInformation.setComponents(components);

        metadata.setToolChoice(toolInformation);

        bom.setMetadata(metadata);


        String jsonFIle = new BomJsonGenerator15(bom).toJsonString();

        System.out.println(jsonFIle);
    }
}