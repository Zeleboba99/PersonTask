import ru.vsu.lab.store.factory.LabFactory;
import ru.vsu.lab.store.jaxb.ObjectToXml;
import ru.vsu.lab.store.loaders.CSVLoader;
import ru.vsu.lab.store.repository.GenericRepository;
import ru.vsu.lab.store.stream.PeopleStreams;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        String filePathCSV = "./src/main/resources/persons.csv";
        GenericRepository genericRepository = new GenericRepository();
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.loadCSVFile(filePathCSV, genericRepository);
        ObjectToXml.repositoryToXml(genericRepository);
    }
}
