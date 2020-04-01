package ru.vsu.lab.store.loaders;

import com.opencsv.CSVReader;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;
import ru.vsu.lab.store.entities.Division;
import ru.vsu.lab.store.entities.Person;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * Class for loading csv file
 */
public class CSVLoader {

    /**
     * Set of cashed divisions
     */
    private List<IDivision> cashedDivision = new ArrayList<>();

    /**
     * @param filePath path for loading file
     * @param repository loadable repository
     */
    public void loadCSVFile(String filePath, IRepository repository){
        CSVReader reader = null;
        final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            reader = new CSVReader(new FileReader(filePath), ';');
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                IDivision division = new Division(cashedDivision.size(), line[4]);
                if (!hasDivisionInCash(division))
                    cashedDivision.add(division);
                IDivision currentDivision= getDivisionFromCash(division);
                repository.add(new Person(Integer.parseInt(line[0]), line[1], line[1], Gender.valueOf(line[2].toUpperCase()), LocalDate.parse(line[3], DATE_FORMAT), currentDivision, new BigDecimal(line[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**Function for check repository in cash
     * @param division checked division
     * @return is division in cash
     */
    private boolean hasDivisionInCash(IDivision division){
        return cashedDivision.contains(division);
    }

    /**Function to get division from cash
     * @param division division
     * @return division from cash
     */
    private IDivision getDivisionFromCash(IDivision division){
        for (IDivision d :cashedDivision)
        {
            if (d.equals(division))
                return d;
        }
        return null;
    }
}
